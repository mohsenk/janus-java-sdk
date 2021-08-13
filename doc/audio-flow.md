## Janus Documentation

### Notes :

- Each request can have multiple results

## Create Session Request

```json
{
  "janus": "create",
  "transaction": "KnF4JzNk1Njf"
}
```

#### Response

```json
{
  "janus": "success",
  "transaction": "KnF4JzNk1Njf",
  "data": {
    "id": 7769772854775111
  }
}
```

---

## Attach a plugin to a session

```json
{
  "janus": "attach",
  "plugin": "janus.plugin.audiobridge",
  "opaque_id": "audiobridgetest-x4E7Np0dgSz9",
  "transaction": "xa3lrvxc3fEE",
  "session_id": 7769772854775111
}
```

#### Response

```json
{
  "janus": "success",
  "session_id": 7769772854775111,
  "transaction": "xa3lrvxc3fEE",
  "data": {
    "id": 5752607423097722
  }
}
```

## Make a room

```json
{
  "handle_id": 7451221127414026,
  "session_id": 170553284686566,
  "body": {
    "room": 100,
    "request": "create"
  },
  "janus": "message",
  "transaction": "HoIORkmQLUFQAPxY9HZ1"
}
```

#### Response

```json
{
  "janus": "success",
  "session_id": 170553284686566,
  "transaction": "HoIORkmQLUFQAPxY9HZ1",
  "sender": 7451221127414026,
  "plugindata": {
    "plugin": "janus.plugin.audiobridge",
    "data": {
      "audiobridge": "created",
      "room": 100,
      "permanent": false
    }
  }
}

```

## Join a room in audio bridge

```json
{
  "janus": "message",
  "body": {
    "request": "join",
    "room": 1234,
    "display": "mohsen"
  },
  "transaction": "2dTfMYYV6djS",
  "session_id": 7769772854775111,
  "handle_id": 5752607423097722
}
```

## Ack

```json
{
  "janus": "ack",
  "session_id": 7769772854775111,
  "transaction": "2dTfMYYV6djS"
}
```

## Event

```json
{
  "janus": "event",
  "session_id": 7769772854775111,
  "transaction": "2dTfMYYV6djS",
  "sender": 5752607423097722,
  "plugindata": {
    "plugin": "janus.plugin.audiobridge",
    "data": {
      "audiobridge": "joined",
      "room": 1234,
      "id": 53823868915466,
      "participants": []
    }
  }
}
```

## Message for Endpoint Offer

```json
{
  "janus": "message",
  "body": {
    "request": "configure",
    "muted": false
  },
  "transaction": "jHed50a6lNo6",
  "jsep": {
    "type": "offer",
    "sdp": "v=0\r\no=- 8228116172727090866 2 IN IP4 127.0.0.1\r\ns=-\r\nt=0 0\r\na=group:BUNDLE 0\r\na=extmap-allow-mixed\r\na=msid-semantic: WMS 416TwQ3TjdPDfcMNX00oHdgdwpqqRP1nJeae\r\nm=audio 9 UDP/TLS/RTP/SAVPF 111 103 104 9 0 8 106 105 13 110 112 113 126\r\nc=IN IP4 0.0.0.0\r\na=rtcp:9 IN IP4 0.0.0.0\r\na=ice-ufrag:o3Gl\r\na=ice-pwd:ClchI4tliCGDYVLn23PizctX\r\na=ice-options:trickle\r\na=fingerprint:sha-256 CF:4A:9B:67:01:CC:90:9B:D7:16:3F:02:A3:B4:6F:6D:A7:54:9C:20:DD:90:D2:6E:3A:58:B9:A3:AE:D9:BB:D0\r\na=setup:actpass\r\na=mid:0\r\na=extmap:1 urn:ietf:params:rtp-hdrext:ssrc-audio-level\r\na=extmap:2 http://www.webrtc.org/experiments/rtp-hdrext/abs-send-time\r\na=extmap:3 http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=extmap:5 urn:ietf:params:rtp-hdrext:sdes:rtp-stream-id\r\na=extmap:6 urn:ietf:params:rtp-hdrext:sdes:repaired-rtp-stream-id\r\na=sendrecv\r\na=msid:416TwQ3TjdPDfcMNX00oHdgdwpqqRP1nJeae b7731edd-adb6-47f5-a4f2-803a28acc6b4\r\na=rtcp-mux\r\na=rtpmap:111 opus/48000/2\r\na=rtcp-fb:111 transport-cc\r\na=fmtp:111 minptime=10;useinbandfec=1\r\na=rtpmap:103 ISAC/16000\r\na=rtpmap:104 ISAC/32000\r\na=rtpmap:9 G722/8000\r\na=rtpmap:0 PCMU/8000\r\na=rtpmap:8 PCMA/8000\r\na=rtpmap:106 CN/32000\r\na=rtpmap:105 CN/16000\r\na=rtpmap:13 CN/8000\r\na=rtpmap:110 telephone-event/48000\r\na=rtpmap:112 telephone-event/32000\r\na=rtpmap:113 telephone-event/16000\r\na=rtpmap:126 telephone-event/8000\r\na=ssrc:3140713980 cname:L3P58uKuRVbSRaCP\r\na=ssrc:3140713980 msid:416TwQ3TjdPDfcMNX00oHdgdwpqqRP1nJeae b7731edd-adb6-47f5-a4f2-803a28acc6b4\r\na=ssrc:3140713980 mslabel:416TwQ3TjdPDfcMNX00oHdgdwpqqRP1nJeae\r\na=ssrc:3140713980 label:b7731edd-adb6-47f5-a4f2-803a28acc6b4\r\n"
  },
  "session_id": 7769772854775111,
  "handle_id": 5752607423097722
}
```

