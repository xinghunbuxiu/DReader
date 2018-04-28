package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.ad.C0761r;
import java.util.concurrent.Callable;

class kf implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ ci f8092a;

    kf(ci ciVar) {
        this.f8092a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11253a();
    }

    /* renamed from: a */
    public Boolean m11253a() {
        if (this.f8092a.f7581b.mAdSdkService == null) {
            this.f8092a.f7581b.mAdSdkService = new C0761r(this.f8092a.f7581b.mAdLifecycleManager);
        }
        return Boolean.valueOf(this.f8092a.f7581b.mAdSdkService.m3610a());
    }
}
