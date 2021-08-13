package com.kavenegar.janus.videoroom;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kavenegar.janus.JanusSession;
import com.kavenegar.janus.JanusTransaction;
import com.kavenegar.janus.enums.JanusPluginType;
import com.kavenegar.janus.core.models.*;
import com.kavenegar.janus.core.JanusHandle;
import com.kavenegar.janus.videoroom.models.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class VideoRoomHandle implements JanusHandle {

    List<JanusParticipant> participants;
    final JanusSession session;
    final Long handleId;
    Long roomId;
    String opaqueId;
    Gson gson;

    public VideoRoomHandle(Gson gson, JanusSession session, Long handleId, String opaqueId) {
        this.gson = gson;
        this.session = session;
        this.handleId = handleId;
        this.participants = null;
        this.opaqueId = opaqueId;
    }


    @Override
    public JanusPluginType getName() {
        return JanusPluginType.VIDEO_ROOM;
    }

    @Override
    public String getOpaqueId() {
        return opaqueId;
    }

    @Override
    public Long getId() {
        return handleId;
    }

    public CompletableFuture<Boolean> create(VideoRoomCreateRoomRequest payload) {
        var callback = new CompletableFuture<Boolean>();
        var request = new JanusRequest("message", JanusTransaction.getNewTransactionId(), session.getId(), handleId);
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

//    public CompletableFuture<VideoRoomJoinResponse> join(AudioBridgeJoinRequest payload) {
//        var callback = new CompletableFuture<VideoRoomJoinResponse>();
//        payload.setRoom(roomId);
//        var request = new JanusRequest("message", JanusTransaction.getNewTransactionId(), session.getId(), handleId);
//        request.getPayload().add("body", new Gson().toJsonTree(payload));
//        var transaction = session.client.send(request);
//        transaction.setResponseListener(response -> {
//            if (response.getType().equals("event")) {
//                var data = response.getPluginData().getAsJsonObject("data");
//                callback.complete(new VideoRoomJoinResponse(data));
//            }
//        });
//        transaction.setErrorListener(callback::obtrudeException);
//        return callback;
//    }

    public CompletableFuture<VideoRoomJoinResponse> join(VideoRoomJoinPublisherRequest payload) {
        var callback = new CompletableFuture<VideoRoomJoinResponse>();
        var request = new JanusRequest("message", JanusTransaction.getNewTransactionId(), session.getId(), handleId);
        request.getPayload().add("body", gson.toJsonTree(payload));
        var transaction = session.client.send(request);
        transaction.setResponseListener(response -> {
            if (response.getType().equals("event")) {
                var data = response.getPluginData().getAsJsonObject("data");
                callback.complete(gson.fromJson(data, VideoRoomJoinResponse.class));
            }
        });
        transaction.setErrorListener(callback::obtrudeException);
        return callback;
    }

    public CompletableFuture<VideoRoomJoinResponse> join(VideoRoomJoinSubscriberRequest payload) {
        var callback = new CompletableFuture<VideoRoomJoinResponse>();
        var request = new JanusRequest("message", JanusTransaction.getNewTransactionId(), session.getId(), handleId);
        request.getPayload().add("body", gson.toJsonTree(payload));
        var transaction = session.client.send(request);
        transaction.setResponseListener(response -> {
            if (response.getType().equals("event")) {
                var data = response.getPluginData().getAsJsonObject("data");
                callback.complete(gson.fromJson(data, VideoRoomJoinResponse.class));
            }
        });
        transaction.setErrorListener(callback::obtrudeException);
        return callback;
    }


    public CompletableFuture<String> configure(VideoRoomConfigureRequest payload) {
        var callback = new CompletableFuture<String>();
        var request = new JanusRequest("message", JanusTransaction.getNewTransactionId(), session.getId(), handleId);
        request.getPayload().add("body", gson.toJsonTree(payload));
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
        var request = new JanusRequest("trickle", JanusTransaction.getNewTransactionId(), session.getId(), handleId);
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
        var request = new JanusRequest("trickle", JanusTransaction.getNewTransactionId(), session.getId(), handleId);
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

    public CompletableFuture<String> unPublish() {
        var callback = new CompletableFuture<String>();
        var json = new JsonObject();
        json.addProperty("request", "unpublish");
        var request = new JanusRequest("message", JanusTransaction.getNewTransactionId(), session.getId(), handleId, json);
        var transaction = session.client.send(request);
        transaction.setResponseListener(response -> {
            if (response.isPluginResponse()) {
                var result = response.getPluginData().getAsJsonObject("data").get("unpublished").getAsString();
                callback.complete(result);
            }
        });
        transaction.setErrorListener(callback::obtrudeException);
        return callback;
    }


}
