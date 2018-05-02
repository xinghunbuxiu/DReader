package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class ki implements HttpRequestHandler {
    /* renamed from: a */
    final /* synthetic */ kf f6712a;

    ki(kf kfVar) {
        this.f6712a = kfVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.f6712a.m9901c(httpRequest, httpResponse, httpContext);
    }
}
