package com.duokan.reader.domain.downloadcenter;

import android.text.TextUtils;

/* renamed from: com.duokan.reader.domain.downloadcenter.u */
class C1033u implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1028p f5112a;
    /* renamed from: b */
    final /* synthetic */ C1030r f5113b;

    C1033u(C1030r c1030r, C1028p c1028p) {
        this.f5113b = c1030r;
        this.f5112a = c1028p;
    }

    public void run() {
        if (!TextUtils.isEmpty(this.f5113b.f5107g) && this.f5112a.m7911a().m8152b().equals(this.f5113b.f5107g) && this.f5113b.f5106f.contains(this.f5112a)) {
            this.f5112a.m7917c();
        }
    }
}
