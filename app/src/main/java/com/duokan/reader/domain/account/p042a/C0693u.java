package com.duokan.reader.domain.account.p042a;

import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.statistics.dailystats.C1167a;

/* renamed from: com.duokan.reader.domain.account.a.u */
class C0693u implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0692t f2335a;

    C0693u(C0692t c0692t) {
        this.f2335a = c0692t;
    }

    public void run() {
        if (C0559f.m2476b().m2486e()) {
            C0538a a = C0542e.m2411a(DkApp.get().getApplicationContext());
            C1167a.m8671d().m8684c();
            a.m2403c();
            this.f2335a.f2334b.mo855a(this.f2335a.f2334b.mo860e());
            return;
        }
        this.f2335a.onLoginError(this.f2335a.f2333a, DkApp.get().getString(C0247i.report_no_network_error));
    }
}
