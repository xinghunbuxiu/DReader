package com.duokan.reader.domain.cloud.push;

import com.duokan.b.i;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.m;
import com.duokan.reader.common.webservices.duokan.n;
import com.duokan.reader.domain.account.a;

class d extends n {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ s d;
    final /* synthetic */ b e;
    private b f = null;

    d(b bVar, a aVar, String str, boolean z, s sVar) {
        this.e = bVar;
        this.a = aVar;
        this.b = str;
        this.c = z;
        this.d = sVar;
    }

    protected void onSessionTry() {
        this.f = new m((n) this, this.a).a(this.b, this.c);
        if (this.f != null && ((Boolean) this.f.a).booleanValue()) {
            this.e.g.setPrefBoolean(PrivatePref.PERSONAL, "mi_push_notify_server", true);
            this.e.g.commitPrefs();
        }
    }

    protected void onSessionSucceeded() {
        if (this.f == null || !((Boolean) this.f.a).booleanValue()) {
            this.d.a(this.e.d.getString(i.general__shared__push_server_error));
        } else {
            this.d.a(this.c);
        }
    }

    protected void onSessionFailed() {
        this.d.a(this.e.d.getString(i.general__shared__network_error));
    }
}
