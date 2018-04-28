package com.duokan.reader.ui.personal;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0643q;

abstract class hu extends WebSession {
    /* renamed from: d */
    final /* synthetic */ fz f8635d;

    hu(fz fzVar) {
        this.f8635d = fzVar;
        super(C0643q.f2173a);
    }

    protected void onSessionOpen() {
        this.f8635d.f8594u.add(this);
    }

    protected void onSessionClosed() {
        this.f8635d.f8594u.remove(this);
    }
}
