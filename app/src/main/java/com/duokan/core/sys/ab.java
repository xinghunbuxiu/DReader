package com.duokan.core.sys;

import java.util.Comparator;

class ab implements Comparator<ae> {
    /* renamed from: a */
    final  JobManager f626a;

    ab(JobManager JobManager) {
        this.f626a = JobManager;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m853a((ae) obj, (ae) obj2);
    }

    /* renamed from: a */
    public int m853a(ae aeVar, ae aeVar2) {
        if (aeVar.f632b < aeVar2.f632b) {
            return 1;
        }
        if (aeVar.f632b > aeVar2.f632b) {
            return -1;
        }
        return 0;
    }
}
