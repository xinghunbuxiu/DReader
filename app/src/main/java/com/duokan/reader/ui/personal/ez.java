package com.duokan.reader.ui.personal;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.wali.live.sdk.manager.IMiLiveSdk.IUpdateListener;

class ez implements IUpdateListener {
    /* renamed from: a */
    final /* synthetic */ eu f8530a;

    ez(eu euVar) {
        this.f8530a = euVar;
    }

    public void onNewVersionAvail(boolean z) {
    }

    public void onNoNewerVersion() {
    }

    public void onCheckVersionFailed() {
        C0328a.m757c().m752c(LogLevel.ERROR, "miLive", "checkVersionFailed");
        UThread.runOnThread(new fa(this));
    }

    public void onDuplicatedRequest() {
        UThread.runOnThread(new fb(this));
    }

    public void onDownloadStart() {
    }

    public void onDownloadProgress(int i) {
        UThread.runOnThread(new fc(this, i));
    }

    public void onDownloadSuccess(String str) {
        UThread.runOnThread(new fd(this));
    }

    public void onDownloadFailed(int i) {
        C0328a.m757c().m752c(LogLevel.ERROR, "miLive", "downloadFailed ErrorCode=" + i);
        UThread.runOnThread(new fe(this));
    }
}
