## Janus VideoRoom Documentation

## Create Session Request

```json
{
    "janus":"create",
    "transaction":"R9cQ7xbmqr3J"
}
```

## Response

```json
{
   "janus": "success",
   "transaction": "R9cQ7xbmqr3J",
   "data": {
      "id": 1070621502791929
   }
}
```
## Attach VideoRoom Plugin

```json
{
    "janus":"attach",
    "plugin":"janus.plugin.videoroom",
    "opaque_id":"videoroomtest-u8cnLhqOhXPK",
    "transaction":"0cJfMzo8lqin",
    "session_id":1070621502791929
}
```

## Response

```json
{
   "janus": "success",
   "session_id": 1070621502791929,
   "transaction": "0cJfMzo8lqin",
   "data": {
      "id": 7493907893543751
   }
}
```

## Join as Publsher (a person who can share your webcam or screen)

```json
{
    "janus":"message",
    "body":
    {
        "request":"join",
        "room":1234,
        "ptype":"publisher",
        "display":"omid"
    },
    "transaction":"bJ4yCqrZ4m7h",
    "session_id":1070621502791929,
    "handle_id":7493907893543751
}

```

## Ack for our request

```json
{
   "janus": "ack",
   "session_id": 1070621502791929,
   "transaction": "bJ4yCqrZ4m7h"
}
```

## Room state event before we send join request (our Response)

## If I am first person joined to room
```json
{
   "janus": "event",
   "session_id": 1070621502791929,
   "transaction": "bJ4yCqrZ4m7h",
   "sender": 7493907893543751,
   "plugindata": {
      "plugin": "janus.plugin.videoroom",
      "data": {
         "videoroom": "joined",
         "room": 1234,
         "description": "Demo Room",
         "id": 7761355596944940,
         "private_id": 4245945842,
         "publishers": []
      }
   }
}
```

With Publishers 

```json
{
   "janus": "event",
   "session_id": 8577677976526765,
   "transaction": "IEPbxTrLsUdc",
   "sender": 5580697260337471,
   "plugindata": {
      "plugin": "janus.plugin.videoroom",
      "data": {
         "videoroom": "joined",
         "room": 1234,
         "description": "Demo Room",
         "id": 1130509438817946,
         "private_id": 25240061,
         "publishers": [
            {
               "id": 3291906086101741,
               "display": "mohsen",
               "audio_codec": "opus",
               "video_codec": "vp8",
               "streams": [
                  {
                     "type": "audio",
                     "mindex": 0,
                     "mid": "0",
                     "codec": "opus",
                     "talking": false
                  },
                  {
                     "type": "video",
                     "mindex": 1,
                     "mid": "1",
                     "codec": "vp8"
                  }
               ],
               "talking": false
            }
         ]
      }
   }
}
```

#configure "tell janus how we want share :webcam,audio,text and etc

