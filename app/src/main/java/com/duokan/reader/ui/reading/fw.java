package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;

class fw implements at {
    /* renamed from: a */
    final /* synthetic */ gx f10189a;
    /* renamed from: b */
    final /* synthetic */ fv f10190b;

    fw(fv fvVar, gx gxVar) {
        this.f10190b = fvVar;
        this.f10189a = gxVar;
    }

    /* renamed from: a */
    public void mo1221a(C0903n c0903n, as asVar) {
        if (asVar == this.f10189a.getPageDrawable()) {
            this.f10189a.m14300f();
            this.f10190b.f10188a.m9997a(this.f10189a.getPage());
        }
    }

    /* renamed from: b */
    public void mo1225b(C0903n c0903n, as asVar) {
        if (asVar == this.f10189a.getPageDrawable()) {
            this.f10190b.f10188a.m10007b(this.f10189a.getPage());
        }
    }
}
