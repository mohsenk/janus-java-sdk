package com.kavenegar.janus;



import com.kavenegar.janus.core.models.JanusError;
import com.kavenegar.janus.core.models.JanusRequest;
import com.kavenegar.janus.core.models.JanusResponse;

import java.util.UUID;
import java.util.function.Consumer;

public class JanusTransaction {

    final String id;
    final Boolean ack;
    final JanusRequest request;
    Consumer<JanusResponse> responseListener;
    Consumer<JanusError> errorListener;
    Consumer<Void> endListener;


    public JanusTransaction(String id, Boolean ack, JanusRequest request) {
        this.id = id;
        this.ack = ack;
        this.request = request;
        this.errorListener = (e) -> {
        };
        this.responseListener = (e) -> {
        };
        this.endListener = (e) -> {
        };
    }

    public String getId() {
        return id;
    }

    public Boolean getAck() {
        return ack;
    }

    public JanusRequest getRequest() {
        return request;
    }


    public void setEndListener(Consumer<Void> endListener) {
        this.endListener = endListener;
    }

    public void setResponseListener(Consumer<JanusResponse> responseListener) {
        this.responseListener = responseListener;
    }

    public void setErrorListener(Consumer<JanusError> errorListener) {
        this.errorListener = errorListener;
    }

    public Consumer<JanusError> getErrorListener() {
        return errorListener;
    }

    public Consumer<JanusResponse> getResponseListener() {
        return responseListener;
    }

    public Consumer<Void> getEndListener() {
        return endListener;
    }


    public static String getNewTransactionId() {
        return UUID.randomUUID().toString();
    }

}
