package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.sys.C0366o;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0651y;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;

class gn extends WebSession {
    /* renamed from: a */
    final /* synthetic */ gm f3242a;
    /* renamed from: b */
    private C0672a f3243b = C0709k.m3476a().m3502b(PersonalAccount.class);
    /* renamed from: c */
    private C0621a<C0651y> f3244c;

    gn(gm gmVar, C0657i c0657i) {
        this.f3242a = gmVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f3244c = new C0652z((WebSession) this, this.f3243b).m3078g(this.f3242a.f3241a.f3240a.f3239c.f3235b.m4156I(), this.f3242a.f3241a.f3240a.f3239c.f3235b.m4157J());
        if (this.f3244c.b == 0 && this.f3244c.f2058a != null) {
            this.f3242a.f3241a.f3240a.f3239c.f3235b.mo1011a(new ad(ReaderEnv.get().getDeviceIdVersion(), ((C0651y) this.f3244c.f2058a).f2183a, C0366o.m1031a(((C0651y) this.f3244c.f2058a).f2184b) + "\n" + C0366o.m1031a(((C0651y) this.f3244c.f2058a).f2185c), 0));
            this.f3242a.f3241a.f3240a.f3239c.f3235b.m4183a(BookLimitType.NONE);
            this.f3242a.f3241a.f3240a.f3239c.f3235b.aO();
            gq gqVar = this.f3242a.f3241a.f3240a.f3237a;
            r2 = new byte[3][];
            r2[0] = new byte[]{(byte) ((C0651y) this.f3244c.f2058a).f2183a, (byte) ReaderEnv.get().getDeviceIdVersion()};
            r2[1] = ((C0651y) this.f3244c.f2058a).f2184b;
            r2[2] = ((C0651y) this.f3244c.f2058a).f2185c;
            gqVar.f3249b = r2;
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }

    protected void onSessionClosed() {
        if (this.f3242a.f3241a.f3240a.f3237a.f3249b == null) {
            String str;
            if (this.f3242a.f3241a.f3240a.f3237a.f3248a <= 0) {
                str = "";
            } else if (this.f3244c == null) {
                str = ManagedApp.get().getString(C0247i.general__shared__network_error);
            } else if (TextUtils.isEmpty(this.f3244c.c)) {
                str = String.format(ManagedApp.get().getString(C0247i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.f3244c.b)});
            } else {
                str = this.f3244c.c;
            }
            gq gqVar = this.f3242a.f3241a.f3240a.f3237a;
            gqVar.f3248a++;
            this.f3242a.f3241a.f3240a.f3239c.f3236c.mo2477a(str, new go(this));
            return;
        }
        this.f3242a.f3241a.f3240a.f3238b.release();
    }
}
