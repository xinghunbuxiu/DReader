package com.duokan.reader.domain.account;

import com.duokan.core.sys.C0299i;

class cd implements C0420b {
    /* renamed from: a */
    final /* synthetic */ C0299i f2460a;
    /* renamed from: b */
    final /* synthetic */ ReloginSession f2461b;

    cd(ReloginSession reloginSession, C0299i c0299i) {
        this.f2461b = reloginSession;
        this.f2460a = c0299i;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2461b.mo989a(c0672a);
        this.f2460a.m708a(Boolean.valueOf(true));
    }

    public void onLoginError(C0672a c0672a, String str) {
        this.f2460a.m708a(Boolean.valueOf(false));
    }
}
