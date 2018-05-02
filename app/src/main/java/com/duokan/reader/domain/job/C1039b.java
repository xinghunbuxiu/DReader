package com.duokan.reader.domain.job;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.net.Uri;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.p026a.C0272a;
import com.duokan.core.sys.ah;
import com.duokan.reader.ReaderEnv;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: com.duokan.reader.domain.job.b */
public class C1039b implements ai {
    /* renamed from: a */
    private static String f5127a = (C1039b.class.getName() + ".jobQueue");
    /* renamed from: b */
    private static int f5128b = Integer.MAX_VALUE;
    /* renamed from: c */
    private static long f5129c = TimeUnit.HOURS.toMillis(6);
    /* renamed from: d */
    private static long f5130d = TimeUnit.MINUTES.toMillis(1);
    /* renamed from: e */
    private static long f5131e = TimeUnit.HOURS.toMillis(1);
    /* renamed from: f */
    private static final aj<C1039b> f5132f = new aj();
    /* renamed from: g */
    private final ReaderEnv f5133g;
    /* renamed from: h */
    private final C0272a f5134h;
    /* renamed from: i */
    private final HashMap<String, JobInfo> f5135i = new HashMap();

    @TargetApi(21)
    protected C1039b(ReaderEnv readerEnv) {
        this.f5133g = readerEnv;
        this.f5134h = new C0272a(Uri.fromFile(new File(this.f5133g.getDatabaseDirectory(), "jobs.db")).toString());
        try {
            if (m7970a(f5128b)) {
                WebLog.init().c(LogLevel.INFO, "job", "the manager service has been already scheduled");
            } else if (m7981f().schedule(new Builder(f5128b, new ComponentName(this.f5133g.getApplication().getPackageName(), JobManagerService.class.getName())).setPeriodic(f5129c).setPersisted(true).build()) > 0) {
                WebLog.init().c(LogLevel.INFO, "job", "the manager service is scheduled");
            } else {
                WebLog.init().c(LogLevel.ERROR, "job", "fail to schedule the manager service");
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static void m7968a(ReaderEnv readerEnv) {
        f5132f.m709a(new C1039b(readerEnv));
    }

    /* renamed from: a */
    public static C1039b m7967a() {
        return (C1039b) f5132f.m707a();
    }

    /* renamed from: a */
    public synchronized boolean m7985a(String str, Class<? extends C0494a> cls, long j, Serializable serializable) {
        boolean z;
        if (m7975b(str) != null) {
            z = false;
        } else {
            Serializable jobInfo = new JobInfo(str, cls);
            jobInfo.mInitialTime = j;
            jobInfo.mIntervalTime = TimeUnit.DAYS.toMillis(1);
            jobInfo.mExpirationTime = Long.MAX_VALUE;
            jobInfo.mRepeatCount = Integer.MAX_VALUE;
            jobInfo.mParams = serializable;
            this.f5135i.put(str, jobInfo);
            this.f5134h.m634b(str, jobInfo);
            m7986b(null);
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    protected void m7984a(Runnable runnable) {
        ah.m866a(new C1040c(this, runnable), f5127a);
    }

    @TargetApi(21)
    /* renamed from: b */
    protected void m7986b(Runnable runnable) {
        ah.m866a(new C1041d(this, runnable), f5127a);
    }

    /* renamed from: a */
    private boolean m7971a(JobInfo jobInfo) {
        if (jobInfo.mExpirationTime < System.currentTimeMillis() || jobInfo.mExecCount - 1 >= jobInfo.mRepeatCount) {
            return false;
        }
        if (jobInfo.mExecCount <= 0 || jobInfo.mRepeatCount <= 0 || jobInfo.mIntervalTime > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m7969a(String str) {
        this.f5135i.remove(str);
        this.f5134h.m633b(str);
    }

    /* renamed from: b */
    private JobInfo m7975b(String str) {
        JobInfo jobInfo = (JobInfo) this.f5135i.get(str);
        if (jobInfo == null) {
            try {
                jobInfo = (JobInfo) this.f5134h.m631a(str, null);
                if (jobInfo != null) {
                    this.f5135i.put(str, jobInfo);
                }
            } catch (Throwable th) {
            }
        }
        return jobInfo;
    }

    @TargetApi(21)
    /* renamed from: a */
    private boolean m7970a(int i) {
        try {
            for (JobInfo id : m7981f().getAllPendingJobs()) {
                if (id.getId() == i) {
                    return true;
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    @TargetApi(21)
    /* renamed from: f */
    private JobScheduler m7981f() {
        return (JobScheduler) this.f5133g.getApplication().getSystemService("jobscheduler");
    }

    /* renamed from: g */
    private static long m7982g() {
        return TimeUnit.DAYS.toMillis(1) + C1039b.m7983h();
    }

    /* renamed from: h */
    private static long m7983h() {
        long toMillis = TimeUnit.DAYS.toMillis(1);
        return (toMillis * (System.currentTimeMillis() / toMillis)) - ((long) TimeZone.getDefault().getRawOffset());
    }
}
