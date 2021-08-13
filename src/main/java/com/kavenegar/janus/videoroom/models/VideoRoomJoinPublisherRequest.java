package com.kavenegar.janus.videoroom.models;

import com.google.gson.annotations.SerializedName;
import com.kavenegar.janus.videoroom.enums.VideoRoomJoinType;

public class VideoRoomJoinPublisherRequest {

    private final String request = "join";

    private Long room;

    @SerializedName("ptype")
    private final VideoRoomJoinType type = VideoRoomJoinType.PUBLISHER;

    private String display;


    public VideoRoomJoinPublisherRequest(Long room, String display) {
        this.room = room;
        this.display = display;
    }

    public String getRequest() {
        return request;
    }

    public Long getRoom() {
        return room;
    }

    public VideoRoomJoinType getType() {
        return type;
    }

    public String getDisplay() {
        return display;
    }

}
