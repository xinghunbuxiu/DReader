package com.duokan.reader.domain.micloud;

import com.duokan.core.p029c.C0326b;

/* renamed from: com.duokan.reader.domain.micloud.r */
class C1077r implements C0326b<bl> {
    /* renamed from: a */
    final /* synthetic */ String f5297a;
    /* renamed from: b */
    final /* synthetic */ C1074o f5298b;

    C1077r(C1074o c1074o, String str) {
        this.f5298b = c1074o;
        this.f5297a = str;
    }

    /* renamed from: a */
    public boolean m8278a(bl blVar) {
        return blVar.m8175w().equalsIgnoreCase(this.f5297a);
    }
}
