package com.duokan.reader.common.c;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

class d extends DefaultHttpClient {
    final /* synthetic */ a a;

    public d(a aVar, ThreadSafeClientConnManager threadSafeClientConnManager, HttpParams httpParams) {
        this.a = aVar;
        super(threadSafeClientConnManager, httpParams);
    }

    protected HttpContext createHttpContext() {
        if (this.a.g) {
            return super.createHttpContext();
        }
        throw new RuntimeException("http connection is disabled.");
    }
}
