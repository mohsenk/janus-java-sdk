package com.kavenegar.janus.audiobridge.models;

import java.util.Objects;

public final class AudioBridgeCreateRoomRequest {

    private final Long room;
    private final String request;

    public AudioBridgeCreateRoomRequest(Long room) {
        this.room = room;
        this.request = "create";
    }

    public Long getRoom() {
        return room;
    }

    public String getRequest() {
        return request;
    }

    @Override
    public String toString() {
        return "AudioBridgeCreateRoomRequest[" +
                "room=" + room + ", " +
                "request=" + request + ']';
    }


}
