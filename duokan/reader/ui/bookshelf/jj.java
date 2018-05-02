package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class jj implements HttpRequestHandler {
    final /* synthetic */ jh a;

    jj(jh jhVar) {
        this.a = jhVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.a.b(httpRequest, httpResponse, httpContext);
    }
}
