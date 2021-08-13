package com.kavenegar.janus.videoroom.models;

import com.google.gson.annotations.SerializedName;
import com.kavenegar.janus.videoroom.enums.VideoRoomJoinType;
import com.kavenegar.janus.videoroom.models.VideoRoomStream;

import java.util.List;

public class VideoRoomJoinSubscriberRequest {

    private final String request = "join";

    private Long room;

    @SerializedName("ptype")
    private final VideoRoomJoinType type = VideoRoomJoinType.SUBSCRIBER;

    private String display;

    private List<VideoRoomStream> streams;


    private Long privateId;

    public VideoRoomJoinSubscriberRequest(Long room, String display, List<VideoRoomStream> streams, Long privateId) {
        this.room = room;
        this.display = display;
        this.streams = streams;
        this.privateId = privateId;
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

    public List<VideoRoomStream> getStreams() {
        return streams;
    }

    public Long getPrivateId() {
        return privateId;
    }


}
