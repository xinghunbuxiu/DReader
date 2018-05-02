package com.duokan.reader.domain.account.p042a;

import android.accounts.Account;
import android.app.Activity;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.statistics.dailystats.C1167a;

/* renamed from: com.duokan.reader.domain.account.a.e */
public class C0680e implements C0673p {
    /* renamed from: a */
    private final MiAccount f2286a;
    /* renamed from: b */
    private final C0676k f2287b;

    public C0680e(MiAccount miAccount, C0676k c0676k) {
        this.f2286a = miAccount;
        this.f2287b = c0676k;
    }

    /* renamed from: a */
    public void mo854a() {
        if (this.f2286a.mo839i()) {
            this.f2287b.mo855a(this.f2287b.mo857b());
        } else if (C0559f.m2476b().m2486e()) {
            C0538a a = C0542e.m2412a(DkApp.get().getApplicationContext(), true);
            Account i = a.m2409i();
            if (this.f2286a.mo843n()) {
                a.m2403c();
            } else {
                a.m2404d();
            }
            Activity topActivity = DkApp.get().getTopActivity();
            if (topActivity == null || topActivity.isFinishing()) {
                this.f2287b.mo855a(this.f2287b.mo861f());
                return;
            }
            C1167a.m8671d().m8684c();
            if (i == null) {
                this.f2287b.mo855a(this.f2287b.mo861f());
            } else {
                this.f2287b.mo855a(this.f2287b.mo865j());
            }
        } else {
            C0673p f = this.f2287b.mo861f();
            f.m3304a(DkApp.get().getString(C0247i.report_no_network_error));
            this.f2287b.mo855a(f);
        }
    }
}
