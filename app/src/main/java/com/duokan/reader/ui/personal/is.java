package com.duokan.reader.ui.personal;

import com.duokan.core.app.AppContext;
import com.duokan.core.ui.C0342j;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.store.bv;

class is extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0342j f8744a;
    /* renamed from: b */
    final /* synthetic */ ir f8745b;
    /* renamed from: c */
    private C0621a<String[]> f8746c = null;

    is(ir irVar, C0657i c0657i, C0342j c0342j) {
        this.f8745b = irVar;
        this.f8744a = c0342j;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f8746c = new C0640n(this, null).m2922e(this.f8745b.f8742a.getBookUuid());
    }

    protected void onSessionSucceeded() {
        this.f8744a.dismiss();
        this.f8745b.f8743b.b.pushPageSmoothly(bv.m15355a(AppContext.getAppContext(this.f8745b.f8743b.getContext()), "0", Integer.parseInt(((String[]) this.f8746c.f2058a)[0]), ((String[]) this.f8746c.f2058a)[1], null), null);
    }

    protected void onSessionFailed() {
        this.f8744a.dismiss();
        be.m10287a(this.f8745b.f8743b.getContext(), this.f8745b.f8743b.getString(C0258j.general__shared__network_error), 1).show();
    }
}
