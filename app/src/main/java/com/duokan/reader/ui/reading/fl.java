package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.n;

class fl implements at {
    final /* synthetic */ gs a;
    final /* synthetic */ fk b;

    fl(fk fkVar, gs gsVar) {
        this.b = fkVar;
        this.a = gsVar;
    }

    public void a(n nVar, as asVar) {
        if (asVar == this.a.getPageDrawable()) {
            this.a.f();
            this.b.a.a(this.a.getPage());
        }
    }

    public void b(n nVar, as asVar) {
    }
}
