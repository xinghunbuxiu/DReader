package com.duokan.reader.domain.ad;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import java.util.List;
import org.apache.http.client.methods.HttpGet;

/* renamed from: com.duokan.reader.domain.ad.o */
class C0758o extends WebSession {
    /* renamed from: a */
    final /* synthetic */ List f2576a;
    /* renamed from: b */
    final /* synthetic */ C0750g f2577b;

    C0758o(C0750g c0750g, List list) {
        this.f2577b = c0750g;
        this.f2576a = list;
    }

    protected void onSessionTry() {
        for (String b : this.f2576a) {
            try {
                execute(new C0626c().m2856b(b).m2853a(HttpGet.METHOD_NAME).m2851a());
            } catch (Throwable th) {
            }
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