---

## Ice Candidate Request

```json
{
  "janus": "trickle",
  "candidate": {
    "candidate": "candidate:4077567720 1 udp 2122260223 192.168.1.10 59935 typ host generation 0 ufrag o3Gl network-id 1 network-cost 10",
    "sdpMid": "0",
    "sdpMLineIndex": 0
  },
  "transaction": "Q3H2VCQLjSE8",
  "session_id": 7769772854775111,
  "handle_id": 5752607423097722
}
```

---

## Ack

```json
{
  "janus": "ack",
  "session_id": 7769772854775111,
  "transaction": "jHed50a6lNo6"
}
```

## Event Answer

```json
{
  "janus": "event",
  "session_id": 7769772854775111,
  "transaction": "jHed50a6lNo6",
  "sender": 5752607423097722,
  "plugindata": {
    "plugin": "janus.plugin.audiobridge",
    "data": {
      "audiobridge": "event",
      "result": "ok"
    }
  },
  "jsep": {
    "type": "answer",
    "sdp": "v=0\r\no=- 1616341342233785 1 IN IP4 188.213.167.189\r\ns=AudioBridge 1234\r\nt=0 0\r\na=group:BUNDLE 0\r\na=msid-semantic: WMS janus\r\nm=audio 9 UDP/TLS/RTP/SAVPF 111\r\nc=IN IP4 188.213.167.189\r\na=sendrecv\r\na=mid:0\r\na=rtcp-mux\r\na=ice-ufrag:UqfP\r\na=ice-pwd:vFTAFAeLlLwOLtXGDOuzuK\r\na=ice-options:trickle\r\na=fingerprint:sha-256 77:2A:43:15:9C:EE:25:52:29:F2:98:B6:ED:CF:30:73:9C:A1:30:DD:31:33:40:B3:45:A0:71:BB:26:BB:82:BF\r\na=setup:active\r\na=rtpmap:111 opus/48000/2\r\na=extmap:1 urn:ietf:params:rtp-hdrext:ssrc-audio-level\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=fmtp:111 maxplaybackrate=16000; stereo=0; sprop-stereo=0; useinbandfec=1\r\na=msid:janus janusa0\r\na=ssrc:3975394709 cname:janus\r\na=ssrc:3975394709 msid:janus janusa0\r\na=ssrc:3975394709 mslabel:janus\r\na=ssrc:3975394709 label:janusa0\r\na=candidate:1 1 udp 2015363327 188.213.167.189 46955 typ host\r\na=end-of-candidates\r\n"
  }
}
```

### Candidate Complete Request

