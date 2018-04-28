package com.duokan.reader.domain.account;

import com.duokan.reader.ReaderEnv;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;

class be implements RequestEnv {
    /* renamed from: a */
    final /* synthetic */ MiGuestAccount f2413a;

    be(MiGuestAccount miGuestAccount) {
        this.f2413a = miGuestAccount;
    }

    public synchronized String getAccountName() {
        return this.f2413a.mo833c();
    }

    public String queryEncryptedAccountName() {
        return this.f2413a.f2263j.f2425b.f2442d;
    }

    public synchronized ExtendedAuthToken queryAuthToken() {
        return this.f2413a.f2258e;
    }

    public synchronized void invalidateAuthToken() {
        this.f2413a.mo848r();
    }

    public String getUserAgent() {
        return "DUOKANREADER; Android/" + ReaderEnv.get().getVersionName();
    }
}
