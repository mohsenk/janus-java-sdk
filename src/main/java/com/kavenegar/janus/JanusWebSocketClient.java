package com.kavenegar.janus;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import com.kavenegar.janus.core.JanusEventListener;
import com.kavenegar.janus.core.JanusGatewayClient;
import com.kavenegar.janus.enums.JanusSessionStatus;
import com.kavenegar.janus.core.models.JanusRequest;
import com.kavenegar.janus.core.models.JanusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentLinkedDeque;

public class JanusWebSocketClient implements JanusGatewayClient, WebSocket.Listener, Runnable {

    static final Logger logger = LoggerFactory.getLogger(JanusWebSocketClient.class);


    final String uri;
    final List<JanusSession> sessions;
    final JanusEventListener listener;
    final Map<String, JanusTransaction> transactions;
    private final Gson gson;
    HttpClient httpClient;
    WebSocket webSocketClient;
    Thread thread;


    public JanusWebSocketClient(String uri, JanusEventListener listener) {
        this.uri = uri;
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        this.listener = listener;
        this.sessions = new ArrayList<>();
        this.transactions = new HashMap<>();
    }

    @Override
    public void connect() {
        this.httpClient = HttpClient.newHttpClient();
        this.webSocketClient = httpClient.newWebSocketBuilder()
                .subprotocols("janus-protocol")
                .buildAsync(URI.create(uri), this)
                .join();

        listener.onConnect();
        this.thread = new Thread(this, "Janus-Client-Worker");
        this.thread.start();
    }

    private void reconnect() {
        this.httpClient = HttpClient.newHttpClient();
        this.webSocketClient = httpClient.newWebSocketBuilder()
                .subprotocols("janus-protocol")
                .buildAsync(URI.create(uri), this)
                .join();
    }


    @Override
    public JanusTransaction send(JanusRequest request) {
        var transaction = new JanusTransaction(request.getTransaction(), false, request);
        transactions.put(transaction.getId(), transaction);
        var result = this.webSocketClient.sendText(request.toString(), true);
        logger.info("Send request : {}", request);
        return transaction;
    }


    @Override
    public CompletableFuture<JanusSession> create() {
        var callback = new CompletableFuture<JanusSession>();
        var request = new JanusRequest("create", JanusTransaction.getNewTransactionId(), null, null);
        var transaction = send(request);
        transaction.setResponseListener(response -> {
            if (response.isSuccess()) {
                var session = new JanusSession(gson, this, response.getPayload().getAsJsonObject("data").get("id").getAsLong());
                sessions.add(session);
                callback.complete(session);
            }
        });
        transaction.setErrorListener(error -> callback.completeExceptionally(new Exception(error.toString())));
        return callback;
    }

    private void handlePacket(String rawJson) {
        try {
            logger.info("Janus says : {}", rawJson);
            var json = gson.fromJson(rawJson, JsonElement.class).getAsJsonObject();
            if (json.has("transaction") && !json.get("transaction").isJsonNull()) {
                var transactionId = json.get("transaction").getAsString();
                if (transactions.containsKey(transactionId)) {
                    var transaction = transactions.get(transactionId);
                    var response = new JanusResponse(json);
                    if (response.isError() || response.isPluginError()) {
                        transaction.getErrorListener().accept(response.getError());
                    } else {
                        transaction.getResponseListener().accept(response);
                    }
                } else {
                    var response = new JanusResponse(json);
                    var session = sessions.stream().filter(s -> s.getId().equals(response.getPayload().get("session_id").getAsLong())).findAny().orElse(null);
                    listener.onRequestReceived(session, response);
                }
            } else {
                var response = new JanusResponse(json);
                var session = sessions.stream().filter(s -> s.getId().equals(response.getPayload().get("session_id").getAsLong())).findAny().orElse(null);
                listener.onRequestReceived(session, response);
            }
        } catch (Exception ex) {
            logger.error("Error in reading packet", ex);
        }
    }


    @Override
    public void run() {
        while (true) {
            try {
                sessions.removeIf(session -> session.getStatus() == JanusSessionStatus.DESTROYED);
                for (var session : sessions) {
                    session.alive();
                }
            } catch (Exception ex) {
                logger.error("", ex);
            } finally {
                sleep(30000);
            }
        }

    }


    void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            logger.error("Can't sleep in JanusWebSocketClient", e);
        }
    }

    StringBuilder bufferedMessage = new StringBuilder();

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        bufferedMessage.append(data);
        if (last) {
            handlePacket(bufferedMessage.toString());
            bufferedMessage = new StringBuilder();
        }
        webSocket.request(1);

        return new CompletableFuture().completedFuture("onText() completed.");
    }


    @Override
    public void onOpen(WebSocket webSocket) {
        webSocket.request(1);
        logger.info("WebSocket Listener has been opened for requests.");
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        logger.info("WebSocket Listener has been closed with statusCode : {} , reason : {}", statusCode, reason);
        webSocket.sendClose(statusCode, reason);
        this.reconnect();
        listener.onConnectionBroken();
        return new CompletableFuture<Void>();
    }

    @Override
    public void onError(WebSocket webSocket, Throwable error) {
        logger.error("A " + error.getCause() + " exception was thrown.", error);
        webSocket.abort();
    }

    @Override
    public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        logger.info("Ping received from janus : {}", message.asCharBuffer().toString());
        return new CompletableFuture().completedFuture("Ping completed.").thenAccept(System.out::println);
    }


    @Override
    public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        logger.info("Pong received from janus : {}", message.asCharBuffer().toString());
        return new CompletableFuture().completedFuture("Pong completed.").thenAccept(System.out::println);
    }


}
