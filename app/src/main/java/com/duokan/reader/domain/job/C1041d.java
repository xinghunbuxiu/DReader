package com.duokan.reader.domain.job;

import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UIdleHandler;

/* renamed from: com.duokan.reader.domain.job.d */
class C1041d implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f5138a;
    /* renamed from: b */
    final /* synthetic */ C1039b f5139b;

    C1041d(C1039b c1039b, Runnable runnable) {
        this.f5139b = c1039b;
        this.f5138a = runnable;
    }

    public void run() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long c = C1039b.m7983h();
            long d = C1039b.m7982g();
            synchronized (this.f5139b) {
                JobScheduler c2 = this.f5139b.m7981f();
                for (String str : this.f5139b.f5134h.m639e()) {
                    JobInfo a = this.f5139b.m7975b(str);
                    if (a != null) {
                        if (this.f5139b.m7971a(a)) {
                            long max = Math.max(a.mIntervalTime, C1039b.f5131e);
                            long j = a.mInitialTime + (((long) a.mExecCount) * max);
                            for (int i = a.mExecCount; i - 1 < a.mRepeatCount && j < d; i++) {
                                if (j >= c) {
                                    if (c2.schedule(new Builder(((int) (Math.max(j - c, 0) / C1039b.f5130d)) + 1, new ComponentName(this.f5139b.f5133g.getApplication().getPackageName(), JobTriggerService.class.getName())).setMinimumLatency(Math.max(0, j - currentTimeMillis)).setOverrideDeadline(Math.max(0, j - currentTimeMillis)).setPersisted(true).build()) > 0) {
                                        WebLog.init().a(LogLevel.INFO, "job", "a trigger service is scheduled(id: %d)", Integer.valueOf(((int) (Math.max(j - c, 0) / C1039b.f5130d)) + 1));
                                    } else {
                                        WebLog.init().a(LogLevel.ERROR, "job", "fail to schedule a trigger service(id: %d)", Integer.valueOf(((int) (Math.max(j - c, 0) / C1039b.f5130d)) + 1));
                                    }
                                }
                                j += max;
                            }
                        } else {
                            this.f5139b.m7969a(str);
                        }
                    }
                }
            }
        } catch (Throwable th) {
        } finally {
            UIdleHandler.runAction(this.f5138a);
        }
    }
}
