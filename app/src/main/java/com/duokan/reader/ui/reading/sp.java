package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.as;

class sp implements ag<as> {
    /* renamed from: a */
    final /* synthetic */ ag f10950a;
    /* renamed from: b */
    final /* synthetic */ si f10951b;

    sp(si siVar, ag agVar) {
        this.f10951b = siVar;
        this.f10950a = agVar;
    }

    public /* synthetic */ void run(Object obj) {
        m14975a((as) obj);
    }

    /* renamed from: a */
    public void m14975a(as asVar) {
        if (asVar == null) {
            this.f10950a.run(null);
        } else if (this.f10951b.m13110b(asVar)) {
            this.f10950a.run(asVar);
        } else {
            asVar.mo1285H();
            this.f10950a.run(null);
        }
    }
}
