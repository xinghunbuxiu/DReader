package com.duokan.reader.domain.account.p042a;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.account.a.f */
public class C0681f implements C0673p {
    /* renamed from: a */
    private final C0420b f2288a;
    /* renamed from: b */
    private final C0672a f2289b;
    /* renamed from: c */
    private String f2290c = "";

    public C0681f(C0672a c0672a, C0420b c0420b) {
        this.f2288a = c0420b;
        this.f2289b = c0672a;
    }

    /* renamed from: a */
    public void m3304a(String str) {
        this.f2290c = str;
    }

    /* renamed from: a */
    public void mo854a() {
        if (this.f2288a != null) {
            this.f2288a.onLoginError(this.f2289b, this.f2290c);
        }
    }
}
