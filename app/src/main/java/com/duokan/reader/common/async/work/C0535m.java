package com.duokan.reader.common.async.work;

import com.duokan.core.p029c.C0326b;

/* renamed from: com.duokan.reader.common.async.work.m */
class C0535m implements C0326b<TItem> {
    /* renamed from: a */
    final /* synthetic */ String f1793a;
    /* renamed from: b */
    final /* synthetic */ C0533k f1794b;

    C0535m(C0533k c0533k, String str) {
        this.f1794b = c0533k;
        this.f1793a = str;
    }

    /* renamed from: a */
    public boolean m2383a(TItem tItem) {
        return tItem.m2285b().equals(this.f1793a);
    }
}
