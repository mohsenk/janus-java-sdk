package com.kavenegar.janus.core;

import com.kavenegar.janus.JanusSession;
import com.kavenegar.janus.core.models.JanusResponse;

public interface JanusEventListener {

    void onConnect();

    void onConnectionBroken();

    void onRequestReceived(JanusSession session, JanusResponse janusResponse);

}
