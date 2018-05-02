package com.duokan.reader.common.p034a;

import java.io.IOException;
import org.apache.http.impl.DefaultHttpServerConnection;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

/* renamed from: com.duokan.reader.common.a.e */
class C0515e extends DefaultHttpServerConnection {
    /* renamed from: a */
    final /* synthetic */ C0512b f1747a;
    /* renamed from: b */
    private SessionInputBuffer f1748b;

    private C0515e(C0512b c0512b) {
        this.f1747a = c0512b;
        this.f1748b = null;
    }

    /* renamed from: a */
    public boolean m2225a(int i) {
        try {
            return this.f1748b.isDataAvailable(i);
        } catch (IOException e) {
            return false;
        }
    }

    protected void init(SessionInputBuffer sessionInputBuffer, SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        this.f1748b = sessionInputBuffer;
        super.init(sessionInputBuffer, sessionOutputBuffer, httpParams);
    }
}
