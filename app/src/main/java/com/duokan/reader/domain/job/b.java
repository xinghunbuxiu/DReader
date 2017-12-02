package com.duokan.reader.domain.job;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.net.Uri;

import com.duokan.core.a.a;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.ReaderEnv;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class b implements ah {
    private static String a = (b.class.getName() + ".jobQueue");
    private static int b = Integer.MAX_VALUE;
    private static long c = TimeUnit.HOURS.toMillis(6);
    private static long d = TimeUnit.MINUTES.toMillis(1);
    private static long e = TimeUnit.HOURS.toMillis(1);
    private static final ai f = new ai();
    private final ReaderEnv g;
    private final a h;
    private final HashMap i = new HashMap();

    @TargetApi(21)
    protected b(ReaderEnv readerEnv) {
        this.g = readerEnv;
        this.h = new a(Uri.fromFile(new File(this.g.getDatabaseDirectory(), "jobs.db")).toString());
        try {
            if (a(b)) {
                com.duokan.core.diagnostic.a.c().c(LogLevel.INFO, "job", "the manager service has been already scheduled");
            } else if (f().schedule(new Builder(b, new ComponentName(this.g.getApplication().getPackageName(), JobManagerService.class.getName())).setPeriodic(c).setPersisted(true).build()) > 0) {
                com.duokan.core.diagnostic.a.c().c(LogLevel.INFO, "job", "the manager service is scheduled");
            } else {
                com.duokan.core.diagnostic.a.c().c(LogLevel.ERROR, "job", "fail to schedule the manager service");
            }
        } catch (Throwable th) {
        }
    }

    public static void a(ReaderEnv readerEnv) {
        f.a(new b(readerEnv));
    }

    public static b a() {
        return (b) f.a();
    }

    public synchronized boolean a(String str, Class cls, long j, Serializable serializable) {
        boolean z;
        if (b(str) != null) {
            z = false;
        } else {
            Serializable jobInfo = new JobInfo(str, cls);
            jobInfo.mInitialTime = j;
            jobInfo.mIntervalTime = TimeUnit.DAYS.toMillis(1);
            jobInfo.mExpirationTime = Long.MAX_VALUE;
            jobInfo.mRepeatCount = Integer.MAX_VALUE;
            jobInfo.mParams = serializable;
            this.i.put(str, jobInfo);
            this.h.b(str, jobInfo);
            b(null);
            z = true;
        }
        return z;
    }

    protected void a(Runnable runnable) {
        com.duokan.core.sys.ah.a(new c(this, runnable), a);
    }

    @TargetApi(21)
    protected void b(Runnable runnable) {
        com.duokan.core.sys.ah.a(new d(this, runnable), a);
    }

    private boolean a(JobInfo jobInfo) {
        if (jobInfo.mExpirationTime < System.currentTimeMillis() || jobInfo.mExecCount - 1 >= jobInfo.mRepeatCount) {
            return false;
        }
        if (jobInfo.mExecCount <= 0 || jobInfo.mRepeatCount <= 0 || jobInfo.mIntervalTime > 0) {
            return true;
        }
        return false;
    }

    private void a(String str) {
        this.i.remove(str);
        this.h.b(str);
    }

    private JobInfo b(String str) {
        JobInfo jobInfo = (JobInfo) this.i.get(str);
        if (jobInfo == null) {
            try {
                jobInfo = (JobInfo) this.h.a(str, null);
                if (jobInfo != null) {
                    this.i.put(str, jobInfo);
                }
            } catch (Throwable th) {
            }
        }
        return jobInfo;
    }

    @TargetApi(21)
    private boolean a(int i) {
        try {
            for (JobInfo id : f().getAllPendingJobs()) {
                if (id.getId() == i) {
                    return true;
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    @TargetApi(21)
    private JobScheduler f() {
        return (JobScheduler) this.g.getApplication().getSystemService("jobscheduler");
    }

    private static long g() {
        return TimeUnit.DAYS.toMillis(1) + h();
    }

    private static long h() {
        long toMillis = TimeUnit.DAYS.toMillis(1);
        return (toMillis * (System.currentTimeMillis() / toMillis)) - ((long) TimeZone.getDefault().getRawOffset());
    }
}
