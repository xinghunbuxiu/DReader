package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.as;

class sc implements ag {
    final /* synthetic */ ag a;
    final /* synthetic */ rx b;

    sc(rx rxVar, ag agVar) {
        this.b = rxVar;
        this.a = agVar;
    }

    public void a(as asVar) {
        if (asVar == null) {
            this.a.a(null);
        } else if (this.b.b(asVar)) {
            this.a.a(asVar);
        } else {
            asVar.H();
            this.a.a(null);
        }
    }
}
