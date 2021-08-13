package com.kavenegar.janus.core.models;

public  class JanusError extends Throwable {
    private final Integer code;
    private final String reason;

    JanusError(Integer code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public Integer getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "JanusError[" +
                "code=" + code + ", " +
                "reason=" + reason + ']';
    }


}
