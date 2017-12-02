package com.duokan.reader.domain.statistics.dailystats;

import com.duokan.reader.common.c.f;
import com.duokan.reader.common.c.g;

class b implements g {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onConnectivityChanged(f fVar) {
        if (this.a.c.d()) {
            this.a.e();
        }
    }
}
