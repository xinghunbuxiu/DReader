package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;

class aej implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ag f9580a;
    /* renamed from: b */
    final /* synthetic */ afa f9581b;
    /* renamed from: c */
    final /* synthetic */ adz f9582c;

    aej(adz adz, ag agVar, afa afa) {
        this.f9582c = adz;
        this.f9580a = agVar;
        this.f9581b = afa;
    }

    public void run() {
        this.f9580a.run(this.f9581b);
    }
}
