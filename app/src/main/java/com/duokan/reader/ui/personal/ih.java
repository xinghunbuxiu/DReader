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

class ih extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0342j f8712a;
    /* renamed from: b */
    final /* synthetic */ ig f8713b;
    /* renamed from: c */
    private C0621a<String[]> f8714c = null;

    ih(ig igVar, C0657i c0657i, C0342j c0342j) {
        this.f8713b = igVar;
        this.f8712a = c0342j;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f8714c = new C0640n(this, null).m2922e(this.f8713b.f8710c.getBookUuid());
    }

    protected void onSessionSucceeded() {
        this.f8712a.dismiss();
        this.f8713b.f8711d.f8707a.f8691s.pushPageSmoothly(bv.m15355a(AppContext.getAppContext(this.f8713b.f8711d.f8707a.getContext()), "0", Integer.parseInt(((String[]) this.f8714c.f2058a)[0]), ((String[]) this.f8714c.f2058a)[1], null), null);
    }

    protected void onSessionFailed() {
        this.f8712a.dismiss();
        be.m10287a(this.f8713b.f8711d.f8707a.getContext(), this.f8713b.f8711d.f8707a.f8683a.getString(C0258j.general__shared__network_error), 1).show();
    }
}
