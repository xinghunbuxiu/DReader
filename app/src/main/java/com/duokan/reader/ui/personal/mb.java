package com.duokan.reader.ui.personal;

import java.util.ArrayList;

class mb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ArrayList f8922a;
    /* renamed from: b */
    final /* synthetic */ ma f8923b;

    mb(ma maVar, ArrayList arrayList) {
        this.f8923b = maVar;
        this.f8922a = arrayList;
    }

    public void run() {
        this.f8923b.f8920a.run();
        this.f8923b.f8921b.m12223b(this.f8922a);
    }
}
