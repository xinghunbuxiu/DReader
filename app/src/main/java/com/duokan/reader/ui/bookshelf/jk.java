package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class jk implements HttpRequestHandler {
    final /* synthetic */ jh a;

    jk(jh jhVar) {
        this.a = jhVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.a.c(httpRequest, httpResponse, httpContext);
    }
}
