package com.duokan.core.sys;

import android.text.TextUtils;
import com.duokan.core.p029c.IRunTask;

class ad implements IRunTask<ae> {
    /* renamed from: a */
    final /* synthetic */ JobManager f629a;
    /* renamed from: b */
    private final ae f630b;

    public ad(JobManager JobManager, ae aeVar) {
        this.f629a = JobManager;
        this.f630b = aeVar;
    }

    /* renamed from: a */
    public boolean m856a(ae aeVar) {
        if (this.f630b.f633c == aeVar.f633c) {
            return true;
        }
        if (TextUtils.isEmpty(this.f630b.f631a) || TextUtils.isEmpty(aeVar.f631a)) {
            return false;
        }
        return this.f630b.f631a.equals(aeVar.f631a);
    }
}
