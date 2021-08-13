package com.kavenegar.janus.core;


import com.kavenegar.janus.JanusSession;
import com.kavenegar.janus.JanusTransaction;
import com.kavenegar.janus.core.models.JanusRequest;
import java.util.concurrent.CompletableFuture;

public interface JanusGatewayClient {

    void connect();

    JanusTransaction send(JanusRequest request);

    CompletableFuture<JanusSession> create();

}
