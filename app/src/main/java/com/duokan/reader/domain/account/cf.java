package com.duokan.reader.domain.account;

import com.duokan.reader.domain.account.p042a.C0691s;
import com.duokan.reader.domain.account.p042a.C0698z;

public class cf implements aq<MiAccount> {
    /* renamed from: a */
    private final MiAccount f2463a;
    /* renamed from: b */
    private final C0420b f2464b;

    private cf(MiAccount miAccount, C0420b c0420b) {
        this.f2463a = miAccount;
        this.f2464b = c0420b;
    }

    /* renamed from: a */
    public void mo866a() {
        synchronized (this.f2463a) {
            new C0691s(this.f2463a, this.f2464b, new C0698z()).m3332a();
        }
    }
}