```json
{
    "janus":"message",
    "body":
    {
        "request":"configure",
        "audio":true,
        "video":true
    },
    "transaction":"bImpl8bA6FQ8",
    "janusSdp":
    {"type":"offer","sdp":"v=0\r\no=- 5336444235959210988 2 IN IP4 127.0.0.1\r\ns=-\r\nt=0 0\r\na=group:BUNDLE 0 1\r\na=msid-semantic: WMS 8aETR91ugimX6mQ36GqC5lj9jbs2HEHdP6re\r\nm=audio 9 UDP/TLS/RTP/SAVPF 111 103 104 9 0 8 106 105 13 110 112 113 126\r\nc=IN IP4 0.0.0.0\r\na=rtcp:9 IN IP4 0.0.0.0\r\na=ice-ufrag:sanz\r\na=ice-pwd:/b+YGeyV1Lioyw8iFCaUlwqV\r\na=ice-options:trickle\r\na=fingerprint:sha-256 81:AC:AE:92:90:A6:EA:51:40:69:84:2F:F9:8A:2E:D4:76:AA:7F:19:F0:1D:34:1D:65:6A:78:94:18:77:6B:6F\r\na=setup:actpass\r\na=mid:0\r\na=extmap:1 urn:ietf:params:rtp-hdrext:ssrc-audio-level\r\na=extmap:2 http://www.webrtc.org/experiments/rtp-hdrext/abs-send-time\r\na=extmap:3 http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=extmap:5 urn:ietf:params:rtp-hdrext:sdes:rtp-stream-id\r\na=extmap:6 urn:ietf:params:rtp-hdrext:sdes:repaired-rtp-stream-id\r\na=sendonly\r\na=msid:8aETR91ugimX6mQ36GqC5lj9jbs2HEHdP6re 83c068b9-35e2-4855-98d2-5d8fc7ab57c9\r\na=rtcp-mux\r\na=rtpmap:111 opus/48000/2\r\na=rtcp-fb:111 transport-cc\r\na=fmtp:111 minptime=10;useinbandfec=1\r\na=rtpmap:103 ISAC/16000\r\na=rtpmap:104 ISAC/32000\r\na=rtpmap:9 G722/8000\r\na=rtpmap:0 PCMU/8000\r\na=rtpmap:8 PCMA/8000\r\na=rtpmap:106 CN/32000\r\na=rtpmap:105 CN/16000\r\na=rtpmap:13 CN/8000\r\na=rtpmap:110 telephone-event/48000\r\na=rtpmap:112 telephone-event/32000\r\na=rtpmap:113 telephone-event/16000\r\na=rtpmap:126 telephone-event/8000\r\na=ssrc:3774447329 cname:tFzCWC+fVqEqjRJT\r\na=ssrc:3774447329 msid:8aETR91ugimX6mQ36GqC5lj9jbs2HEHdP6re 83c068b9-35e2-4855-98d2-5d8fc7ab57c9\r\na=ssrc:3774447329 mslabel:8aETR91ugimX6mQ36GqC5lj9jbs2HEHdP6re\r\na=ssrc:3774447329 label:83c068b9-35e2-4855-98d2-5d8fc7ab57c9\r\nm=video 9 UDP/TLS/RTP/SAVPF 96 97 98 99 100 101 102 121 127 120 125 107 108 109 124 119 123\r\nc=IN IP4 0.0.0.0\r\na=rtcp:9 IN IP4 0.0.0.0\r\na=ice-ufrag:sanz\r\na=ice-pwd:/b+YGeyV1Lioyw8iFCaUlwqV\r\na=ice-options:trickle\r\na=fingerprint:sha-256 81:AC:AE:92:90:A6:EA:51:40:69:84:2F:F9:8A:2E:D4:76:AA:7F:19:F0:1D:34:1D:65:6A:78:94:18:77:6B:6F\r\na=setup:actpass\r\na=mid:1\r\na=extmap:14 urn:ietf:params:rtp-hdrext:toffset\r\na=extmap:2 http://www.webrtc.org/experiments/rtp-hdrext/abs-send-time\r\na=extmap:13 urn:3gpp:video-orientation\r\na=extmap:3 http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01\r\na=extmap:12 http://www.webrtc.org/experiments/rtp-hdrext/playout-delay\r\na=extmap:11 http://www.webrtc.org/experiments/rtp-hdrext/video-content-type\r\na=extmap:7 http://www.webrtc.org/experiments/rtp-hdrext/video-timing\r\na=extmap:8 http://www.webrtc.org/experiments/rtp-hdrext/color-space\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=extmap:5 urn:ietf:params:rtp-hdrext:sdes:rtp-stream-id\r\na=extmap:6 urn:ietf:params:rtp-hdrext:sdes:repaired-rtp-stream-id\r\na=sendonly\r\na=msid:8aETR91ugimX6mQ36GqC5lj9jbs2HEHdP6re 8527fad4-d48d-4a5f-b5c7-5b810796c007\r\na=rtcp-mux\r\na=rtcp-rsize\r\na=rtpmap:96 VP8/90000\r\na=rtcp-fb:96 goog-remb\r\na=rtcp-fb:96 transport-cc\r\na=rtcp-fb:96 ccm fir\r\na=rtcp-fb:96 nack\r\na=rtcp-fb:96 nack pli\r\na=rtpmap:97 rtx/90000\r\na=fmtp:97 apt=96\r\na=rtpmap:98 VP9/90000\r\na=rtcp-fb:98 goog-remb\r\na=rtcp-fb:98 transport-cc\r\na=rtcp-fb:98 ccm fir\r\na=rtcp-fb:98 nack\r\na=rtcp-fb:98 nack pli\r\na=fmtp:98 profile-id=0\r\na=rtpmap:99 rtx/90000\r\na=fmtp:99 apt=98\r\na=rtpmap:100 VP9/90000\r\na=rtcp-fb:100 goog-remb\r\na=rtcp-fb:100 transport-cc\r\na=rtcp-fb:100 ccm fir\r\na=rtcp-fb:100 nack\r\na=rtcp-fb:100 nack pli\r\na=fmtp:100 profile-id=2\r\na=rtpmap:101 rtx/90000\r\na=fmtp:101 apt=100\r\na=rtpmap:102 H264/90000\r\na=rtcp-fb:102 goog-remb\r\na=rtcp-fb:102 transport-cc\r\na=rtcp-fb:102 ccm fir\r\na=rtcp-fb:102 nack\r\na=rtcp-fb:102 nack pli\r\na=fmtp:102 level-asymmetry-allowed=1;packetization-mode=1;profile-level-id=42001f\r\na=rtpmap:121 rtx/90000\r\na=fmtp:121 apt=102\r\na=rtpmap:127 H264/90000\r\na=rtcp-fb:127 goog-remb\r\na=rtcp-fb:127 transport-cc\r\na=rtcp-fb:127 ccm fir\r\na=rtcp-fb:127 nack\r\na=rtcp-fb:127 nack pli\r\na=fmtp:127 level-asymmetry-allowed=1;packetization-mode=0;profile-level-id=42001f\r\na=rtpmap:120 rtx/90000\r\na=fmtp:120 apt=127\r\na=rtpmap:125 H264/90000\r\na=rtcp-fb:125 goog-remb\r\na=rtcp-fb:125 transport-cc\r\na=rtcp-fb:125 ccm fir\r\na=rtcp-fb:125 nack\r\na=rtcp-fb:125 nack pli\r\na=fmtp:125 level-asymmetry-allowed=1;packetization-mode=1;profile-level-id=42e01f\r\na=rtpmap:107 rtx/90000\r\na=fmtp:107 apt=125\r\na=rtpmap:108 H264/90000\r\na=rtcp-fb:108 goog-remb\r\na=rtcp-fb:108 transport-cc\r\na=rtcp-fb:108 ccm fir\r\na=rtcp-fb:108 nack\r\na=rtcp-fb:108 nack pli\r\na=fmtp:108 level-asymmetry-allowed=1;packetization-mode=0;profile-level-id=42e01f\r\na=rtpmap:109 rtx/90000\r\na=fmtp:109 apt=108\r\na=rtpmap:124 red/90000\r\na=rtpmap:119 rtx/90000\r\na=fmtp:119 apt=124\r\na=rtpmap:123 ulpfec/90000\r\na=ssrc-group:FID 80532109 2858534802\r\na=ssrc:80532109 cname:tFzCWC+fVqEqjRJT\r\na=ssrc:80532109 msid:8aETR91ugimX6mQ36GqC5lj9jbs2HEHdP6re 8527fad4-d48d-4a5f-b5c7-5b810796c007\r\na=ssrc:80532109 mslabel:8aETR91ugimX6mQ36GqC5lj9jbs2HEHdP6re\r\na=ssrc:80532109 label:8527fad4-d48d-4a5f-b5c7-5b810796c007\r\na=ssrc:2858534802 cname:tFzCWC+fVqEqjRJT\r\na=ssrc:2858534802 msid:8aETR91ugimX6mQ36GqC5lj9jbs2HEHdP6re 8527fad4-d48d-4a5f-b5c7-5b810796c007\r\na=ssrc:2858534802 mslabel:8aETR91ugimX6mQ36GqC5lj9jbs2HEHdP6re\r\na=ssrc:2858534802 label:8527fad4-d48d-4a5f-b5c7-5b810796c007\r\n"
    },
    "session_id":1070621502791929,
    "handle_id":7493907893543751
}
```

