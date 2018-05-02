package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class jw implements HttpRequestHandler {
    /* renamed from: a */
    final /* synthetic */ jt f6693a;

    jw(jt jtVar) {
        this.f6693a = jtVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.f6693a.m9888c(httpRequest, httpResponse, httpContext);
    }
}
