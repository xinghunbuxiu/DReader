package com.duokan.reader.domain.account;

import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.p042a.C0677b;

public class aa implements aq<MiAccount> {
    /* renamed from: a */
    private final MiAccount f2348a;
    /* renamed from: b */
    private final C0420b f2349b;

    private aa(MiAccount miAccount, C0420b c0420b) {
        this.f2348a = miAccount;
        this.f2349b = c0420b;
    }

    /* renamed from: a */
    public void mo866a() {
        if (MiAccount.m3186b(DkApp.get())) {
            new C0677b(this.f2348a, this.f2349b).m3288a();
        } else {
            this.f2349b.onLoginError(this.f2348a, "");
        }
    }
}
