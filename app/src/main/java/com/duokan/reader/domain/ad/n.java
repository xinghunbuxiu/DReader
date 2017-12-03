package com.duokan.reader.domain.ad;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.a.d;

import org.apache.http.protocol.HTTP;

class n extends WebSession {
    b a = new b();
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ p d;
    final /* synthetic */ g e;

    n(g gVar, String str, int i, p pVar) {
        this.e = gVar;
        this.b = str;
        this.c = i;
        this.d = pVar;
    }

    protected void onSessionTry() {
        d execute = execute(new q().a("http://api.MyTask.xiaomi.com/u/api").b(this.b).c("2.0").a(this.c).a());
        this.a.a = new com.duokan.reader.common.webservices.d(this).b(execute, HTTP.UTF_8);
    }

    protected boolean onSessionException(Exception exception, int i) {
        a.c().c(LogLevel.ERROR, "ads", "fetching ads exception");
        return super.onSessionException(exception, i);
    }

    protected void onSessionSucceeded() {
        this.d.a((String) this.a.a);
    }

    protected void onSessionFailed() {
        this.d.a();
    }
}
