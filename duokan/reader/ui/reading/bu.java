package com.duokan.reader.ui.reading;

import com.duokan.core.sys.af;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ej;

class bu extends c {
    b a = null;
    final /* synthetic */ af b;
    final /* synthetic */ ab c;
    final /* synthetic */ ej d;
    final /* synthetic */ long e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ bn h;

    bu(bn bnVar, af afVar, ab abVar, ej ejVar, long j, String str, String str2) {
        this.h = bnVar;
        this.b = afVar;
        this.c = abVar;
        this.d = ejVar;
        this.e = j;
        this.f = str;
        this.g = str2;
    }

    protected void onSessionTry() {
        if (this.h.p == this.b) {
            aa aaVar = new aa((WebSession) this, this.c);
            if (this.d.o() == BookType.SERIAL) {
                this.a = aaVar.a(this.f, this.g, (int) this.e, this.h.t().g(this.e));
                return;
            }
            this.a = aaVar.a(this.f, this.d.K());
        }
    }

    protected void onSessionSucceeded() {
        if (!this.h.b.K() && this.h.p == this.b) {
            if (this.a.b == 0) {
                this.b.a(this.a.a);
            } else {
                this.b.a(null);
            }
            this.h.i();
        }
    }

    protected void onSessionFailed() {
        if (!this.h.b.K() && this.h.p == this.b) {
            this.h.p.a(null);
            this.h.i();
        }
    }
}
