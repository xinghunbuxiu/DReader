package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class ju implements HttpRequestHandler {
    /* renamed from: a */
    final /* synthetic */ jt f6691a;

    ju(jt jtVar) {
        this.f6691a = jtVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.f6691a.m9884a(httpRequest, httpResponse, httpContext);
    }
}
