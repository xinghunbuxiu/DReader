package com.duokan.reader.ui.reading;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.ag;

class eb extends WebSession {
    /* renamed from: a */
    C0621a<ag> f10064a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ el f10065b;
    /* renamed from: c */
    final /* synthetic */ dg f10066c;

    eb(dg dgVar, C0657i c0657i, el elVar) {
        this.f10066c = dgVar;
        this.f10065b = elVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f10064a = new C0647u(this, this.f10065b.f10079a).m3042g(this.f10066c.f9998G);
    }

    protected void onSessionSucceeded() {
        if (dg.f9991b.m862b(this.f10065b) && this.f10064a.b == 0) {
            this.f10065b.f10085g = (ag) this.f10064a.f2058a;
            dg.f9991b.mo975a(this.f10065b);
            this.f10066c.m13960b(this.f10065b);
            this.f10066c.m13964c(this.f10065b);
            this.f10066c.m13973g();
        }
    }

    protected void onSessionFailed() {
    }
}
