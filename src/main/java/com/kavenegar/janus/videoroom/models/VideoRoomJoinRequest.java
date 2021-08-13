package com.kavenegar.janus.videoroom.models;

import com.kavenegar.janus.videoroom.enums.VideoRoomJoinType;

import java.util.List;

public class VideoRoomJoinRequest {

    final String request = "join";

    Long room;
    Long id;
    String display;
    Boolean muted;
    String codec;
    Integer quality;
    Integer volume;
    VideoRoomJoinType type;
    List<VideoRoomStream> streams;

    public VideoRoomJoinRequest() {
    }

    public VideoRoomJoinRequest(Long room, Long id, String display, VideoRoomJoinType type) {
        this(room, id, display, type, false, null, null, null);
    }

    public VideoRoomJoinRequest(Long room, Long id, String display, VideoRoomJoinType type, Boolean muted, String codec, Integer quality, Integer volume) {
        this.room = room;
        this.id = id;
        this.display = display;
        this.muted = muted;
        this.codec = codec;
        this.quality = quality;
        this.volume = volume;
        this.type = type;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Boolean getMuted() {
        return muted;
    }

    public void setMuted(Boolean muted) {
        this.muted = muted;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
