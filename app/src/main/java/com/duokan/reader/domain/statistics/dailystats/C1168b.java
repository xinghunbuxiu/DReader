package com.duokan.reader.domain.statistics.dailystats;

import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;

/* renamed from: com.duokan.reader.domain.statistics.dailystats.b */
class C1168b implements C0563j {
    /* renamed from: a */
    final /* synthetic */ C1167a f5616a;

    C1168b(C1167a c1167a) {
        this.f5616a = c1167a;
    }

    public void onConnectivityChanged(C0559f c0559f) {
        if (this.f5616a.f5611c.m2485d()) {
            this.f5616a.m8673e();
        }
    }
}
