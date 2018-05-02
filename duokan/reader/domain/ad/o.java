package com.duokan.reader.domain.ad;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.a.c;

import org.apache.http.client.methods.HttpGet;

import java.util.List;

class o extends WebSession {
    final /* synthetic */ List a;
    final /* synthetic */ g b;

    o(g gVar, List list) {
        this.b = gVar;
        this.a = list;
    }

    protected void onSessionTry() {
        for (String b : this.a) {
            try {
                execute(new c().b(b).a(HttpGet.METHOD_NAME).a());
            } catch (Throwable th) {
            }
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
