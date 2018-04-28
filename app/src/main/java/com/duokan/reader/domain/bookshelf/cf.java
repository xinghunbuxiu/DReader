package com.duokan.reader.domain.bookshelf;

import java.util.Arrays;

class cf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f2948a;
    /* renamed from: b */
    final /* synthetic */ String f2949b;
    /* renamed from: c */
    final /* synthetic */ String f2950c;
    /* renamed from: d */
    final /* synthetic */ bu f2951d;

    cf(bu buVar, int i, String str, String str2) {
        this.f2951d = buVar;
        this.f2948a = i;
        this.f2949b = str;
        this.f2950c = str2;
    }

    public void run() {
        if (this.f2951d.f2868c.m3367c() && this.f2948a != -1) {
            bt a = this.f2951d.m4076a(this.f2951d.f2869d, this.f2948a, this.f2949b, this.f2950c, System.currentTimeMillis());
            this.f2951d.m4090a(Arrays.asList(new bt[]{a}));
        }
    }
}
