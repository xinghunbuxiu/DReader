package com.duokan.reader.ui.reading;

import com.duokan.core.sys.af;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.ag;
import com.duokan.reader.common.webservices.duokan.g;
import com.duokan.reader.common.webservices.duokan.i;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.v;

import java.util.LinkedList;

class dw extends r {
    final /* synthetic */ eh a;
    final /* synthetic */ af b;
    final /* synthetic */ de c;

    dw(de deVar, eh ehVar, af afVar) {
        this.c = deVar;
        this.a = ehVar;
        this.b = afVar;
    }

    protected void onSessionTry() {
        b g;
        if (this.c.F == null) {
            this.c.F = (String) new o(this, null).g(this.a.c.H()).a;
        }
        if (this.a.a.i()) {
            this.a.e = 0;
            this.a.d = new g();
        } else {
            b e = new i(this, this.a.a).e(this.c.F);
            this.a.e = ((g) e.a).n;
            this.a.d = (g) e.a;
        }
        v vVar = new v(this, this.a.a);
        if (this.c.e.bm()) {
            g = vVar.g(this.c.F);
            if (g.b == 0) {
                this.a.g = (ag) g.a;
            }
        }
        if (this.a.c.k()) {
            g = vVar.a(this.c.y.H(), this.c.y.l() ? 6 : 2);
            if (g.b == 0) {
                this.a.f = (LinkedList) g.a;
                return;
            }
            return;
        }
        g = vVar.a(this.c.y.H(), 1);
        if (g.b == 0) {
            this.a.f = (LinkedList) g.a;
        }
    }

    protected void onSessionSucceeded() {
        if (de.b == this.b) {
            de.b.a(this.a);
            de.e();
        }
    }

    protected void onSessionFailed() {
        if (de.b == this.b) {
            de.b.a(this.a);
            de.e();
        }
    }
}
