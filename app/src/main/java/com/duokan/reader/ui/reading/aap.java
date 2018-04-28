package com.duokan.reader.ui.reading;

import java.util.Map;

class aap implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Map f9343a;
    /* renamed from: b */
    final /* synthetic */ aao f9344b;

    aap(aao aao, Map map) {
        this.f9344b = aao;
        this.f9343a = map;
    }

    public void run() {
        this.f9344b.f9342e.j_();
        this.f9344b.f9342e.c.mo2103b(new aaq(this));
    }
}
