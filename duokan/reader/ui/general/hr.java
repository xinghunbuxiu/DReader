package com.duokan.reader.ui.general;

import android.os.Process;

class hr implements Runnable {
    final /* synthetic */ ServerSettingActivity a;

    hr(ServerSettingActivity serverSettingActivity) {
        this.a = serverSettingActivity;
    }

    public void run() {
        this.a.finish();
        Process.killProcess(Process.myPid());
    }
}
