package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.ad.r;

import java.util.concurrent.Callable;

class jq implements Callable {
    final /* synthetic */ cg a;

    jq(cg cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        if (this.a.b.mAdSdkService == null) {
            this.a.b.mAdSdkService = new r(this.a.b.mAdLifecycleManager);
        }
        return Boolean.valueOf(this.a.b.mAdSdkService.a());
    }
}
