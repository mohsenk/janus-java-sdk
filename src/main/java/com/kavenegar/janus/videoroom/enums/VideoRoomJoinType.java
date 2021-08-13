package com.kavenegar.janus.videoroom.enums;

import com.google.gson.annotations.SerializedName;

public enum VideoRoomJoinType {
    @SerializedName("publisher")
    PUBLISHER,
    @SerializedName("subscriber")
    SUBSCRIBER;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
