package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;

class aed implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ag f9568a;
    /* renamed from: b */
    final /* synthetic */ afa f9569b;
    /* renamed from: c */
    final /* synthetic */ adz f9570c;

    aed(adz adz, ag agVar, afa afa) {
        this.f9570c = adz;
        this.f9568a = agVar;
        this.f9569b = afa;
    }

    public void run() {
        this.f9568a.run(this.f9569b);
    }
}
