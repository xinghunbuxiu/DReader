package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.n;

class l implements at {
    final /* synthetic */ k a;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;

    l(k kVar) {
        this.a = kVar;
    }

    public void a(n nVar, as asVar) {
        if (asVar == this.a.a.l) {
            this.b = true;
        } else if (asVar == this.a.a.m) {
            this.c = true;
        }
        if (this.b && this.c && this.a.a.h != null) {
            this.a.a.h.a(null, this.a.a);
        }
    }

    public void b(n nVar, as asVar) {
        if (!this.d && this.a.a.h != null) {
            this.d = true;
            this.a.a.h.b(null, this.a.a);
        }
    }
}
