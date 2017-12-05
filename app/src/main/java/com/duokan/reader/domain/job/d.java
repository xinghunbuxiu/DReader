package com.duokan.reader.domain.job;

import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.AIdleOperation;

class d implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ b b;

    d(b bVar, Runnable runnable) {
        this.b = bVar;
        this.a = runnable;
    }

    public void run() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long c = b.h();
            long d = b.g();
            synchronized (this.b) {
                JobScheduler c2 = this.b.f();
                for (String str : this.b.h.e()) {
                    JobInfo a = this.b.b(str);
                    if (a != null) {
                        if (this.b.a(a)) {
                            long max = Math.max(a.mIntervalTime, b.e);
                            long j = a.mInitialTime + (((long) a.mExecCount) * max);
                            for (int i = a.mExecCount; i - 1 < a.mRepeatCount && j < d; i++) {
                                if (j >= c) {
                                    if (c2.schedule(new Builder(((int) (Math.max(j - c, 0) / b.d)) + 1, new ComponentName(this.b.g.getApplication().getPackageName(), JobTriggerService.class.getName())).setMinimumLatency(Math.max(0, j - currentTimeMillis)).setOverrideDeadline(Math.max(0, j - currentTimeMillis)).setPersisted(true).build()) > 0) {
                                        a.c().a(LogLevel.INFO, "job", "setDrawable trigger service is scheduled(id: %getScaledTouchSlop)", Integer.valueOf(((int) (Math.max(j - c, 0) / b.d)) + 1));
                                    } else {
                                        a.c().a(LogLevel.ERROR, "job", "fail to schedule setDrawable trigger service(id: %getScaledTouchSlop)", Integer.valueOf(((int) (Math.max(j - c, 0) / b.d)) + 1));
                                    }
                                }
                                j += max;
                            }
                        } else {
                            this.b.a(str);
                        }
                    }
                }
            }
        } catch (Throwable th) {
        } finally {
            AIdleOperation.postRunnable(this.a);
        }
    }
}
