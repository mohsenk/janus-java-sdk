package com.kavenegar.janus.audiobridge;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kavenegar.janus.JanusSession;
import com.kavenegar.janus.JanusTransaction;
import com.kavenegar.janus.audiobridge.models.AudioBridgeConfigureRequest;
import com.kavenegar.janus.audiobridge.models.AudioBridgeCreateRoomRequest;
import com.kavenegar.janus.audiobridge.models.AudioBridgeJoinRequest;
import com.kavenegar.janus.enums.JanusPluginType;
import com.kavenegar.janus.core.models.*;
import com.kavenegar.janus.core.JanusHandle;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AudioBridgeHandle implements JanusHandle {

    final JanusSession session;
    final Long id;
    Long roomId;
    final String opaqueId;
    Gson gson;

    public AudioBridgeHandle(Gson gson, JanusSession session, Long id, String opaqueId) {
        this.session = session;
        this.id = id;
        this.opaqueId = opaqueId;
        this.gson = gson;
    }


    @Override
    public String getOpaqueId() {
        return opaqueId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public JanusPluginType getName() {
        return JanusPluginType.AUDIO_BRIDGE;
    }

    public CompletableFuture<Boolean> create(AudioBridgeCreateRoomRequest payload) {
        var callback = new CompletableFuture<Boolean>();
        var request = new JanusRequest("message", JanusTransaction.getNewTransactionId(), session.getId(), id);
        request.getPayload().add("body", gson.toJsonTree(payload));
        var transaction = session.client.send(request);
        transaction.setResponseListener(response -> {
            if (response.getType().equals("success")) {
                this.roomId = response.getPluginData().getAsJsonObject("data").get("room").getAsLong();
                callback.complete(true);
            }
        });
        transaction.setErrorListener(callback::obtrudeException);
        return callback;
    }

    public CompletableFuture<Boolean> join(AudioBridgeJoinRequest payload) {
        var callback = new CompletableFuture<Boolean>();
        var request = new JanusRequest("message", JanusTransaction.getNewTransactionId(), session.getId(), id);
        request.getPayload().add("body", gson.toJsonTree(payload));
        var transaction = session.client.send(request);
        transaction.setResponseListener(response -> {
            if (response.getType().equals("event")) {
                callback.complete(true);
            }
        });
        transaction.setErrorListener(callback::obtrudeException);
        return callback;
    }

    public CompletableFuture<String> configure(AudioBridgeConfigureRequest payload) {
        var callback = new CompletableFuture<String>();
        var request = new JanusRequest("message", JanusTransaction.getNewTransactionId(), session.getId(), id);
        var jsep = new JsonObject();
        jsep.addProperty("type", "offer");
        jsep.addProperty("sdp", payload.getSdp());
        request.getPayload().add("jsep", jsep);
        request.getPayload().add("body", gson.toJsonTree(Map.of("muted", payload.getMuted(), "request", payload.getRequest())));
        var transaction = session.client.send(request);
        transaction.setResponseListener(response -> {
            if (response.getType().equals("event")) {
                var result = response.getPluginData().getAsJsonObject("data").get("result").getAsString();
                var sdp = response.getPayload().getAsJsonObject("jsep").get("sdp").getAsString();
                callback.complete(sdp);
            }
        });
        transaction.setErrorListener(callback::obtrudeException);
        return callback;
    }

    public CompletableFuture<Void> trickle(IceCandidate candidate) {
        var callback = new CompletableFuture<Void>();
        var request = new JanusRequest("trickle", JanusTransaction.getNewTransactionId(), session.getId(), id);
        request.getPayload().add("candidate", gson.toJsonTree(candidate));
        var transaction = session.client.send(request);
        transaction.setResponseListener(response -> {
            if (response.isAck()) {
                callback.complete(null);
            }
        });
        transaction.setErrorListener(callback::obtrudeException);
        return callback;
    }

    public CompletableFuture<Void> trickle(Boolean completed) {
        var callback = new CompletableFuture<Void>();
        var request = new JanusRequest("trickle", JanusTransaction.getNewTransactionId(), session.getId(), id);
        request.getPayload().add("candidate", gson.toJsonTree(Map.of("completed", completed)));
        var transaction = session.client.send(request);
        transaction.setResponseListener(response -> {
            if (response.isAck()) {
                callback.complete(null);
            }
        });
        transaction.setErrorListener(callback::obtrudeException);
        return callback;
    }


}
