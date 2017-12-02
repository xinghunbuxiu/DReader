package com.duokan.reader.domain.job;

import android.app.job.JobParameters;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.DkApp;

class f implements Runnable {
    final /* synthetic */ JobParameters a;
    final /* synthetic */ JobTriggerService b;

    f(JobTriggerService jobTriggerService, JobParameters jobParameters) {
        this.b = jobTriggerService;
        this.a = jobParameters;
    }

    public void run() {
        this.b.jobFinished(this.a, false);
        if (DkApp.get().forCommunity()) {
            a.c().a(LogLevel.EVENT, "job", "a trigger service finished(id: %d)", Integer.valueOf(this.a.getJobId()));
        }
    }
}
