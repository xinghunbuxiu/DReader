package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;

class be implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ ik f2808a;
    /* renamed from: b */
    final /* synthetic */ boolean f2809b;
    /* renamed from: c */
    final /* synthetic */ boolean f2810c;
    /* renamed from: d */
    final /* synthetic */ int f2811d;
    /* renamed from: e */
    final /* synthetic */ al f2812e;
    /* renamed from: f */
    final /* synthetic */ ar f2813f;

    be(ar arVar, ik ikVar, boolean z, boolean z2, int i, al alVar) {
        this.f2813f = arVar;
        this.f2808a = ikVar;
        this.f2809b = z;
        this.f2810c = z2;
        this.f2811d = i;
        this.f2812e = alVar;
    }

    /* renamed from: a */
    public void m4034a(Void voidR) {
        if (!this.f2808a.isCancelled()) {
            DkUserPurchasedBooksManager.m5029a().m5066b(false, true, new bf(this));
        }
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        if (!this.f2808a.isCancelled()) {
            this.f2813f.m3933i(str);
        }
    }
}
