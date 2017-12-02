package com.duokan.reader.domain.account;

import com.duokan.reader.ReaderEnv;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;

class bi implements RequestEnv {
    final /* synthetic */ MiGuestAccount a;

    bi(MiGuestAccount miGuestAccount) {
        this.a = miGuestAccount;
    }

    public synchronized String getAccountName() {
        return this.a.c();
    }

    public String queryEncryptedAccountName() {
        return this.a.j.b.g;
    }

    public synchronized ExtendedAuthToken queryAuthToken() {
        return this.a.e;
    }

    public synchronized void invalidateAuthToken() {
        this.a.o();
    }

    public String getUserAgent() {
        return "DUOKANREADER; Android/" + ReaderEnv.get().getVersionName();
    }
}
