package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class ay extends WebSession {
    /* renamed from: a */
    final al f3725a = this.f3727c.f3718f;
    /* renamed from: b */
    final /* synthetic */ boolean f3726b;
    /* renamed from: c */
    final /* synthetic */ av f3727c;
    /* renamed from: d */
    private bb f3728d = new bb();

    ay(av avVar, C0657i c0657i, boolean z) {
        this.f3727c = avVar;
        this.f3726b = z;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f3728d = this.f3727c.m5320a(this.f3725a.f2360a, DkSharedStorageManager.m5016a().m5022a(SharedKey.USER_PRIVILEGE));
    }

    protected void onSessionSucceeded() {
        if (this.f3725a.m3365a(this.f3727c.f3718f)) {
            this.f3727c.f3717e = this.f3728d;
            if (this.f3727c.f3717e.m5342a(System.currentTimeMillis()) == 0) {
                this.f3727c.f3717e = new bb();
            }
            this.f3727c.m5329d();
        }
    }

    protected void onSessionFailed() {
    }

    protected void onSessionClosed() {
        if (this.f3726b) {
            this.f3727c.m5326a(false, false, null);
        }
    }
}
