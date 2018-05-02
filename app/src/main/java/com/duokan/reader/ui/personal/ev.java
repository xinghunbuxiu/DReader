package com.duokan.reader.ui.personal;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.reader.ReaderEnv;
import com.wali.live.sdk.manager.IMiLiveSdk.CallbackWrapper;
import com.wali.live.watchsdk.ipc.service.ShareInfo;

class ev extends CallbackWrapper {
    /* renamed from: a */
    final /* synthetic */ eu f8526a;

    ev(eu euVar) {
        this.f8526a = euVar;
    }

    public void notifyServiceNull(int i) {
        WebLog.init().c(LogLevel.ERROR, "miLive", "notifyServiceNull aidlFlag=" + i);
    }

    public void notifyAidlFailure(int i) {
        WebLog.init().c(LogLevel.ERROR, "miLive", "notifyAidlFailure aidlFlag=" + i);
    }

    public void notifyLogin(int i) {
        if (i == 0) {
            UThread.runOnThread(new ew(this));
        } else {
            UThread.runOnThread(new ex(this));
        }
    }

    public void notifyLogoff(int i) {
        if (i != 0) {
            WebLog.init().c(LogLevel.ERROR, "miLive", "LogoutError errorCode=" + i);
        } else {
            ReaderEnv.get().setMiLiveUser("");
        }
    }

    public void notifyWantLogin() {
        UThread.runOnThread(new ey(this));
    }

    public void notifyVerifyFailure(int i) {
        WebLog.init().c(LogLevel.ERROR, "miLive", "验证失败，errCode=" + i);
    }

    public void notifyOtherAppActive() {
        WebLog.init().c(LogLevel.ERROR, "miLive", "有其他APP在活跃");
    }

    public void notifyWantShare(ShareInfo shareInfo) {
    }
}
