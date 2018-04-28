package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.as;

class sn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ag f10945a;
    /* renamed from: b */
    final /* synthetic */ as f10946b;
    /* renamed from: c */
    final /* synthetic */ si f10947c;

    sn(si siVar, ag agVar, as asVar) {
        this.f10947c = siVar;
        this.f10945a = agVar;
        this.f10946b = asVar;
    }

    public void run() {
        this.f10945a.run(this.f10946b);
    }
}
