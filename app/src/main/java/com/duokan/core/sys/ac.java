package com.duokan.core.sys;

import com.duokan.core.p029c.IRunTask;

class ac implements IRunTask<ae> {
    /* renamed from: a */
    final /* synthetic */ Runnable f627a;
    /* renamed from: b */
    final /* synthetic */ JobManager f628b;

    ac(JobManager JobManager, Runnable runnable) {
        this.f628b = JobManager;
        this.f627a = runnable;
    }

    /* renamed from: a */
    public boolean m854a(ae aeVar) {
        return aeVar.f633c == this.f627a;
    }
}
