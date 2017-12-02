package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class iw implements HttpRequestHandler {
    final /* synthetic */ iv a;

    iw(iv ivVar) {
        this.a = ivVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.a.a(httpRequest, httpResponse, httpContext);
    }
}
