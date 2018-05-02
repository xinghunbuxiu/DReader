package com.duokan.reader.domain.account;

import android.accounts.Account;

import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.b.a;
import com.duokan.reader.common.b.e;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import com.xiaomi.passport.data.XMPassportInfo;

class an implements RequestEnv {
    final /* synthetic */ MiAccount a;
    private String b = "";
    private ExtendedAuthToken c = null;

    an(MiAccount miAccount) {
        this.a = miAccount;
    }

    public synchronized String getAccountName() {
        queryAuthToken();
        return this.b;
    }

    public String queryEncryptedAccountName() {
        XMPassportInfo build = XMPassportInfo.build(DkApp.get(), "micloud");
        if (build != null) {
            return build.getEncryptedUserId();
        }
        return null;
    }

    public synchronized ExtendedAuthToken queryAuthToken() {
        if (this.c == null) {
            try {
                a a = e.a(DkApp.get(), true);
                Account i = a.i();
                if (i != null) {
                    String a2 = a.a(i, "micloud", false);
                    this.b = i.name;
                    this.c = ExtendedAuthToken.parse(a2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.c;
    }

    public synchronized void invalidateAuthToken() {
        if (this.c != null) {
            try {
                e.a(DkApp.get(), true).a("com.xiaomi", this.c.toPlain());
                this.c = null;
                this.b = "";
            } catch (Throwable th) {
                this.c = null;
                this.b = "";
            }
        }
    }

    public String getUserAgent() {
        return "DUOKANREADER; Android/" + ReaderEnv.get().getVersionName();
    }
}
