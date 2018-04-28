package com.duokan.reader.ui.account;

import com.duokan.p024c.C0258j;

class bz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ co f5906a;
    /* renamed from: b */
    final /* synthetic */ bx f5907b;

    bz(bx bxVar, co coVar) {
        this.f5907b = bxVar;
        this.f5906a = coVar;
    }

    public void run() {
        this.f5906a.mo1587a(this.f5907b.getContext().getResources().getString(C0258j.gen_bitmap_fail));
    }
}
