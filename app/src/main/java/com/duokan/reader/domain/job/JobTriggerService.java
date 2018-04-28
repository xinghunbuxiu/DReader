package com.duokan.reader.domain.job;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;

@TargetApi(21)
public class JobTriggerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        if (DkApp.get().forCommunity()) {
            C0328a.m757c().m749a(LogLevel.EVENT, "job", "a trigger service started(id: %d)", Integer.valueOf(jobParameters.getJobId()));
        }
        C1039b.m7967a().m7984a(new C1043f(this, jobParameters));
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
