package com.duokan.reader.common.a;

import org.apache.http.impl.DefaultHttpServerConnection;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

import java.io.IOException;

class e extends DefaultHttpServerConnection {
    final /* synthetic */ b a;
    private SessionInputBuffer b;

    private e(b bVar) {
        this.a = bVar;
        this.b = null;
    }

    public boolean a(int i) {
        try {
            return this.b.isDataAvailable(i);
        } catch (IOException e) {
            return false;
        }
    }

    protected void init(SessionInputBuffer sessionInputBuffer, SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        this.b = sessionInputBuffer;
        super.init(sessionInputBuffer, sessionOutputBuffer, httpParams);
    }
}
