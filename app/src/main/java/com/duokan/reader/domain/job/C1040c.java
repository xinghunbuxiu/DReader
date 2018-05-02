package com.duokan.reader.domain.job;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.reader.DkApp;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.duokan.reader.domain.job.c */
class C1040c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f5136a;
    /* renamed from: b */
    final /* synthetic */ C1039b f5137b;

    C1040c(C1039b c1039b, Runnable runnable) {
        this.f5137b = c1039b;
        this.f5136a = runnable;
    }

    public void run() {
        Serializable serializable;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList = new LinkedList();
            synchronized (this.f5137b) {
                for (String a : this.f5137b.f5134h.m639e()) {
                    JobInfo a2 = this.f5137b.m7975b(a);
                    if (a2 != null && this.f5137b.m7971a(a2)) {
                        long max = Math.max(a2.mIntervalTime, C1039b.f5131e);
                        for (long j = a2.mInitialTime + (((long) a2.mExecCount) * max); j < currentTimeMillis; j += max) {
                            linkedList.add(a2);
                        }
                    }
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                serializable = (JobInfo) it.next();
                ((C0494a) serializable.mJobClass.newInstance()).exec(this.f5137b.f5133g.getApplication(), serializable);
                serializable.mExecCount++;
                this.f5137b.f5134h.m634b(serializable.mJobName, serializable);
                if (DkApp.get().forCommunity()) {
                    WebLog.init().a(LogLevel.EVENT, "job", "a job is done(name: %s, exec: %d)", serializable.mJobName, Integer.valueOf(serializable.mExecCount));
                }
            }
            UIdleHandler.runAction(this.f5136a);
        } catch (Throwable th) {
            UIdleHandler.runAction(this.f5136a);
        }
    }
}
