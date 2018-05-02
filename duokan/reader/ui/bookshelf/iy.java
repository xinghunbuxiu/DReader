package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class iy implements HttpRequestHandler {
    final /* synthetic */ iv a;

    iy(iv ivVar) {
        this.a = ivVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.a.c(httpRequest, httpResponse, httpContext);
    }
}