## first janus send a ack for us request

```json
{
   "janus": "ack",
   "session_id": 1070621502791929,
   "transaction": "bImpl8bA6FQ8"
}
```

## and then send our Response with a event

```json
{
   "janus": "event",
   "session_id": 1070621502791929,
   "transaction": "bImpl8bA6FQ8",
   "sender": 7493907893543751,
   "plugindata": {
      "plugin": "janus.plugin.videoroom",
      "data": {
         "videoroom": "event",
         "room": 1234,
         "configured": "ok",
         "audio_codec": "opus",
         "video_codec": "vp8",
         "streams": [
            {
               "type": "audio",
               "mindex": 0,
               "mid": "0",
               "codec": "opus"
            },
            {
               "type": "video",
               "mindex": 1,
               "mid": "1",
               "codec": "vp8"
            }
         ]
      }
   },
   "janusSdp": {
      "type": "answer",
      "sdp": "v=0\r\no=- 5336444235959210988 2 IN IP4 217.61.26.125\r\ns=VideoRoom 1234\r\nt=0 0\r\na=group:BUNDLE 0 1\r\na=ice-options:trickle\r\na=fingerprint:sha-256 7B:5C:47:C9:BD:28:C3:21:3E:E1:A5:4F:1D:4B:F8:FA:2E:13:AB:2A:86:32:0F:F1:1D:4F:E0:DF:1E:8A:EB:57\r\na=msid-semantic: WMS janus\r\nm=audio 9 UDP/TLS/RTP/SAVPF 111\r\nc=IN IP4 217.61.26.125\r\na=recvonly\r\na=mid:0\r\na=rtcp-mux\r\na=ice-ufrag:AvEy\r\na=ice-pwd:oAXc1uaPGhz9qFtxMZw4Ht\r\na=ice-options:trickle\r\na=setup:active\r\na=rtpmap:111 opus/48000/2\r\na=extmap:1 urn:ietf:params:rtp-hdrext:ssrc-audio-level\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=extmap:5 urn:ietf:params:rtp-hdrext:sdes:rtp-stream-id\r\na=extmap:6 urn:ietf:params:rtp-hdrext:sdes:repaired-rtp-stream-id\r\na=msid:janus janus0\r\na=ssrc:3820722533 cname:janus\r\na=candidate:1 1 udp 2015363327 217.61.26.125 56665 typ host\r\na=end-of-candidates\r\nm=video 9 UDP/TLS/RTP/SAVPF 96 97\r\nc=IN IP4 217.61.26.125\r\na=recvonly\r\na=mid:1\r\na=rtcp-mux\r\na=ice-ufrag:AvEy\r\na=ice-pwd:oAXc1uaPGhz9qFtxMZw4Ht\r\na=ice-options:trickle\r\na=setup:active\r\na=rtpmap:96 VP8/90000\r\na=rtcp-fb:96 ccm fir\r\na=rtcp-fb:96 nack\r\na=rtcp-fb:96 nack pli\r\na=rtcp-fb:96 goog-remb\r\na=rtcp-fb:96 transport-cc\r\na=extmap:13 urn:3gpp:video-orientation\r\na=extmap:3 http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01\r\na=extmap:12 http://www.webrtc.org/experiments/rtp-hdrext/playout-delay\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=extmap:5 urn:ietf:params:rtp-hdrext:sdes:rtp-stream-id\r\na=extmap:6 urn:ietf:params:rtp-hdrext:sdes:repaired-rtp-stream-id\r\na=rtpmap:97 rtx/90000\r\na=fmtp:97 apt=96\r\na=msid:janus janus1\r\na=ssrc:4292411225 cname:janus\r\na=ssrc:3842170969 cname:janus\r\na=candidate:1 1 udp 2015363327 217.61.26.125 56665 typ host\r\na=end-of-candidates\r\n"
   }
}
```

