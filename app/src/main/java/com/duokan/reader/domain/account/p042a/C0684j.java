package com.duokan.reader.domain.account.p042a;

import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.domain.statistics.dailystats.C1167a;

/* renamed from: com.duokan.reader.domain.account.a.j */
class C0684j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0683i f2305a;

    C0684j(C0683i c0683i) {
        this.f2305a = c0683i;
    }

    public void run() {
        if (C0559f.m2476b().m2486e()) {
            try {
                C1163a.m8627k().m8655c("login", "mi_account", "login_local");
            } catch (Throwable th) {
            }
            C0538a a = C0542e.m2411a(DkApp.get().getApplicationContext());
            C1167a.m8671d().m8684c();
            a.m2404d();
            this.f2305a.f2304b.mo855a(this.f2305a.f2304b.mo860e());
            return;
        }
        this.f2305a.onLoginError(this.f2305a.f2303a, DkApp.get().getString(C0247i.report_no_network_error));
    }
}
