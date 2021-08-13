package com.kavenegar.janus.videoroom.models;

import com.google.gson.annotations.SerializedName;

public class VideoRoomStream {

    @SerializedName("mid")
    String id;
    String type;
    String feed;
    @SerializedName("mindex")
    Integer index;
    String codec;

    public VideoRoomStream(String mid, String type, Integer index, String codec) {
        this.id = mid;
        this.type = type;
        this.index = index;
        this.codec = codec;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getIndex() {
        return index;
    }

    public String getCodec() {
        return codec;
    }
}
