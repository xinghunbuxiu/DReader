package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;

class cp implements as {
    /* renamed from: a */
    final /* synthetic */ String f7686a;
    /* renamed from: b */
    final /* synthetic */ String f7687b;
    /* renamed from: c */
    final /* synthetic */ boolean f7688c;
    /* renamed from: d */
    final /* synthetic */ ci f7689d;

    cp(ci ciVar, String str, String str2, boolean z) {
        this.f7689d = ciVar;
        this.f7686a = str;
        this.f7687b = str2;
        this.f7688c = z;
    }

    /* renamed from: a */
    public void mo1831a() {
        DkSharedStorageManager.m5016a().m5026a(this.f7686a, this.f7687b, this.f7688c);
    }
}
