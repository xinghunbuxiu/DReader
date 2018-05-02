package com.duokan.reader.domain.account.p042a;

import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0542e;

/* renamed from: com.duokan.reader.domain.account.a.y */
public class C0697y implements C0673p {
    /* renamed from: a */
    private final C0676k f2346a;

    public C0697y(C0676k c0676k) {
        this.f2346a = c0676k;
    }

    /* renamed from: a */
    public void mo854a() {
        if (C0542e.m2412a(DkApp.get().getApplicationContext(), true).m2409i() == null) {
            this.f2346a.mo855a(this.f2346a.mo864i());
        } else {
            this.f2346a.mo855a(this.f2346a.mo865j());
        }
    }
}
