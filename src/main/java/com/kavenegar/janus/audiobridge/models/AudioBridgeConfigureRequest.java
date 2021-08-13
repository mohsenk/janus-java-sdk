package com.kavenegar.janus.audiobridge.models;

public class AudioBridgeConfigureRequest {

    final String request = "configure";

    private Boolean muted;
    private String sdp;

    public AudioBridgeConfigureRequest(Boolean muted, String sdp) {
        this.muted = muted;
        this.sdp = sdp;
    }

    public AudioBridgeConfigureRequest(Boolean muted) {
        this.muted = muted;
    }


    public String getRequest() {
        return request;
    }

    public Boolean getMuted() {
        return muted;
    }

    public void setMuted(Boolean muted) {
        this.muted = muted;
    }

    public String getSdp() {
        return sdp;
    }

    public void setSdp(String sdp) {
        this.sdp = sdp;
    }
}
