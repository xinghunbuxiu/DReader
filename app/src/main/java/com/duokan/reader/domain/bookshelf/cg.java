package com.duokan.reader.domain.bookshelf;

import java.util.Arrays;

class cg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f2952a;
    /* renamed from: b */
    final /* synthetic */ String f2953b;
    /* renamed from: c */
    final /* synthetic */ bu f2954c;

    cg(bu buVar, int i, String str) {
        this.f2954c = buVar;
        this.f2952a = i;
        this.f2953b = str;
    }

    public void run() {
        if (this.f2954c.f2868c.m3367c() && this.f2952a != -1) {
            bt a = this.f2954c.m4075a(this.f2954c.f2869d, this.f2952a, this.f2953b, System.currentTimeMillis());
            this.f2954c.m4090a(Arrays.asList(new bt[]{a}));
        }
    }
}
