package com.duokan.reader.domain.statistics.dailystats;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.i;

import org.apache.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

class c extends r {
    final /* synthetic */ a a;
    private b b = null;

    c(a aVar) {
        this.a = aVar;
    }

    protected void onSessionTry() {
        try {
            Thread.sleep(1000);
            List arrayList = new ArrayList();
            if (i.f() != null) {
                arrayList.add(this.a.f());
                List<String> e = this.a.a.e();
                Collections.sort(e);
                Calendar instance = Calendar.getInstance();
                instance.add(2, -1);
                for (String str : e) {
                    if (Long.parseLong(str) > instance.getTimeInMillis()) {
                        Serializable a = this.a.a.a(str);
                        if (a != null) {
                            arrayList.add(a.toString());
                        }
                    }
                }
                if (arrayList.size() != 1) {
                    this.b = new d(this).e(arrayList.toString());
                    if (ManagedApp.get().isDebuggable()) {
                        a.c().c(LogLevel.INFO, "stats", "code: " + this.b.b);
                    }
                    if (this.b.b == HttpStatus.SC_OK) {
                        this.a.b.setPrefLong(PrivatePref.PERSONAL, "SendTime", System.currentTimeMillis());
                        this.a.b.commitPrefs();
                        this.a.a.a();
                        for (String str2 : e) {
                            this.a.a.b(str2);
                        }
                        this.a.a.b();
                        if (ManagedApp.get().isDebuggable()) {
                            a.c().c(LogLevel.INFO, "stats", "delete: " + System.currentTimeMillis());
                        }
                        this.a.a.d();
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
