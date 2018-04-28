package com.duokan.reader.ui.reading;

import java.util.Map;

class hr implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Map f10348a;
    /* renamed from: b */
    final /* synthetic */ hq f10349b;

    hr(hq hqVar, Map map) {
        this.f10349b = hqVar;
        this.f10348a = map;
    }

    public void run() {
        this.f10349b.f10347b.j_();
        this.f10349b.f10347b.c.mo2103b(new hs(this));
    }
}
