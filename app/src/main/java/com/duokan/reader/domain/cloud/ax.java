package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.io.Serializable;

class ax extends WebSession {
    /* renamed from: a */
    final al f3721a = this.f3723c.f3718f;
    /* renamed from: b */
    final /* synthetic */ Serializable f3722b;
    /* renamed from: c */
    final /* synthetic */ av f3723c;
    /* renamed from: d */
    private bb f3724d = new bb();

    ax(av avVar, C0657i c0657i, Serializable serializable) {
        this.f3723c = avVar;
        this.f3722b = serializable;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f3724d = this.f3723c.m5320a(this.f3721a.f2360a, (String) this.f3722b);
    }

    protected void onSessionSucceeded() {
        if (this.f3721a.m3365a(this.f3723c.f3718f) && !this.f3723c.f3717e.equals(this.f3724d)) {
            this.f3723c.m5326a(false, false, null);
        }
    }

    protected void onSessionFailed() {
    }
}
