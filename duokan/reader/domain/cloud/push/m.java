package com.duokan.reader.domain.cloud.push;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.n;
import com.duokan.reader.domain.account.AnonymousAccount;
import com.duokan.reader.domain.account.a;

class m extends n {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ Runnable d;
    final /* synthetic */ b e;
    private b f;

    m(b bVar, a aVar, String str, String str2, Runnable runnable) {
        this.e = bVar;
        this.a = aVar;
        this.b = str;
        this.c = str2;
        this.d = runnable;
    }

    protected void onSessionTry() {
        this.f = new com.duokan.reader.common.webservices.duokan.m((n) this, this.a).a(this.b, AnonymousAccount.n());
    }

    protected void onSessionSucceeded() {
        WebLog.c().c(LogLevel.EVENT, "push", "add push token to DkServer succeed");
        if (((Boolean) this.f.a).booleanValue()) {
            this.e.g.setPrefString(PrivatePref.PERSONAL, "mi_push_token", this.b);
            this.e.g.setPrefString(PrivatePref.PERSONAL, "mi_push_account", this.c);
            if (this.a != null) {
                this.e.g.setPrefString(PrivatePref.PERSONAL, "mi_push_account_token", this.a.d());
            }
            this.e.g.setPrefLong(PrivatePref.PERSONAL, "mi_push_register_time", System.currentTimeMillis());
            this.e.g.commitPrefs();
            if (this.d != null) {
                this.d.run();
            }
        }
    }

    protected void onSessionFailed() {
    }
}
