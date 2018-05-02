package com.duokan.reader.domain.account;

/* renamed from: com.duokan.reader.domain.account.w */
class C0741w implements C0420b {
    /* renamed from: a */
    final /* synthetic */ C0420b f2508a;
    /* renamed from: b */
    final /* synthetic */ C0709k f2509b;

    C0741w(C0709k c0709k, C0420b c0420b) {
        this.f2509b = c0709k;
        this.f2508a = c0420b;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2509b.m3503b(c0672a);
        if (this.f2508a != null) {
            this.f2508a.onLoginOk(c0672a);
        }
    }

    public void onLoginError(C0672a c0672a, String str) {
        if (this.f2508a != null) {
            this.f2508a.onLoginError(c0672a, str);
        }
    }
}
