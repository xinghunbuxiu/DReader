package com.duokan.reader.domain.account.p042a;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0542e;

/* renamed from: com.duokan.reader.domain.account.a.a */
public class C0674a implements AccountManagerCallback<Bundle>, C0673p {
    /* renamed from: a */
    private final C0676k f2270a;

    public C0674a(C0676k c0676k) {
        this.f2270a = c0676k;
    }

    /* renamed from: a */
    public void mo854a() {
        C0542e.m2412a(DkApp.get().getApplicationContext(), true).m2398a("reader", null, null, DkApp.get().getTopActivity(), (AccountManagerCallback) this);
    }

    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        if (C0542e.m2412a(DkApp.get().getApplicationContext(), true).m2409i() != null) {
            this.f2270a.mo855a(this.f2270a.mo865j());
            return;
        }
        C0673p f = this.f2270a.mo861f();
        f.m3304a("");
        this.f2270a.mo855a(f);
    }
}