## before when we send configure ,need to start trickles one by one

```json
{
   "janus":"trickle",
   "candidate":{
      "candidate":"candidate:4230638615 1 udp 2122260223 192.168.44.231 57211 typ host generation 0 ufrag sanz network-id 1 network-cost 50",
      "sdpMid":"0",
      "sdpMLineIndex":0
   },
   "transaction":"RNsTb7Dafqxj",
   "session_id":1070621502791929,
   "handle_id":7493907893543751
}
```

## and janus acking this

```json
{
   "janus": "ack",
   "session_id": 1070621502791929,
   "transaction": "bImpl8bA6FQ8"
}
```

## when tricles send end we need tell that to janus

```json
{
    "janus":"trickle",
    "candidate":
    {
        "completed":true
    },
    "transaction":"TQsipbdMOFyT",
    "session_id":1070621502791929,
    "handle_id":7493907893543751
}
```

## after that until user unpublish screen,janus send probleams and reports as event


## media recived by janus
```json
{
   "janus": "webrtcup",
   "session_id": 1070621502791929,
   "sender": 7493907893543751
}
```
## audio is good
```json
{
   "janus": "media",
   "session_id": 1070621502791929,
   "sender": 7493907893543751,
   "mid": "0",
   "type": "audio",
   "receiving": true
}
```
## video is good
```json
{
   "janus": "media",
   "session_id": 1070621502791929,
   "sender": 7493907893543751,
   "mid": "0",
   "type": "video",
   "receiving": true
}
```
## audio is bad
```json
{
   "janus": "media",
   "session_id": 1070621502791929,
   "sender": 7493907893543751,
   "mid": "0",
   "type": "audio",
   "receiving": false
}
```
## video is bad
```json
{
   "janus": "media",
   "session_id": 1070621502791929,
   "sender": 7493907893543751,
   "mid": "0",
   "type": "video",
   "receiving": false
}
```

