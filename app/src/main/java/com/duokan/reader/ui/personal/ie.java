package com.duokan.reader.ui.personal;

import java.util.ArrayList;

class ie implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ArrayList f8705a;
    /* renamed from: b */
    final /* synthetic */ hy f8706b;

    ie(hy hyVar, ArrayList arrayList) {
        this.f8706b = hyVar;
        this.f8705a = arrayList;
    }

    public void run() {
        this.f8706b.f8685m.removeAll(this.f8705a);
        this.f8706b.m11970g();
        this.f8706b.f8692t.m8785a(!this.f8706b.f8693u);
    }
}
