package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.o;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.common.webservices.duokan.z;

import java.util.UUID;

class gk extends c {
    final /* synthetic */ gj a;

    gk(gj gjVar) {
        this.a = gjVar;
    }

    protected void onSessionTry() {
        b a = new aa((WebSession) this, this.a.a).a(this.a.c.H(), this.a.c.I(), UUID.randomUUID().toString());
        if (a.b == 0 && (this.a.c.y().b() || this.a.c.y().a())) {
            long j = ((z) a.a).d;
            if (!this.a.c.aX() || this.a.c.y().e != j) {
                this.a.c.a(new ad(ReaderEnv.get().getDeviceIdVersion(), 100, o.a(((z) a.a).b) + "\n" + o.a(((z) a.a).c), j));
                this.a.c.a(BookLimitType.TIME);
                this.a.c.aM();
            }
        } else if (a.b == 30012) {
            ad y = this.a.c.y();
            this.a.c.a(new ad(y.b, y.c, "", 0));
            this.a.c.aM();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }

    protected void onSessionClosed() {
        TaskHandler.PostTask(this.a.b);
    }
}
