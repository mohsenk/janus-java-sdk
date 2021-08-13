package com.kavenegar.janus.enums;

public enum JanusBaseErrorCodes {

    JANUS_OK(0, "Success (no error) "),
    JANUS_ERROR_UNAUTHORIZED(403, " Unauthorized (can only happen when using apisecret)"),
    JANUS_ERROR_UNKNOWN(490, "Unknown/undocumented error"),
    JANUS_ERROR_USE_GET(450, "The client needs to use HTTP GET for this request"),
    JANUS_ERROR_USE_POST(451, "The client needs to use HTTP POST for this request "),
    JANUS_ERROR_MISSING_REQUEST(452, "The request is missing in the message"),
    JANUS_ERROR_UNKNOWN_REQUEST(453, "The gateway does not support this request"),
    JANUS_ERROR_INVALID_JSON(454, "The payload is not a valid JSON message"),
    JANUS_ERROR_INVALID_JSON_OBJECT(455, "The object is not a valid JSON object as expected"),
    JANUS_ERROR_MISSING_MANDATORY_ELEMENT(456, "A mandatory element is missing in the message"),
    JANUS_ERROR_INVALID_REQUEST_PATH(457, "The request cannot be handled for this webserver path"),
    JANUS_ERROR_SESSION_NOT_FOUND(458, "The session the request refers to doesn't exist"),
    JANUS_ERROR_HANDLE_NOT_FOUND(459, "The handle the request refers to doesn't exist"),
    JANUS_ERROR_PLUGIN_NOT_FOUND(460, "The plugin the request wants to talk to doesn't exist"),
    JANUS_ERROR_PLUGIN_ATTACH(461, "An error occurring when trying to attach to a plugin and create a handle "),
    JANUS_ERROR_PLUGIN_MESSAGE(462, "An error occurring when trying to send a message/request to the plugin"),
    JANUS_ERROR_PLUGIN_DETACH(463, "An error occurring when trying to detach from a plugin and destroy the related handle"),
    JANUS_ERROR_JSEP_UNKNOWN_TYPE(464, "The gateway doesn't support this SDP type"),
    JANUS_ERROR_JSEP_INVALID_SDP(465, "The Session Description provided by the peer is invalid "),
    JANUS_ERROR_TRICKE_INVALID_STREAM(466, "The stream a trickle candidate for does not exist or is invalid"),
    JANUS_ERROR_INVALID_ELEMENT_TYPE(467, "A JSON element is of the wrong type (e.g., an integer instead of a string)"),
    JANUS_ERROR_SESSION_CONFLICT(468, "The ID provided to create a new session is already in use"),
    JANUS_ERROR_UNEXPECTED_ANSWER(469, "We got an ANSWER to an OFFER we never made");

    private final int value;
    private final String message;

    JanusBaseErrorCodes(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}