## slow link

```json
{
   "janus": "event",
   "session_id": 1070621502791929,
   "sender": 7493907893543751,
   "plugindata": {
      "plugin": "janus.plugin.videoroom",
      "data": {
         "videoroom": "slow_link",
         "current-bitrate": 128000
      }
   }
}
```

## when user want unpublish (stop sharing her meddia)

```json
{
    "janus":"message",
    "body":{
        "request":"unpublish"
        },
    "transaction":"wEPQonyXyWjo",
    "session_id":1070621502791929,
    "handle_id":7493907893543751
}
```

## ack

```json
{
   "janus": "ack",
   "session_id": 1070621502791929,
   "transaction": "wEPQonyXyWjo"
}
```

## response as event

```json
{
   "janus": "event",
   "session_id": 1070621502791929,
   "transaction": "wEPQonyXyWjo",
   "sender": 7493907893543751,
   "plugindata": {
      "plugin": "janus.plugin.videoroom",
      "data": {
         "videoroom": "event",
         "room": 1234,
         "unpublished": "ok"
      }
   }
}
```

## importent

## when other publisher start share her media ,janus tell him to all persons of room

```json
{
   "janus": "event",
   "session_id": 1070621502791929,
   "sender": 7493907893543751,
   "plugindata": {
      "plugin": "janus.plugin.videoroom",
      "data": {
         "videoroom": "event",
         "room": 1234,
         "publishers": [
            {
               "id": 1256658881258926,
               "display": "Nir",
               "audio_codec": "opus",
               "video_codec": "vp8",
               "streams": [
                  {
                     "type": "audio",
                     "mindex": 0,
                     "mid": "0",
                     "codec": "opus"
                  },
                  {
                     "type": "video",
                     "mindex": 1,
                     "mid": "1",
                     "codec": "vp8"
                  }
               ]
            }
         ]
      }
   }
}
```

