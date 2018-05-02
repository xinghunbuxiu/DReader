package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.cloud.j */
class C0850j implements C0666x {
    /* renamed from: a */
    final /* synthetic */ boolean f4075a;
    /* renamed from: b */
    final /* synthetic */ C0811o f4076b;
    /* renamed from: c */
    final /* synthetic */ C0848h f4077c;

    C0850j(C0848h c0848h, boolean z, C0811o c0811o) {
        this.f4077c = c0848h;
        this.f4075a = z;
        this.f4076b = c0811o;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        try {
            this.f4077c.m5609a(this.f4075a, this.f4077c.m5605a(c0672a), this.f4076b);
        } catch (Exception e) {
            this.f4076b.mo1089a("" + e.getMessage());
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f4076b.mo1089a(str);
    }
}
