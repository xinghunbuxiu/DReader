package com.duokan.reader.common.p037c;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.duokan.reader.common.c.d */
class C0557d extends DefaultHttpClient {
    /* renamed from: a */
    final /* synthetic */ C0554a f1837a;

    public C0557d(C0554a c0554a, ThreadSafeClientConnManager threadSafeClientConnManager, HttpParams httpParams) {
        this.f1837a = c0554a;
        super(threadSafeClientConnManager, httpParams);
    }

    protected HttpContext createHttpContext() {
        if (this.f1837a.f1835g) {
            return super.createHttpContext();
        }
        throw new RuntimeException("http connection is disabled.");
    }
}
