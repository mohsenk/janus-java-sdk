package com.kavenegar.janus.enums;

public enum JanusPluginType {
    ECHO_TEST("janus.plugin.echotest"),
    AUDIO_BRIDGE("janus.plugin.audiobridge"),
    VIDEO_ROOM("janus.plugin.videoroom");

    JanusPluginType(String name) {
        this.name = name;
    }

    final String name;

    public String getName() {
        return name;
    }
}
