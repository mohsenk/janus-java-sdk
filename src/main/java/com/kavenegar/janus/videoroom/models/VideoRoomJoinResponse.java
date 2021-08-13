package com.kavenegar.janus.videoroom.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class VideoRoomJoinResponse {

    Long privateId;
    List<VideoRoomPublisher> publishers;
    Long roomId;
    Long id;
    String description;

    public VideoRoomJoinResponse(Long privateId, Long roomId, Long id, String description) {
        this.privateId = privateId;
        this.roomId = roomId;
        this.id = id;
        this.description = description;
        this.publishers = new ArrayList<>();
    }

    public Long getPrivateId() {
        return privateId;
    }

    public List<VideoRoomPublisher> getPublishers() {
        return publishers;
    }

    public Long getRoomId() {
        return roomId;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}

