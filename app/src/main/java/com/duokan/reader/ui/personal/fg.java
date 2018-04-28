package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import com.wali.live.sdk.manager.IMiLiveSdk.IAssistantCallback;

class fg implements IAssistantCallback {
    /* renamed from: a */
    final /* synthetic */ eu f8539a;

    fg(eu euVar) {
        this.f8539a = euVar;
    }

    public void notifyVersionLow() {
        UThread.runOnThread(new fh(this));
    }

    public void notifyNotInstall() {
    }
}
