package com.duokan.reader.domain.micloud;

import com.duokan.core.p029c.IRunTask;

/* renamed from: com.duokan.reader.domain.micloud.k */
class C1070k implements IRunTask<C1068i> {
    /* renamed from: a */
    final /* synthetic */ String f5286a;
    /* renamed from: b */
    final /* synthetic */ C1069j f5287b;

    C1070k(C1069j c1069j, String str) {
        this.f5287b = c1069j;
        this.f5286a = str;
    }

    /* renamed from: a */
    public boolean m8237a(C1068i c1068i) {
        return c1068i.m8228w().equals(this.f5286a);
    }
}
