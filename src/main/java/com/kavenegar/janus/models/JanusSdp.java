package com.kavenegar.janus.models;



public class JanusSdp {

    private String type;
    private String sdp;

    public JanusSdp(String type, String sdp) {
        this.type = type;
        this.sdp = sdp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSdp(String sdp) {
        this.sdp = sdp;
    }

    public String getType() {
        return type;
    }

    public String getSdp() {
        return sdp;
    }
}
