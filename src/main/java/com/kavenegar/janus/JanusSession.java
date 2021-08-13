package com.kavenegar.janus;

import com.google.gson.Gson;
import com.kavenegar.janus.core.JanusCallback;
import com.kavenegar.janus.core.JanusGatewayClient;
import com.kavenegar.janus.enums.JanusPluginType;
import com.kavenegar.janus.enums.JanusSessionStatus;
import com.kavenegar.janus.audiobridge.AudioBridgeHandle;
import com.kavenegar.janus.core.JanusHandle;
import com.kavenegar.janus.core.models.JanusRequest;
import com.kavenegar.janus.videoroom.VideoRoomHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class JanusSession {

    Long id;
    List<JanusHandle> plugins;
    public final JanusGatewayClient client;
    private JanusSessionStatus status;
    Gson gson;

    public JanusSession(Gson gson, JanusGatewayClient client, Long id) {
        this.gson = gson;
        this.client = client;
        this.id = id;
        this.plugins = new ArrayList<>();
        this.status = JanusSessionStatus.CREATED;
    }

    public Long getId() {
        return id;
    }

    public JanusSessionStatus getStatus() {
        return status;
    }

    public CompletableFuture<JanusHandle> attach(JanusPluginType pluginName, String opaqueId) {
        var callback = new CompletableFuture<JanusHandle>();
        var request = new JanusRequest("attach", JanusTransaction.getNewTransactionId(), id, null);
        request.getPayload().addProperty("plugin", pluginName.getName());
        var transaction = client.send(request);
        transaction.setResponseListener(response -> {
            if (response.isSuccess()) {
                var handleId = response.getPayload().getAsJsonObject("data").get("id").getAsLong();
                JanusHandle janusHandle = null;
                if (pluginName == JanusPluginType.AUDIO_BRIDGE) {
                    janusHandle = new AudioBridgeHandle(gson, this, handleId, opaqueId);
                } else if (pluginName == JanusPluginType.VIDEO_ROOM) {
                    janusHandle = new VideoRoomHandle(gson, this, handleId, opaqueId);
                }
                this.plugins.add(janusHandle);
                callback.complete(janusHandle);
            }
        });
        transaction.setErrorListener(callback::obtrudeException);
        return callback;
    }

    public JanusCallback<Void> destroy() {
        var callback = new JanusCallback<Void>();
        var request = new JanusRequest("destroy", JanusTransaction.getNewTransactionId(), id, null);
        var transaction = client.send(request);
        transaction.setResponseListener(response -> {
            if (response.isSuccess()) {
                this.status = JanusSessionStatus.DESTROYED;
                callback.resolve(null);
            }
        });
        transaction.setErrorListener(error -> callback.resolve(null, error));
        return callback;
    }

    public JanusCallback<Void> alive() {
        var callback = new JanusCallback<Void>();
        var request = new JanusRequest("keepalive", JanusTransaction.getNewTransactionId(), id, null);
        var transaction = client.send(request);
        transaction.setResponseListener(response -> {
            if (response.isAck()) {
                callback.resolve(null);
            }
        });
        transaction.setErrorListener(error -> callback.resolve(null, error));
        return callback;
    }

    public Optional<JanusHandle> getHandle(String opaqueId) {
        for (var plugin : plugins) {
            if (plugin.getOpaqueId().equals(opaqueId)) return Optional.of(plugin);
        }
        return Optional.empty();
    }

    public Optional<JanusHandle> getHandle(Long handleId) {
        for (var plugin : plugins) {
            if (plugin.getId().equals(handleId)) return Optional.of(plugin);
        }
        return Optional.empty();
    }

    public List<JanusHandle> getHandles() {
        return plugins;
    }
}
