package com.duokan.reader.domain.account;

import android.accounts.Account;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import com.xiaomi.passport.data.XMPassportInfo;

class as implements RequestEnv {
    /* renamed from: a */
    final /* synthetic */ MiAccount f2371a;
    /* renamed from: b */
    private String f2372b = "";
    /* renamed from: c */
    private ExtendedAuthToken f2373c = null;

    as(MiAccount miAccount) {
        this.f2371a = miAccount;
    }

    public synchronized String getAccountName() {
        queryAuthToken();
        return this.f2372b;
    }

    public String queryEncryptedAccountName() {
        XMPassportInfo build = XMPassportInfo.build(DkApp.get(), "micloud");
        if (build != null) {
            return build.getEncryptedUserId();
        }
        return null;
    }

    public synchronized ExtendedAuthToken queryAuthToken() {
        if (this.f2373c == null) {
            try {
                C0538a a = C0542e.m2412a(DkApp.get(), true);
                Account i = a.m2409i();
                if (i != null) {
                    String a2 = a.m2392a(i, "micloud", false);
                    this.f2372b = i.name;
                    this.f2373c = ExtendedAuthToken.parse(a2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.f2373c;
    }

    public synchronized void invalidateAuthToken() {
        if (this.f2373c != null) {
            try {
                C0542e.m2412a(DkApp.get(), true).m2397a("com.xiaomi", this.f2373c.toPlain());
                this.f2373c = null;
                this.f2372b = "";
            } catch (Throwable th) {
                this.f2373c = null;
                this.f2372b = "";
            }
        }
    }

    public String getUserAgent() {
        return "DUOKANREADER; Android/" + ReaderEnv.get().getVersionName();
    }
}
