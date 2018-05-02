package com.duokan.reader.domain.account;

/* renamed from: com.duokan.reader.domain.account.u */
class C0739u implements C0420b {
    /* renamed from: a */
    final /* synthetic */ C0420b f2504a;
    /* renamed from: b */
    final /* synthetic */ C0709k f2505b;

    C0739u(C0709k c0709k, C0420b c0420b) {
        this.f2505b = c0709k;
        this.f2504a = c0420b;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2505b.m3503b(c0672a);
        if (this.f2504a != null) {
            this.f2504a.onLoginOk(c0672a);
        }
    }

    public void onLoginError(C0672a c0672a, String str) {
        if (this.f2504a != null) {
            this.f2504a.onLoginError(c0672a, str);
        }
    }
}
