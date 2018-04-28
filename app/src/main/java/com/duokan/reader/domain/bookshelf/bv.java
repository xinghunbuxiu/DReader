package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.C0709k;

class bv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bu f2874a;

    bv(bu buVar) {
        this.f2874a = buVar;
    }

    public void run() {
        this.f2874a.m4097c();
        C0709k.m3476a().m3494a(new bw(this));
    }
}