```json
{
  "janus": "trickle",
  "candidate": {
    "completed": true
  },
  "transaction": "XnaPWyrrcD0p",
  "session_id": 7769772854775111,
  "handle_id": 5752607423097722
}
```

### WebRTC Up Response

```json
{
  "janus": "webrtcup",
  "session_id": 7769772854775111,
  "sender": 5752607423097722
}
```

## Media Response

```json
{
  "janus": "media",
  "session_id": 7769772854775111,
  "sender": 5752607423097722,
  "type": "audio",
  "receiving": true
}
```

## Slow Link Response

```json
{
  "janus": "slowlink",
  "session_id": 7769772854775111,
  "sender": 5752607423097722,
  "media": "audio",
  "uplink": true,
  "lost": 6
}
```

## Keep Alive Request

```json
{
  "janus": "keepalive",
  "session_id": 7769772854775111,
  "transaction": "luMmcWUqDocb"
}
```

## Destroy Session Request

```json
{
  "janus": "destroy",
  "transaction": "4QMLKk029JNB",
  "session_id": 7769772854775111
}
```

## Error

```json
{
  "janus": "error",
  "transaction": "my:janus:session:1",
  "error": {
    "code": 457,
    "reason": "Unhandled request 'created' at this path"
  }
}
```

## Plugins Error

```json
{
  "janus": "success",
  "session_id": 4113828594494867,
  "transaction": "2DJ42LKTXzusvJVwsoby",
  "sender": 2426096748776340,
  "plugindata": {
    "plugin": "janus.plugin.audiobridge",
    "data": {
      "audiobridge": "event",
      "error_code": 486,
      "error": "Room 100 already exists"
    }
  }
}
```


## Janus Admin API Handle Info 

