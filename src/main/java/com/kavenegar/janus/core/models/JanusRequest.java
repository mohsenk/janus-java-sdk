package com.kavenegar.janus.core.models;

import com.google.gson.JsonObject;

public final class JanusRequest {

    private final String type;
    private final String transaction;
    private final Long sessionId;
    private final Long handleId;
    private final JsonObject payload;

     public JanusRequest(String type, String transaction, Long sessionId, Long handleId, JsonObject payload) {
        this.type = type;
        this.transaction = transaction;
        this.sessionId = sessionId;
        this.handleId = handleId;
        this.payload = payload;
    }


    public JanusRequest(String type, String transaction, Long sessionId, Long handleId) {
        this(type, transaction, sessionId, handleId, new JsonObject());
    }

    public String getType() {
        return type;
    }

    public String getTransaction() {
        return transaction;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public Long getHandleId() {
        return handleId;
    }

    public JsonObject getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        var json = payload.deepCopy();
        json.addProperty("janus", type);
        json.addProperty("transaction", transaction);
        if (sessionId != null) json.addProperty("session_id", sessionId);
        if (handleId != null) json.addProperty("handle_id", handleId);
        return json.toString();
    }
}
