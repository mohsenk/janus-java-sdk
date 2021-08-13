package com.kavenegar.janus.videoroom.models;

import com.google.gson.JsonObject;

import java.util.List;

public class VideoRoomPublisher {
    Long id;
    String display;
    String audioCodec;
    String videoCodec;
    List<VideoRoomStream> streams;
    Boolean talking;

    public VideoRoomPublisher(Long id, String display, String audioCodec, String videoCodec, List<VideoRoomStream> streams, Boolean talking) {
        this.id = id;
        this.display = display;
        this.audioCodec = audioCodec;
        this.videoCodec = videoCodec;
        this.streams = streams;
        this.talking = talking;
    }

}
