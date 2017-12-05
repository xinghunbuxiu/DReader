package com.duokan.reader.domain.job;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.DkApp;

@TargetApi(21)
public class JobManagerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        if (DkApp.get().forCommunity()) {
            WebLog.c().c(LogLevel.EVENT, "job", "the manager service started");
        }
        b.a().b(new e(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
