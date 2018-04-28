package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0643q;

abstract class jd extends WebSession {
    /* renamed from: d */
    final /* synthetic */ ie f6616d;

    jd(ie ieVar) {
        this.f6616d = ieVar;
        super(C0643q.f2173a);
    }

    protected void onSessionOpen() {
        this.f6616d.f6600l.add(this);
    }

    protected void onSessionClosed() {
        this.f6616d.f6600l.remove(this);
    }
}
