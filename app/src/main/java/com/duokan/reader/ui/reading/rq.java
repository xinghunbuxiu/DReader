package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.ai;

class rq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ rn f10910a;

    rq(rn rnVar) {
        this.f10910a = rnVar;
    }

    public void run() {
        ai.m3980a().m3881a(this.f10910a.f10905b.f9282f.m4219d());
        this.f10910a.f10904a.run();
    }
}
