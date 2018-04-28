package com.duokan.reader.ui.general;

import android.os.Process;

class hg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ServerSettingActivity f7330a;

    hg(ServerSettingActivity serverSettingActivity) {
        this.f7330a = serverSettingActivity;
    }

    public void run() {
        this.f7330a.finish();
        Process.killProcess(Process.myPid());
    }
}
