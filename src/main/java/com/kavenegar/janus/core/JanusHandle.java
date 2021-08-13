package com.kavenegar.janus.core;


import com.kavenegar.janus.enums.JanusPluginType;

public interface JanusHandle {

    JanusPluginType getName();

    String getOpaqueId();

    Long getId();
}
