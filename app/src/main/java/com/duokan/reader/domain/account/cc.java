package com.duokan.reader.domain.account;

public class cc implements C0420b {
    /* renamed from: a */
    private final C0666x f2458a;
    /* renamed from: b */
    private final C0709k f2459b;

    cc(C0709k c0709k, C0666x c0666x) {
        this.f2459b = c0709k;
        this.f2458a = c0666x;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2459b.m3503b(c0672a);
        this.f2458a.onQueryAccountOk(c0672a);
    }

    public void onLoginError(C0672a c0672a, String str) {
        this.f2458a.onQueryAccountError(c0672a, str);
    }
}
