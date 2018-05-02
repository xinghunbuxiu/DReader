package com.duokan.reader.domain.ad;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.miui.systemAdSolution.splashAd.IAdListener.Stub;

/* renamed from: com.duokan.reader.domain.ad.z */
final class C0769z extends Stub {
    C0769z() {
    }

    public void onAdError() {
        WebLog.init().c(LogLevel.WARNING, "splash-ad", "on ad error");
    }

    public void onAdLoaded() {
        WebLog.init().c(LogLevel.INFO, "splash-ad", "on ad loaded");
    }
}
