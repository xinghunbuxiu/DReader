package com.duokan.reader.domain.job;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.j;
import com.duokan.reader.DkApp;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

class c implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ b b;

    c(b bVar, Runnable runnable) {
        this.b = bVar;
        this.a = runnable;
    }

    public void run() {
        Serializable serializable;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList = new LinkedList();
            synchronized (this.b) {
                for (String a : this.b.h.e()) {
                    JobInfo a2 = this.b.b(a);
                    if (a2 != null && this.b.a(a2)) {
                        long max = Math.max(a2.mIntervalTime, b.e);
                        for (long j = a2.mInitialTime + (((long) a2.mExecCount) * max); j < currentTimeMillis; j += max) {
                            linkedList.add(a2);
                        }
                    }
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                serializable = (JobInfo) it.next();
                ((a) serializable.mJobClass.newInstance()).exec(this.b.g.getApplication(), serializable);
                serializable.mExecCount++;
                this.b.h.b(serializable.mJobName, serializable);
                if (DkApp.get().forCommunity()) {
                    a.c().a(LogLevel.EVENT, "job", "a job is done(name: %s, exec: %d)", serializable.mJobName, Integer.valueOf(serializable.mExecCount));
                }
            }
            j.a(this.a);
        } catch (Throwable th) {
            j.a(this.a);
        }
    }
}
