package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0644r;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.ui.general.be;
import java.util.Iterator;

class lm extends WebSession {
    /* renamed from: a */
    C0621a<String> f3558a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ lb f3559b;

    lm(lb lbVar, C0657i c0657i) {
        this.f3559b = lbVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f3558a = new C0644r(this, new al(this.f3559b.f3524d.m3502b(PersonalAccount.class))).m3003c();
    }

    protected void onSessionSucceeded() {
        this.f3559b.m4926f();
        if (this.f3558a.b == 0) {
            Iterator it = this.f3559b.f3526f.iterator();
            while (it.hasNext()) {
                ((ln) it.next()).mo1706b((String) this.f3558a.f2058a);
            }
        } else if (TextUtils.isEmpty(this.f3558a.c)) {
            CharSequence string;
            if (this.f3558a.b == 14) {
                string = this.f3559b.f3522b.getResources().getString(C0247i.general__shared__local_time_error);
            } else {
                string = String.format(this.f3559b.f3522b.getString(C0247i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.f3558a.b)});
            }
            be.m10287a(this.f3559b.f3522b, string, 0).show();
        } else {
            be.m10287a(this.f3559b.f3522b, this.f3558a.c, 0).show();
        }
    }

    protected void onSessionFailed() {
        be.m10287a(this.f3559b.f3522b, this.f3559b.f3522b.getString(C0247i.general__shared__network_error), 0).show();
        this.f3559b.m4926f();
    }
}
