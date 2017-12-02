package com.duokan.reader.domain.a;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.g;
import com.duokan.reader.common.webservices.duokan.i;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.a;

class d extends r {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;
    private b d = null;
    private b e = null;

    d(c cVar, a aVar, String str) {
        this.c = cVar;
        this.a = aVar;
        this.b = str;
    }

    protected void onSessionTry() {
        this.e = new o(this, null).g(this.c.a);
        this.d = new i(this, this.a).a((String) this.e.a, this.c.b, this.c.c, this.c.d);
    }

    protected void onSessionSucceeded() {
        if (this.d.b == 1001 || this.d.b == 1002 || this.d.b == 1003) {
            com.duokan.reader.domain.account.i.f().a(this.b, new e(this));
        } else if (this.d.b == 0 || this.d.b == 410013) {
            this.c.e.a((g) this.d.a);
        } else if (this.d.b == 14) {
            this.c.e.a(this.c.f.c.getString(com.duokan.b.i.general__shared__local_time_error));
        } else if (TextUtils.isEmpty(this.d.c)) {
            this.c.e.a(this.c.f.c.getString(com.duokan.b.i.general__shared__network_error));
        } else {
            this.c.e.a(this.d.c);
        }
    }

    protected void onSessionFailed() {
        this.c.e.a(this.c.f.c.getString(com.duokan.b.i.general__shared__network_error));
    }
}
