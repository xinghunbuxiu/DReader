package com.duokan.reader.common.webservices;

import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.reader.common.p037c.C0554a;
import com.duokan.reader.common.webservices.WebSession.CacheStrategy;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import java.util.Iterator;
import org.apache.http.HttpHost;


class C0654f implements Runnable {
    
    public boolean f2196a = false;
    
    public boolean f2197b = false;
    
    public long f2198c = 0;
    
    public final CacheStrategy f2199d;
    
    final  WebSession f2200e;

    public C0654f(WebSession webSession, CacheStrategy cacheStrategy) {
        this.f2200e = webSession;
        this.f2199d = cacheStrategy;
    }

    public void run() {
        this.f2198c = Thread.currentThread().getId();
        UThread.m1035a(new C0655g(this));
        Iterator it;
        try {
            if (C0554a.m2459b().m2464a()) {
                this.f2200e.onSessionTry();
                it = this.f2200e.mResponseList.iterator();
                while (it.hasNext()) {
                    ((C0627d) it.next()).mo818d();
                }
                UThread.m1035a(new C0656h(this));
                return;
            }
            throw new WebSessionException();
        } catch (Throwable e) {
            HttpLogger access$400 = WebSession.sHttpLogger;
            if (access$400 != null) {
                access$400.printStackTrace(LogLevel.ERROR, HttpHost.DEFAULT_SCHEME_NAME, "an exception occurs!", e);
            }
            this.f2200e.mSessionException = e;
            it = this.f2200e.mResponseList.iterator();
            while (it.hasNext()) {
                ((C0627d) it.next()).mo818d();
            }
        } catch (Throwable e2) {
            Throwable th = e2;
            Iterator it2 = this.f2200e.mResponseList.iterator();
            while (it2.hasNext()) {
                ((C0627d) it2.next()).mo818d();
            }
        }
    }
}
