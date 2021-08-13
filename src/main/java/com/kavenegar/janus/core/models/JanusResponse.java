package com.kavenegar.janus.core.models;

import com.google.gson.JsonObject;

public final class JanusResponse {

    JsonObject payload;

    public JanusResponse(JsonObject payload) {
        this.payload = payload;
    }

    public JsonObject getPayload() {
        return payload;
    }

    public String getType() {
        return payload.get("janus").getAsString();
    }

    public boolean isSuccess() {
        return getType().equals("success");
    }

    public boolean isError() {
        return getType().equals("error");
    }

    public boolean isAck() {
        return getType().equals("ack");
    }

    public boolean isPluginResponse() {
        return payload.has("plugindata");
    }

    public JsonObject getPluginData() {
        return payload.getAsJsonObject("plugindata");
    }

    public boolean isPluginError() {
        return isPluginResponse() && payload.getAsJsonObject("plugindata").getAsJsonObject("data").has("error");
    }

    public JanusError getPluginError() {
        var pluginData = getPluginData().getAsJsonObject("data");
        return new JanusError(pluginData.get("error_code").getAsInt(), pluginData.get("error").getAsString());
    }


    public JanusError getError() {
        if (isPluginError()) return getPluginError();
        var error = getPayload().getAsJsonObject("error");
        return new JanusError(error.get("code").getAsInt(), error.get("reason").getAsString());
    }

    @Override
    public String toString() {
        return payload.toString();
    }
}
