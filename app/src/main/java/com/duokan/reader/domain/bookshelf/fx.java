package com.duokan.reader.domain.bookshelf;

import java.util.HashMap;

class fx implements Runnable {
    /* renamed from: a */
    final /* synthetic */ HashMap f3208a;
    /* renamed from: b */
    final /* synthetic */ fw f3209b;

    fx(fw fwVar, HashMap hashMap) {
        this.f3209b = fwVar;
        this.f3208a = hashMap;
    }

    public void run() {
        if (this.f3209b.f3206b != null) {
            this.f3209b.f3206b.run(this.f3208a);
        }
    }
}
