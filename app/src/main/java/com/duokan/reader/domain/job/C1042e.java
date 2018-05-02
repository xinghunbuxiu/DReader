package com.duokan.reader.domain.job;

import android.app.job.JobParameters;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;

/* renamed from: com.duokan.reader.domain.job.e */
class C1042e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ JobParameters f5140a;
    /* renamed from: b */
    final /* synthetic */ JobManagerService f5141b;

    C1042e(JobManagerService jobManagerService, JobParameters jobParameters) {
        this.f5141b = jobManagerService;
        this.f5140a = jobParameters;
    }

    public void run() {
        this.f5141b.jobFinished(this.f5140a, false);
        if (DkApp.get().forCommunity()) {
            WebLog.init().c(LogLevel.EVENT, "job", "the manager service finished");
        }
    }
}
