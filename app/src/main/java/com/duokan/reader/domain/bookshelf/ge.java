package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.UThread;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0651y;
import com.duokan.reader.common.webservices.duokan.C0652z;
import java.util.UUID;

class ge extends WebSession {
    /* renamed from: a */
    final /* synthetic */ gd f3223a;

    ge(gd gdVar, C0657i c0657i) {
        this.f3223a = gdVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0621a a = new C0652z((WebSession) this, this.f3223a.f3220a).m3060a(this.f3223a.f3222c.m4156I(), this.f3223a.f3222c.m4157J(), UUID.randomUUID().toString());
        if (a.b == 0 && (this.f3223a.f3222c.mo1020z().m3781b() || this.f3223a.f3222c.mo1020z().m3780a())) {
            long j = ((C0651y) a.f2058a).f2186d;
            if (!this.f3223a.f3222c.aZ() || this.f3223a.f3222c.mo1020z().f2726e != j) {
                this.f3223a.f3222c.mo1011a(new ad(ReaderEnv.get().getDeviceIdVersion(), 100, C0366o.m1031a(((C0651y) a.f2058a).f2184b) + "\n" + C0366o.m1031a(((C0651y) a.f2058a).f2185c), j));
                this.f3223a.f3222c.m4183a(BookLimitType.TIME);
                this.f3223a.f3222c.aO();
            }
        } else if (a.b == 30012) {
            ad z = this.f3223a.f3222c.mo1020z();
            this.f3223a.f3222c.mo1011a(new ad(z.f2723b, z.f2724c, "", 0));
            this.f3223a.f3222c.aO();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }

    protected void onSessionClosed() {
        UThread.post(this.f3223a.f3221b);
    }
}
