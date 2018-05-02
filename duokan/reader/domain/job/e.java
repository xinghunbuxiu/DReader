package com.duokan.reader.domain.job;

import android.app.job.JobParameters;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;

class e implements Runnable {
    final /* synthetic */ JobParameters a;
    final /* synthetic */ JobManagerService b;

    e(JobManagerService jobManagerService, JobParameters jobParameters) {
        this.b = jobManagerService;
        this.a = jobParameters;
    }

    public void run() {
        this.b.jobFinished(this.a, false);
        if (DkApp.get().forCommunity()) {
            a.c().c(LogLevel.EVENT, "job", "the manager service finished");
        }
    }
}
