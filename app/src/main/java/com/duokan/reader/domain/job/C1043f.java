package com.duokan.reader.domain.job;

import android.app.job.JobParameters;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;

/* renamed from: com.duokan.reader.domain.job.f */
class C1043f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ JobParameters f5142a;
    /* renamed from: b */
    final /* synthetic */ JobTriggerService f5143b;

    C1043f(JobTriggerService jobTriggerService, JobParameters jobParameters) {
        this.f5143b = jobTriggerService;
        this.f5142a = jobParameters;
    }

    public void run() {
        this.f5143b.jobFinished(this.f5142a, false);
        if (DkApp.get().forCommunity()) {
            WebLog.init().a(LogLevel.EVENT, "job", "a trigger service finished(id: %d)", Integer.valueOf(this.f5142a.getJobId()));
        }
    }
}
