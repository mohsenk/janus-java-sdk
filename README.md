# Janus SDK Quickstart

Janus SDK Client currently use WebSocket to connect Janus Gateway,
To use it you must have Janus WebSocket URL.

---

# How to use ?

This sdk use CompletableFuture for async tasks, for more information you can take a look to this tutorials :

- [Guide To CompletableFuture](https://www.baeldung.com/java-completablefuture)


### 1. Create JanusClient instance

```java
var janusClient = new JanusWebSocketClient("ws://voice.kavenegar.com:8188/", new JanusEventListener() {});
janusClient.connect();
```


### 2. Create janus session

```java
janusClient.create().thenAccept(session -> {
    logger.info("Session created , id : {}",session.getId());        
}).exceptionally(error -> {
    logger.error("Error in creating session {}",error));
    return null;
});
```

### 3. Attach a plugin into session

You can set `opaque_id` for accessing handle in session.

```java
session.attach(JanusPluginType.AUDIO_BRIDGE,"OPAQUE_ID").thenAccept(handle -> {
    if(handle instanceof AudioBridgeHandle audioBridge){
        // It's audio brdige plugin instance you can call plugin requests
    }
}).exceptionally(error -> {
    logger.error("Error in attaching handle to session {}",error));
    return null;
});
```

For example after creating handle you can get handle by `opaque_id` like this :

```java
var handle = (AudioBridgeHandle) session.mediaSession().getHandle(endpoint.getUsername()).get();
```

### 4. Execute plugin commands

```java

handle.create(new AudioBridgeCreateRoomRequest(1012)).thenAccept(created -> {
    // room is created    
});
```


### 5. Configure Room

```java
handle.configure(new AudioBridgeConfigureRequest(false, "OFFER_SDP")).thenAccept(answer -> {
    // answer is here
});
```