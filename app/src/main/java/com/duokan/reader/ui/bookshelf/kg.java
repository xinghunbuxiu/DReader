package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class kg implements HttpRequestHandler {
    /* renamed from: a */
    final /* synthetic */ kf f6710a;

    kg(kf kfVar) {
        this.f6710a = kfVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.f6710a.m9897a(httpRequest, httpResponse, httpContext);
    }
}
