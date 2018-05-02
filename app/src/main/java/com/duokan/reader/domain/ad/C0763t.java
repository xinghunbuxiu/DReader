package com.duokan.reader.domain.ad;

import com.duokan.core.sys.UThread;
import com.miui.systemAdSolution.landingPage.ILandingPageListener.Stub;

/* renamed from: com.duokan.reader.domain.ad.t */
class C0763t extends Stub {
    /* renamed from: a */
    final /* synthetic */ C0748e f2588a;
    /* renamed from: b */
    final /* synthetic */ C0761r f2589b;

    C0763t(C0761r c0761r, C0748e c0748e) {
        this.f2589b = c0761r;
        this.f2588a = c0748e;
    }

    public void onDownloadStart() {
        UThread.runOnThread(new C0764u(this));
    }

    public void onDownloadSuccess() {
        UThread.runOnThread(new C0765v(this));
    }

    public void onLanuchAppSuccess() {
    }

    public void onLanuchAppFail() {
    }

    public void onDeeplinkFail() {
    }

    public void onDownloadPause(String str) {
    }

    public void onH5Fail() {
    }

    public void onDeeplinkSuccess() {
    }

    public void onDownloadCancel() {
    }

    public void onDownloadFail(String str) {
    }

    public void onDownloadProgress(int i) {
        this.f2589b.f2586d.m3530a(this.f2588a.f2533r, i);
    }

    public void onH5Success() {
    }

    public void onInstallFail(String str) {
    }

    public void onInstallSuccess() {
        UThread.runOnThread(new C0766w(this));
    }
}
