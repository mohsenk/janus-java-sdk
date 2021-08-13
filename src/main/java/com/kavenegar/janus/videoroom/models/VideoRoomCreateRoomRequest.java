package com.kavenegar.janus.videoroom.models;


public final class VideoRoomCreateRoomRequest {

    private final Long room;
    private final String request = "create";

    public VideoRoomCreateRoomRequest(Long room) {
        this.room = room;
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
