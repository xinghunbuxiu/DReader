package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class jv implements HttpRequestHandler {
    /* renamed from: a */
    final /* synthetic */ jt f6692a;

    jv(jt jtVar) {
        this.f6692a = jtVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.f6692a.m9886b(httpRequest, httpResponse, httpContext);
    }
}
