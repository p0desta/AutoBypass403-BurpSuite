package Main;

import burp.IHttpRequestResponsePersisted;

import java.net.URL;
import java.time.LocalDateTime;

public class Bypass {

    final String timestamp;
    final String length;
    final IHttpRequestResponsePersisted requestResponse;
    final URL url;
    final short status;
    final String mimeType;
    final String method;

    public Bypass(String timestamp, String method , String length, IHttpRequestResponsePersisted requestResponse, URL url, short status, String mimeType) {

        this.timestamp = timestamp;
        this.method = method;
        this.length = length;
        this.requestResponse = requestResponse;
        this.url = url;
        this.status = status;
        this.mimeType = mimeType;
    }
}

