package com.duokan.reader.domain.ad;

import com.duokan.core.sys.TaskHandler;
import com.miui.systemAdSolution.landingPage.ILandingPageListener.Stub;

class t extends Stub {
    final /* synthetic */ e a;
    final /* synthetic */ r b;

    t(r rVar, e eVar) {
        this.b = rVar;
        this.a = eVar;
    }

    public void onDownloadStart() {
        TaskHandler.postTask(new u(this));
    }

    public void onDownloadSuccess() {
        TaskHandler.postTask(new v(this));
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
        this.b.d.a(this.a.r, i);
    }

    public void onH5Success() {
    }

    public void onInstallFail(String str) {
    }

    public void onInstallSuccess() {
        TaskHandler.postTask(new w(this));
    }
}
