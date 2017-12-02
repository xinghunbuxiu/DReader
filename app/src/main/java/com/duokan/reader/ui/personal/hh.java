package com.duokan.reader.ui.personal;

import com.duokan.reader.common.webservices.duokan.r;

abstract class hh extends r {
    final /* synthetic */ fl d;

    private hh(fl flVar) {
        this.d = flVar;
    }

    protected void onSessionOpen() {
        this.d.v.add(this);
    }

    protected void onSessionClosed() {
        this.d.v.remove(this);
    }
}
