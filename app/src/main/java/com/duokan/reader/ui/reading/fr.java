package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.n;

class fr implements at {
    final /* synthetic */ gs a;
    final /* synthetic */ fq b;

    fr(fq fqVar, gs gsVar) {
        this.b = fqVar;
        this.a = gsVar;
    }

    public void a(n nVar, as asVar) {
        if (asVar == this.a.getPageDrawable()) {
            this.a.f();
            this.b.a.a(this.a.getPage());
        }
    }

    public void b(n nVar, as asVar) {
        if (asVar == this.a.getPageDrawable()) {
            this.b.a.b(this.a.getPage());
        }
    }
}
