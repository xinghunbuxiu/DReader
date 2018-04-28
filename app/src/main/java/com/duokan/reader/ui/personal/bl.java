package com.duokan.reader.ui.personal;

import com.duokan.core.ui.dv;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0637k;
import com.duokan.reader.common.webservices.duokan.DkFeedbackReply;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.util.Collection;
import java.util.List;

class bl extends WebSession {
    /* renamed from: a */
    C0621a<List<DkFeedbackReply>> f8331a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ int f8332b;
    /* renamed from: c */
    final /* synthetic */ bh f8333c;

    bl(bh bhVar, C0657i c0657i, int i) {
        this.f8333c = bhVar;
        this.f8332b = i;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f8331a = new C0637k(this, MiAccountManager.get(this.f8333c.getContext())).m2883a(this.f8333c.f8323d, this.f8332b);
    }

    protected void onSessionSucceeded() {
        if (this.f8331a.b == 0) {
            this.f8333c.f8321b.addAll((Collection) this.f8331a.f2058a);
        } else {
            be.m10287a(this.f8333c.getContext(), this.f8331a.c, 0).show();
        }
        this.f8333c.f8320a.getAdapter().m8785a(false);
        dv.m1921a(this.f8333c.f8320a, new bm(this));
    }

    protected void onSessionFailed() {
        be.m10286a(this.f8333c.getContext(), C0258j.general__shared__network_error, 0).show();
    }
}
