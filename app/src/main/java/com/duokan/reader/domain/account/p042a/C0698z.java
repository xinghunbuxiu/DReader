package com.duokan.reader.domain.account.p042a;

import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.ja;

/* renamed from: com.duokan.reader.domain.account.a.z */
public class C0698z {
    /* renamed from: a */
    private final ja f2347a = new ja(DkApp.get().getTopActivity());

    public C0698z() {
        this.f2347a.m10843a(DkApp.get().getString(C0247i.account__shared__duokan_logging_in));
    }

    /* renamed from: a */
    public void m3355a() {
        this.f2347a.show();
    }

    /* renamed from: b */
    public void m3356b() {
        this.f2347a.dismiss();
    }
}
