package com.duokan.reader.common.webservices;

import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.common.webservices.WebSession.CacheStrategy;
import com.duokan.reader.common.webservices.duokan.a.d;

import org.apache.http.HttpHost;

import java.util.Iterator;

class SessionTask implements Runnable {
    public boolean a = false;
    public boolean b = false;
    public long c = 0;
    public final CacheStrategy d;
    final WebSession webSession;

    public SessionTask(WebSession webSession, CacheStrategy cacheStrategy) {
        this.webSession = webSession;
        this.d = cacheStrategy;
    }

    public void run() {
        this.c = Thread.currentThread().getId();
        TaskHandler.postTask(new h(this));
        Iterator it;
        try {
            if (a.b().a()) {
                this.webSession.onSessionTry();
                it = this.webSession.mResponseList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).d();
                }
                TaskHandler.postTask(new i(this));
                return;
            }
            throw new WebSessionException();
        } catch (Throwable e) {
            HttpLogger access$400 = WebSession.sHttpLogger;
            if (access$400 != null) {
                access$400.a(LogLevel.ERROR, HttpHost.DEFAULT_SCHEME_NAME, "an exception occurs!", e);
            }
            this.webSession.mSessionException = e;
            it = this.webSession.mResponseList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).d();
            }
        } catch (Throwable e2) {
            Throwable th = e2;
            Iterator it2 = this.webSession.mResponseList.iterator();
            while (it2.hasNext()) {
                ((d) it2.next()).d();
            }
        }
    }
}
