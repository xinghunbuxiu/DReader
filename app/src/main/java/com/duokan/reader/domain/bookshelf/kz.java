package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.b.i;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.s;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.ui.general.be;

import java.util.Iterator;

class kz extends r {
    b a = new b();
    final /* synthetic */ kp b;

    kz(kp kpVar) {
        this.b = kpVar;
    }

    protected void onSessionTry() {
        this.a = new s(this, new ab(this.b.d.b(PersonalAccount.class))).c();
    }

    protected void onSessionSucceeded() {
        this.b.e();
        if (this.a.b == 0) {
            Iterator it = this.b.f.iterator();
            while (it.hasNext()) {
                ((la) it.next()).b((String) this.a.a);
            }
        } else if (TextUtils.isEmpty(this.a.c)) {
            CharSequence string;
            if (this.a.b == 14) {
                string = this.b.b.getResources().getString(i.general__shared__local_time_error);
            } else {
                string = String.format(this.b.b.getString(i.general__shared__unknown_error_code), new Object[]{Integer.valueOf(this.a.b)});
            }
            be.a(this.b.b, string, 0).show();
        } else {
            be.a(this.b.b, this.a.c, 0).show();
        }
    }

    protected void onSessionFailed() {
        be.a(this.b.b, this.b.b.getString(i.general__shared__network_error), 0).show();
        this.b.e();
    }
}
