package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0637k;
import com.duokan.reader.common.webservices.duokan.DkFeedbackReply;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;

class bq extends WebSession {
    /* renamed from: a */
    C0621a<Void> f8343a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ bn f8344b;

    bq(bn bnVar, C0657i c0657i) {
        this.f8344b = bnVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f8343a = new C0637k(this, MiAccountManager.get(this.f8344b.getContext())).m2884a(this.f8344b.f8335a.f8323d, this.f8344b.f8336b.getText().toString(), this.f8344b.f8338d);
    }

    protected void onSessionSucceeded() {
        this.f8344b.f8337c.dismiss();
        if (this.f8343a.b == 0) {
            this.f8344b.dismiss();
            be.m10286a(this.f8344b.getContext(), C0258j.personal__feedback_thread_view__succeed, 0).show();
            this.f8344b.f8335a.m11456a(((DkFeedbackReply) this.f8344b.f8335a.f8321b.get(this.f8344b.f8335a.f8321b.size() - 1)).mPosition);
            this.f8344b.f8335a.f8325f.mo1869a(this.f8344b.f8335a.f8324e);
            return;
        }
        be.m10287a(this.f8344b.getContext(), this.f8343a.c, 0).show();
    }

    protected void onSessionFailed() {
        this.f8344b.f8337c.dismiss();
        be.m10286a(this.f8344b.getContext(), C0258j.general__shared__network_error, 0).show();
    }
}
