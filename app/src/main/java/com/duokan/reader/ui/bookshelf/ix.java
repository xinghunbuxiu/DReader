package com.duokan.reader.ui.bookshelf;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class ix implements HttpRequestHandler {
    final /* synthetic */ iv a;

    ix(iv ivVar) {
        this.a = ivVar;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        this.a.b(httpRequest, httpResponse, httpContext);
    }
}
