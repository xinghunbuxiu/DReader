package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.sys.o;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.common.webservices.duokan.b;
import com.duokan.reader.common.webservices.duokan.z;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;

class gt extends b {
    final /* synthetic */ gs a;
    private a b = i.f().b(PersonalAccount.class);
    private com.duokan.reader.common.webservices.b c;

    gt(gs gsVar) {
        this.a = gsVar;
    }

    protected void onSessionTry() {
        this.c = new aa((WebSession) this, this.b).g(this.a.a.a.c.b.H(), this.a.a.a.c.b.I());
        if (this.c.b == 0 && this.c.a != null) {
            this.a.a.a.c.b.a(new ad(ReaderEnv.get().getDeviceIdVersion(), ((z) this.c.a).a, o.a(((z) this.c.a).b) + "\n" + o.a(((z) this.c.a).c), 0));
            this.a.a.a.c.b.a(BookLimitType.NONE);
            this.a.a.a.c.b.aM();
            gw gwVar = this.a.a.a.a;
            r2 = new byte[3][];
            r2[0] = new byte[]{(byte) ((z) this.c.a).a, (byte) ReaderEnv.get().getDeviceIdVersion()};
            r2[1] = ((z) this.c.a).b;
            r2[2] = ((z) this.c.a).c;
            gwVar.b = r2;
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }

    protected void onSessionClosed() {
        if (this.a.a.a.a.b == null) {
            String str;
            if (this.a.a.a.a.a <= 0) {
                str = "";
            } else if (this.c == null) {
                str = ManagedApp.get().getString(com.duokan.b.i.general__shared__network_error);
            } else if (TextUtils.isEmpty(this.c.c)) {
                str = String.format(ManagedApp.get().getString(com.duokan.b.i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.c.b)});
            } else {
                str = this.c.c;
            }
            gw gwVar = this.a.a.a.a;
            gwVar.a++;
            this.a.a.a.c.c.a(str, new gu(this));
            return;
        }
        this.a.a.a.b.release();
    }
}
