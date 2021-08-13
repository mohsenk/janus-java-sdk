package com.kavenegar.janus.core.models;

import java.util.Objects;

public class IceCandidate {
    private final String candidate;
    private final String sdpMid;
    private final Integer sdpMLineIndex;

    public IceCandidate(String candidate, String sdpMid, Integer sdpMLineIndex) {
        this.candidate = candidate;
        this.sdpMid = sdpMid;
        this.sdpMLineIndex = sdpMLineIndex;
    }

    public String getCandidate() {
        return candidate;
    }

    public String getSdpMid() {
        return sdpMid;
    }

    public Integer getSdpMLineIndex() {
        return sdpMLineIndex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (IceCandidate) obj;
        return Objects.equals(this.candidate, that.candidate) &&
                Objects.equals(this.sdpMid, that.sdpMid) &&
                Objects.equals(this.sdpMLineIndex, that.sdpMLineIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, sdpMid, sdpMLineIndex);
    }

    @Override
    public String toString() {
        return "IceCandidate[" +
                "candidate=" + candidate + ", " +
                "sdpMid=" + sdpMid + ", " +
                "sdpMLineIndex=" + sdpMLineIndex + ']';
    }

}
