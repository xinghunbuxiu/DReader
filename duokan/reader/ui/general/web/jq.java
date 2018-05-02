package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.ad.r;

import java.util.concurrent.Callable;

class jq implements Callable {
    final /* synthetic */ PageController a;

    jq(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        if (this.a.pageController.mAdSdkService == null) {
            this.a.pageController.mAdSdkService = new r(this.a.pageController.mAdLifecycleManager);
        }
        return Boolean.valueOf(this.a.pageController.mAdSdkService.a());
    }
}
