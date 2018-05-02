package com.duokan.reader.domain.statistics.dailystats;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.C0709k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.domain.statistics.dailystats.c */
class C1169c extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C1167a f5617a;
    /* renamed from: b */
    private C0621a<Void> f5618b = null;

    C1169c(C1167a c1167a, C0657i c0657i) {
        this.f5617a = c1167a;
        super(c0657i);
    }

    protected void onSessionTry() {
        try {
            Thread.sleep(1000);
            List arrayList = new ArrayList();
            if (C0709k.m3476a() != null) {
                arrayList.add(this.f5617a.m8674f());
                List<String> e = this.f5617a.f5609a.m639e();
                Collections.sort(e);
                Calendar instance = Calendar.getInstance();
                instance.add(2, -1);
                for (String str : e) {
                    if (Long.parseLong(str) > instance.getTimeInMillis()) {
                        Serializable a = this.f5617a.f5609a.m630a(str);
                        if (a != null) {
                            arrayList.add(a.toString());
                        }
                    }
                }
                if (arrayList.size() != 1) {
                    this.f5618b = new C1170d(this).m8692e(arrayList.toString());
                    if (ManagedApp.get().isDebuggable()) {
                        WebLog.init().c(LogLevel.INFO, "stats", "code: " + this.f5618b.b);
                    }
                    if (this.f5618b.b == HttpStatus.SC_OK) {
                        this.f5617a.f5610b.setPrefLong(PrivatePref.PERSONAL, "SendTime", System.currentTimeMillis());
                        this.f5617a.f5610b.commitPrefs();
                        this.f5617a.f5609a.m632a();
                        for (String str2 : e) {
                            this.f5617a.f5609a.m633b(str2);
                        }
                        this.f5617a.f5609a.m635b();
                        if (ManagedApp.get().isDebuggable()) {
                            WebLog.init().c(LogLevel.INFO, "stats", "delete: " + System.currentTimeMillis());
                        }
                        this.f5617a.f5609a.m638d();
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
