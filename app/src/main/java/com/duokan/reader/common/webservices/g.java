package com.duokan.reader.common.webservices;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.f;
import com.duokan.core.sys.t;
import com.duokan.reader.common.c.a;
import com.duokan.reader.common.webservices.WebSession.CacheStrategy;
import com.duokan.reader.common.webservices.duokan.a.d;

import org.apache.http.HttpHost;

import java.util.Iterator;

class g implements Runnable {
    public boolean a = false;
    public boolean b = false;
    public long c = 0;
    public final CacheStrategy d;
    final /* synthetic */ WebSession e;

    public g(WebSession webSession, CacheStrategy cacheStrategy) {
        this.e = webSession;
        this.d = cacheStrategy;
    }

    public void run() {
        this.c = Thread.currentThread().getId();
        t.a(new h(this));
        Iterator it;
        try {
            if (a.b().a()) {
                this.e.onSessionTry();
                it = this.e.mResponseList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).d();
                }
                t.a(new i(this));
                return;
            }
            throw new WebSessionException();
        } catch (Throwable e) {
            f access$400 = WebSession.sHttpLogger;
            if (access$400 != null) {
                access$400.a(LogLevel.ERROR, HttpHost.DEFAULT_SCHEME_NAME, "an exception occurs!", e);
            }
            this.e.mSessionException = e;
            it = this.e.mResponseList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).d();
            }
        } catch (Throwable e2) {
            Throwable th = e2;
            Iterator it2 = this.e.mResponseList.iterator();
            while (it2.hasNext()) {
                ((d) it2.next()).d();
            }
        }
    }
}
