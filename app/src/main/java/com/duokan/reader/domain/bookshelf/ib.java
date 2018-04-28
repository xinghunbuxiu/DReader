package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.C0543b;
import com.duokan.reader.domain.micloud.C1068i;

class ib implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1068i f3337a;
    /* renamed from: b */
    final /* synthetic */ is f3338b;
    /* renamed from: c */
    final /* synthetic */ ia f3339c;

    ib(ia iaVar, C1068i c1068i, is isVar) {
        this.f3339c = iaVar;
        this.f3337a = c1068i;
        this.f3338b = isVar;
    }

    public void run() {
        if (C0543b.m2423a(this.f3337a.m8140N(), this.f3339c.f3336a.f3330a.f2746j.f2360a)) {
            C0800c d = ai.m3980a().m3920d(this.f3337a.m8228w());
            if (d != null) {
                d.m4189a(this.f3338b);
                d.aN();
                aa b = ai.m3980a().m3904b(d.aJ());
                if (b != null) {
                    this.f3339c.f3336a.f3330a.m3823a(d, b.m3770k());
                }
                if (d.az() > 0) {
                    this.f3339c.f3336a.f3330a.m3852i(d);
                }
            }
        }
    }
}
