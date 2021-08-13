package com.kavenegar.janus.videoroom.models;

import com.google.gson.annotations.SerializedName;
import com.kavenegar.janus.models.JanusSdp;

public class VideoRoomConfigureRequest {

    final String request = "configure";

    private Boolean audio;

    private Boolean video;

    @SerializedName("jsep")
    private JanusSdp sdp;

    public VideoRoomConfigureRequest(Boolean audio, Boolean video, JanusSdp sdp) {
        this.audio = audio;
        this.video = video;
        this.sdp = sdp;

    }

    public VideoRoomConfigureRequest(Boolean audio, Boolean video) {
        this.audio = audio;
        this.video = video;
    }

    public String getRequest() {
        return request;
    }

    public Boolean getAudio() {
        return audio;
    }

    public Boolean getVideo() {
        return video;
    }

    public JanusSdp getSdp() {
        return sdp;
    }
}
