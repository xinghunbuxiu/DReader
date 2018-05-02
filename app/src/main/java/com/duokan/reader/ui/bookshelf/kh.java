package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class kh implements HttpRequestHandler {
    /* renamed from: a */
    final /* synthetic */ kf f6711a;

    kh(kf kfVar) {
        this.f6711a = kfVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.f6711a.m9899b(httpRequest, httpResponse, httpContext);
    }
}
