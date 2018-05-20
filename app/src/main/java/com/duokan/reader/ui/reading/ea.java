package com.duokan.reader.ui.reading;

import com.duokan.core.sys.af;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0623g;
import com.duokan.reader.common.webservices.duokan.C0635i;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.ag;
import java.util.LinkedList;

class ea extends WebSession {
    /* renamed from: a */
    final /* synthetic */ el f10061a;
    /* renamed from: b */
    final /* synthetic */ af f10062b;
    /* renamed from: c */
    final /* synthetic */ dg f10063c;

    ea(dg dgVar, C0657i c0657i, el elVar, af afVar) {
        this.f10063c = dgVar;
        this.f10061a = elVar;
        this.f10062b = afVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0621a g;
        if (this.f10063c.f9998G == null) {
            this.f10063c.f9998G = (String) new C0640n(this, null).m2924g(this.f10061a.f10081c.getId()).f2058a;
        }
        if (this.f10061a.f10079a.mo839i()) {
            this.f10061a.f10083e = 0;
            this.f10061a.f10082d = new C0623g();
        } else {
            C0621a e = new C0635i(this, this.f10061a.f10079a).m2874e(this.f10063c.f9998G);
            this.f10061a.f10083e = ((C0623g) e.f2058a).f2069n;
            this.f10061a.f10082d = (C0623g) e.f2058a;
        }
        C0647u c0647u = new C0647u(this, this.f10061a.f10079a);
        if (this.f10063c.f10005f.bn()) {
            g = c0647u.m3042g(this.f10063c.f9998G);
            if (g.b == 0) {
                this.f10061a.f10085g = (ag) g.f2058a;
            }
        }
        if (this.f10061a.f10081c.mo1038k()) {
            g = c0647u.m3031a(this.f10063c.f10025z.getId(), this.f10063c.f10025z.m4239l() ? 6 : 2);
            if (g.b == 0) {
                this.f10061a.f10084f = (LinkedList) g.f2058a;
                return;
            }
            return;
        }
        g = c0647u.m3031a(this.f10063c.f10025z.getId(), 1);
        if (g.b == 0) {
            this.f10061a.f10084f = (LinkedList) g.f2058a;
        }
    }

    protected void onSessionSucceeded() {
        if (dg.f9991b == this.f10062b) {
            dg.f9991b.mo975a(this.f10061a);
            dg.m13969e();
        }
    }

    protected void onSessionFailed() {
        if (dg.f9991b == this.f10062b) {
            dg.f9991b.mo975a(this.f10061a);
            dg.m13969e();
        }
    }
}
