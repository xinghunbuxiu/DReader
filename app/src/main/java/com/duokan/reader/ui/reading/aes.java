package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;

class aes implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ag f9594a;
    /* renamed from: b */
    final /* synthetic */ afa f9595b;
    /* renamed from: c */
    final /* synthetic */ adz f9596c;

    aes(adz adz, ag agVar, afa afa) {
        this.f9596c = adz;
        this.f9594a = agVar;
        this.f9595b = afa;
    }

    public void run() {
        this.f9594a.run(this.f9595b);
    }
}
