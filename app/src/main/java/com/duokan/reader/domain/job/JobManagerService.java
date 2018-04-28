package com.duokan.reader.domain.job;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;

@TargetApi(21)
public class JobManagerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        if (DkApp.get().forCommunity()) {
            C0328a.m757c().m752c(LogLevel.EVENT, "job", "the manager service started");
        }
        C1039b.m7967a().m7986b(new C1042e(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
