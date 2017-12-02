package com.duokan.reader.domain.social.message;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.m;
import com.duokan.reader.common.webservices.duokan.n;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

class ao extends n {
    final /* synthetic */ ab a;
    final /* synthetic */ an b;
    private b c = null;

    ao(an anVar, ab abVar) {
        this.b = anVar;
        this.a = abVar;
    }

    protected void onSessionTry() {
        if (this.b.a.size() > 0) {
            m mVar = new m((n) this, this.a);
            String str = "";
            for (k kVar : this.b.a) {
                str = str + "," + kVar.b;
            }
            if (TextUtils.isEmpty(str)) {
                str = str.substring(1);
            }
            this.c = mVar.g(str);
        }
    }

    protected void onSessionSucceeded() {
        if (this.b.c.k.a(this.a)) {
            int i = this.c.b;
            if (i == 1001 || i == 1002 || i == 1003) {
                i.f().a(this.b.c.k.a, new ap(this));
                return;
            } else if (i != 0) {
                this.b.b.a("");
                return;
            } else {
                synchronized (DkMessagesManager.a) {
                    av avVar = new av(this.b.c.e, this.a, this.b.c.f);
                    avVar.a();
                    avVar.deleteItems(this.b.a);
                    this.b.b.a();
                }
                return;
            }
        }
        this.b.b.a("");
    }

    protected void onSessionFailed() {
        this.b.b.a(this.b.c.b.getString(com.duokan.b.i.general__shared__network_error));
    }
}
