
# How to make a room and join in

## 1. Make an room session
In first you should create a room session via send a http request to video-service RestAPI

```
https://video.kavenegar.com/api/v1/rooms
```

with these options :

```json
{
    "title" : "My fancy room"
    "type" : "small-room",
    "timeout" : 60, // sec
    "webhook" : "https://my-url",
    "max-endpoints" : 2,
    "max-duration" : 500, // sec
    "recording" : true
}
```

In response you have room-id it can be a UUID like this :

`ab8f6223-2c79-4f3a-bed8-51d8967550f8`


## 2. Get an access token to join the room

After that you are going to join the room and you must be authenticate. for that you need call another RestAPI endpoint.

```
https://video.kavenegar.com/api/v1/endpoints/mohsen/access-tokens
```

```json
{
    "roomId" : "ab8f6223-2c79-4f3a-bed8-51d8967550f8",
    // other options
}
```

In response you have an access token to connect just only one room. access token is in JWT format. with roomId and endpoint data in payload.


## 3. Connect to messaging server

To connect an endpoint to the room with client-side sdks you should have roomId and endpoint access token.

```javascript
kavenegarVideo.join(roomId,accessToken).then(room,endpoint -> {
    this.room = room; // you have room object for access in public.
    this.endpoint = endpoint;
}).catch(error -> {

});


room.publish("stream-tag",stream);

room.onFinished = (reason) -> {

};

room.onEndpointJoined = (endpoint) -> {
    // new endpoint joined to room
    room.localEndpoint.subscribe(endpoint,"stream-tag");
    endpoint.tracks.forEach(track -> track.disable());
};

room.onEndpointLeft = (endpoint) -> {
    // an endpoint left the room.
};


room.endpoints.forEach(endpoint => {
  endpoint.tracks.forEach(publication => {
     publication.on('unsubscribed', () => {
       /* Hide the associated <video> element and show an avatar image. */
     });
  });
});


```


## Questions 

- Endpoint can publish multiple video or audio streams ?


