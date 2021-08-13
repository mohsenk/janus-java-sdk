package com.kavenegar.janus.core;


import com.kavenegar.janus.core.models.JanusError;

import java.util.function.Consumer;

public class JanusCallback<T> {

    private Consumer<T> responseCallback;
    private Consumer<JanusError> errorCallback;


    public JanusCallback<T> then(Consumer<T> callback) {
        this.responseCallback = callback;
        return this;
    }

    public JanusCallback<T> error(Consumer<JanusError> callback) {
        this.errorCallback = callback;
        return this;
    }

    public void resolve(T result) {
        resolve(result, null);
    }

    public void resolve(T result, JanusError error) {
        if (error != null) {
            if (errorCallback != null) errorCallback.accept(error);
        } else {
            if (responseCallback != null) responseCallback.accept(result);
        }
    }
}
