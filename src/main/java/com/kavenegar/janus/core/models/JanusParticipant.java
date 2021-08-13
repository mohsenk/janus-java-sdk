package com.kavenegar.janus.core.models;

public class JanusParticipant {

    Integer id;
    String display;
    Boolean setup;
    Boolean muted;
    Boolean talking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Boolean getSetup() {
        return setup;
    }

    public void setSetup(Boolean setup) {
        this.setup = setup;
    }

    public Boolean getMuted() {
        return muted;
    }

    public void setMuted(Boolean muted) {
        this.muted = muted;
    }

    public Boolean getTalking() {
        return talking;
    }

    public void setTalking(Boolean talking) {
        this.talking = talking;
    }
}
