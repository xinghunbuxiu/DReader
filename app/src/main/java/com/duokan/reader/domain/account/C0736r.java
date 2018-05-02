package com.duokan.reader.domain.account;

/* renamed from: com.duokan.reader.domain.account.r */
class C0736r implements C0420b {
    /* renamed from: a */
    final /* synthetic */ C0735q f2499a;

    C0736r(C0735q c0735q) {
        this.f2499a = c0735q;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2499a.f2498c.m3484c(c0672a);
        this.f2499a.f2496a.onLoginOk(c0672a);
    }

    public void onLoginError(C0672a c0672a, String str) {
        this.f2499a.f2496a.onLoginError(c0672a, str);
    }
}
