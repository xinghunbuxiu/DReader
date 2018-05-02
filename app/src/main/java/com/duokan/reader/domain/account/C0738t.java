package com.duokan.reader.domain.account;

/* renamed from: com.duokan.reader.domain.account.t */
class C0738t implements C0420b {
    /* renamed from: a */
    final /* synthetic */ C0420b f2502a;
    /* renamed from: b */
    final /* synthetic */ C0709k f2503b;

    C0738t(C0709k c0709k, C0420b c0420b) {
        this.f2503b = c0709k;
        this.f2502a = c0420b;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2503b.m3503b(c0672a);
        if (this.f2502a != null) {
            this.f2502a.onLoginOk(c0672a);
        }
    }

    public void onLoginError(C0672a c0672a, String str) {
        if (this.f2502a != null) {
            this.f2502a.onLoginError(c0672a, str);
        }
    }
}