```json
{
    "session_id": 6483295238725141,
    "session_last_activity": 2256932743954,
    "session_timeout": 60,
    "session_transport": "janus.transport.websockets",
    "handle_id": 2874929220980746,
    "loop-running": true,
    "created": 2256899865386,
    "current_time": 2256938632196,
    "plugin": "janus.plugin.audiobridge",
    "plugin_specific": {
        "state": "inroom",
        "room": 7438222881443855,
        "id": 336620644100878,
        "display": "mohsen",
        "muted": false,
        "active": true,
        "pre-buffering": false,
        "prebuffer-count": 6,
        "queue-in": 7,
        "queue-out": -1,
        "audio-level-dBov": 0,
        "talking": false,
        "fec": true,
        "started": true,
        "hangingup": false,
        "destroyed": false
    },
    "flags": {
        "got-offer": true,
        "got-answer": true,
        "negotiated": true,
        "processing-offer": false,
        "starting": true,
        "ice-restart": false,
        "ready": true,
        "stopped": false,
        "alert": false,
        "trickle": true,
        "all-trickles": true,
        "resend-trickles": false,
        "trickle-synced": false,
        "data-channels": false,
        "has-audio": true,
        "has-video": false,
        "new-datachan-sdp": false,
        "rfc4588-rtx": false,
        "cleaning": false,
        "e2ee": false
    },
    "agent-created": 2256908188898,
    "ice-mode": "full",
    "ice-role": "controlled",
    "sdps": {
        "profile": "UDP/TLS/RTP/SAVPF",
        "local": "v=0\r\no=- 1618564471072901 1 IN IP4 79.175.166.178\r\ns=AudioBridge 7438222881443855\r\nt=0 0\r\na=group:BUNDLE 0\r\na=msid-semantic: WMS janus\r\nm=audio 9 UDP/TLS/RTP/SAVPF 111\r\nc=IN IP4 79.175.166.178\r\na=sendrecv\r\na=mid:0\r\na=rtcp-mux\r\na=ice-ufrag:sbrf\r\na=ice-pwd:zr6vOcCvS3xCaX8PBXaUgG\r\na=ice-options:trickle\r\na=fingerprint:sha-256 F7:DD:82:23:BF:8B:8B:7E:CE:6E:08:13:26:E9:2E:09:94:DE:25:74:2E:5E:9B:5C:88:7C:5D:E1:CD:22:FC:4C\r\na=setup:active\r\na=rtpmap:111 opus/48000/2\r\na=extmap:1 urn:ietf:params:rtp-hdrext:ssrc-audio-level\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=fmtp:111 maxplaybackrate=16000; stereo=0; sprop-stereo=0; useinbandfec=1\r\na=msid:janus janusa0\r\na=ssrc:2031786083 cname:janus\r\na=ssrc:2031786083 msid:janus janusa0\r\na=ssrc:2031786083 mslabel:janus\r\na=ssrc:2031786083 label:janusa0\r\na=candidate:1 1 udp 2013266431 79.175.166.178 46968 typ host\r\na=candidate:2 1 udp 2013266430 172.25.0.1 37305 typ host\r\na=candidate:3 1 udp 2013266429 172.18.0.1 36175 typ host\r\na=candidate:4 1 udp 2013266428 172.21.0.1 47395 typ host\r\na=candidate:5 1 udp 1677722111 79.175.166.178 47395 typ srflx raddr 172.21.0.1 rport 47395\r\na=candidate:6 1 udp 1677722110 79.175.166.178 36175 typ srflx raddr 172.18.0.1 rport 36175\r\na=candidate:7 1 udp 1677722109 79.175.166.178 37305 typ srflx raddr 172.25.0.1 rport 37305\r\na=end-of-candidates\r\n",
        "remote": "v=0\r\no=- 5662448681995869316 2 IN IP4 127.0.0.1\r\ns=-\r\nt=0 0\r\na=group:BUNDLE 0\r\na=extmap-allow-mixed\r\na=msid-semantic: WMS muKqGtwiMvwBvs4gUqyeAvfcTWA8WvIUVE2Q\r\nm=audio 58071 UDP/TLS/RTP/SAVPF 111 103 104 9 0 8 110 112 113 126\r\nc=IN IP4 192.168.1.10\r\na=rtcp:9 IN IP4 0.0.0.0\r\na=candidate:4077567720 1 udp 2122260223 192.168.1.10 58071 typ host generation 0 network-id 1 network-cost 10\r\na=candidate:3179889176 1 tcp 1518280447 192.168.1.10 9 typ host tcptype active generation 0 network-id 1 network-cost 10\r\na=ice-ufrag:me4t\r\na=ice-pwd:j4MZKJZvRel16wh9ogCFW2PL\r\na=ice-options:trickle\r\na=fingerprint:sha-256 A8:A7:1D:03:8C:3D:1F:01:9E:59:2D:69:7A:33:94:23:EE:73:1C:18:EC:32:9E:11:86:9B:DF:6D:56:E2:9B:65\r\na=setup:actpass\r\na=mid:0\r\na=extmap:1 urn:ietf:params:rtp-hdrext:ssrc-audio-level\r\na=extmap:2 http://www.webrtc.org/experiments/rtp-hdrext/abs-send-time\r\na=extmap:3 http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=extmap:5 urn:ietf:params:rtp-hdrext:sdes:rtp-stream-id\r\na=extmap:6 urn:ietf:params:rtp-hdrext:sdes:repaired-rtp-stream-id\r\na=sendrecv\r\na=msid:muKqGtwiMvwBvs4gUqyeAvfcTWA8WvIUVE2Q 90aebac6-e797-47b1-968e-809bd6e13edd\r\na=rtcp-mux\r\na=rtpmap:111 opus/48000/2\r\na=rtcp-fb:111 transport-cc\r\na=fmtp:111 minptime=10;useinbandfec=1\r\na=rtpmap:103 ISAC/16000\r\na=rtpmap:104 ISAC/32000\r\na=rtpmap:9 G722/8000\r\na=rtpmap:0 PCMU/8000\r\na=rtpmap:8 PCMA/8000\r\na=rtpmap:110 telephone-event/48000\r\na=rtpmap:112 telephone-event/32000\r\na=rtpmap:113 telephone-event/16000\r\na=rtpmap:126 telephone-event/8000\r\na=ssrc:1063404790 cname:KR/jaahHzuQfcNo9\r\na=ssrc:1063404790 msid:muKqGtwiMvwBvs4gUqyeAvfcTWA8WvIUVE2Q 90aebac6-e797-47b1-968e-809bd6e13edd\r\na=ssrc:1063404790 mslabel:muKqGtwiMvwBvs4gUqyeAvfcTWA8WvIUVE2Q\r\na=ssrc:1063404790 label:90aebac6-e797-47b1-968e-809bd6e13edd\r\n"
    },
    "queued-packets": 0,
    "streams": [
        {
            "id": 1,
            "ready": -1,
            "ssrc": {
                "audio": 2031786083,
                "audio-peer": 1063404790
            },
            "direction": {
                "audio-send": true,
                "audio-recv": true,
                "video-send": false,
                "video-recv": false
            },
            "codecs": {
                "audio-pt": 111,
                "audio-codec": "opus"
            },
            "extensions": {
                "urn:ietf:params:rtp-hdrext:sdes:mid": 4,
                "http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01": 3,
                "urn:ietf:params:rtp-hdrext:ssrc-audio-level": 1
            },
            "bwe": {
                "twcc": true,
                "twcc-ext-id": 3
            },
            "nack-queue-ms": 200,
            "rtcp_stats": {
                "audio": {
                    "base": 48000,
                    "rtt": 74,
                    "lost": 0,
                    "lost-by-remote": 0,
                    "jitter-local": 4,
                    "jitter-remote": 1,
                    "in-link-quality": 100,
                    "in-media-link-quality": 100,
                    "out-link-quality": 100,
                    "out-media-link-quality": 100
                }
            },
            "components": [
                {
                    "id": 1,
                    "state": "ready",
                    "connected": 2256911465543,
                    "local-candidates": [
                        "1 1 udp 2013266431 79.175.166.178 46968 typ host",
                        "2 1 udp 2013266430 172.25.0.1 37305 typ host",
                        "3 1 udp 2013266429 172.18.0.1 36175 typ host",
                        "4 1 udp 2013266428 172.21.0.1 47395 typ host",
                        "5 1 udp 1677722111 79.175.166.178 47395 typ srflx raddr 172.21.0.1 rport 47395",
                        "6 1 udp 1677722110 79.175.166.178 36175 typ srflx raddr 172.18.0.1 rport 36175",
                        "7 1 udp 1677722109 79.175.166.178 37305 typ srflx raddr 172.25.0.1 rport 37305"
                    ],
                    "remote-candidates": [
                        "4077567720 1 udp 2122260223 192.168.1.10 58071 typ host generation 0 network-id 1 network-cost 10",
                        "remote1 1 udp 1853824767 46.245.122.110 58071 typ prflx raddr 46.245.122.110 rport 58071\r\n"
                    ],
                    "selected-pair": "79.175.166.178:46968 [host,udp] <-> 46.245.122.110:58071 [prflx,udp]",
                    "dtls": {
                        "fingerprint": "F7:DD:82:23:BF:8B:8B:7E:CE:6E:08:13:26:E9:2E:09:94:DE:25:74:2E:5E:9B:5C:88:7C:5D:E1:CD:22:FC:4C",
                        "remote-fingerprint": "A8:A7:1D:03:8C:3D:1F:01:9E:59:2D:69:7A:33:94:23:EE:73:1C:18:EC:32:9E:11:86:9B:DF:6D:56:E2:9B:65",
                        "remote-fingerprint-hash": "sha-256",
                        "dtls-role": "active",
                        "dtls-state": "connected",
                        "retransmissions": 0,
                        "valid": true,
                        "srtp-profile": "SRTP_AES128_CM_SHA1_80",
                        "ready": true,
                        "handshake-started": 2256911465582,
                        "connected": 2256911648317
                    },
                    "in_stats": {
                        "audio_packets": 1349,
                        "audio_bytes": 86346,
                        "audio_bytes_lastsec": 2746,
                        "do_audio_nacks": false,
                        "data_packets": 2,
                        "data_bytes": 1228
                    },
                    "out_stats": {
                        "audio_packets": 1349,
                        "audio_bytes": 37772,
                        "audio_bytes_lastsec": 1428,
                        "audio_nacks": 0,
                        "data_packets": 2,
                        "data_bytes": 782
                    }
                }
            ]
        }
    ]
}
```