## and other person if want send thats subscribe request:

```json
{
    "janus":"message",
    "body":{
        "request":"join",
        "room":1234,
        "ptype":"subscriber",
        "streams":[{
            "feed":1256658881258926,"mid":"0"},
            {"feed":1256658881258926,"mid":"1"}],
            "private_id":4245945842},
        "transaction":"vdULfNI5srsm",
        "session_id":1070621502791929,
        "handle_id":8294970557707941
}
```

## janus ack him

## janus send response as event

```json
{
   "janus": "event",
   "session_id": 1070621502791929,
   "transaction": "vdULfNI5srsm",
   "sender": 8294970557707941,
   "plugindata": {
      "plugin": "janus.plugin.videoroom",
      "data": {
         "videoroom": "attached",
         "room": 1234,
         "streams": [
            {
               "type": "audio",
               "active": true,
               "mindex": 0,
               "mid": "0",
               "ready": false,
               "send": true,
               "feed_id": 1256658881258926,
               "feed_display": "Nir",
               "feed_mid": "0"
            },
            {
               "type": "video",
               "active": true,
               "mindex": 1,
               "mid": "1",
               "ready": false,
               "send": true,
               "feed_id": 1256658881258926,
               "feed_display": "Nir",
               "feed_mid": "1"
            }
         ]
      }
   },
   "janusSdp": {
      "type": "offer",
      "sdp": "v=0\r\no=- 1620136850146868 1 IN IP4 217.61.26.125\r\ns=VideoRoom 1234\r\nt=0 0\r\na=group:BUNDLE 0 1\r\na=ice-options:trickle\r\na=fingerprint:sha-256 7B:5C:47:C9:BD:28:C3:21:3E:E1:A5:4F:1D:4B:F8:FA:2E:13:AB:2A:86:32:0F:F1:1D:4F:E0:DF:1E:8A:EB:57\r\na=msid-semantic: WMS janus\r\nm=audio 9 UDP/TLS/RTP/SAVPF 111\r\nc=IN IP4 217.61.26.125\r\na=sendonly\r\na=mid:0\r\na=rtcp-mux\r\na=ice-ufrag:jRLS\r\na=ice-pwd:A6OoiBCZA+HIDDmRSV4Uth\r\na=ice-options:trickle\r\na=setup:actpass\r\na=rtpmap:111 opus/48000/2\r\na=extmap:1 urn:ietf:params:rtp-hdrext:ssrc-audio-level\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=msid:janus janus0\r\na=ssrc:944871176 cname:janus\r\na=candidate:1 1 udp 2015363327 217.61.26.125 41911 typ host\r\na=end-of-candidates\r\nm=video 9 UDP/TLS/RTP/SAVPF 96\r\nc=IN IP4 217.61.26.125\r\na=sendonly\r\na=mid:1\r\na=rtcp-mux\r\na=ice-ufrag:jRLS\r\na=ice-pwd:A6OoiBCZA+HIDDmRSV4Uth\r\na=ice-options:trickle\r\na=setup:actpass\r\na=rtpmap:96 VP8/90000\r\na=rtcp-fb:96 ccm fir\r\na=rtcp-fb:96 nack\r\na=rtcp-fb:96 nack pli\r\na=rtcp-fb:96 goog-remb\r\na=extmap:3 http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=extmap:12 http://www.webrtc.org/experiments/rtp-hdrext/playout-delay\r\na=extmap:13 urn:3gpp:video-orientation\r\na=ssrc-group:FID 2804354759 1240310679\r\na=msid:janus janus1\r\na=ssrc:2804354759 cname:janus\r\na=ssrc:1240310679 cname:janus\r\na=candidate:1 1 udp 2015363327 217.61.26.125 41911 typ host\r\na=end-of-candidates\r\n"
   }
}
```

## so we need send trickle list and send trickes end then janus send event like publisher side 

webrtcup // importent event

media //media state

slowlink //janus tell us send videos with specified bandwith


