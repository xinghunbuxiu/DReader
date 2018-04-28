package com.duokan.reader.ui.reading;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;

class bv extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f9903a;
    /* renamed from: b */
    final /* synthetic */ bu f9904b;

    bv(bu buVar, C0657i c0657i, C0672a c0672a) {
        this.f9904b = buVar;
        this.f9903a = c0672a;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0621a a = new C0640n(this, new al(this.f9903a)).m2915a(this.f9904b.f9900a, C0641o.m2934i().m2987n() + this.f9904b.f9901b);
        if (a.b == 0) {
            DkSharedStorageManager.m5016a().m5026a("preload_" + this.f9904b.f9901b, (String) a.f2058a, true);
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
