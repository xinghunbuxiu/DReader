package com.duokan.reader.domain.account.p042a;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.common.p037c.C0559f;

/* renamed from: com.duokan.reader.domain.account.a.d */
public class C0679d implements AccountManagerCallback<Bundle>, C0673p {
    /* renamed from: a */
    private final C0676k f2285a;

    public C0679d(C0676k c0676k) {
        this.f2285a = c0676k;
    }

    /* renamed from: a */
    public void mo854a() {
        C0538a a = C0542e.m2412a(DkApp.get().getApplicationContext(), true);
        a.m2391a(a.m2409i(), "reader", null, DkApp.get().getTopActivity(), (AccountManagerCallback) this);
    }

    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        try {
            this.f2285a.mo856a(((Bundle) accountManagerFuture.getResult()).getString("authtoken"));
            this.f2285a.mo855a(this.f2285a.mo863h());
        } catch (Exception e) {
            e.printStackTrace();
            String str = "";
            if (!C0559f.m2476b().m2486e()) {
                str = DkApp.get().getApplicationContext().getResources().getString(C0247i.general__shared__network_error);
            }
            C0673p f = this.f2285a.mo861f();
            f.m3304a(str);
            this.f2285a.mo855a(f);
        }
    }
}
