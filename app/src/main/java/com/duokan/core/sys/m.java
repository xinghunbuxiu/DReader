package com.duokan.core.sys;

import android.os.Looper;

final class m implements Runnable {
    final /* synthetic */ s a;

    m(s sVar) {
        this.a = sVar;
    }

    public void run() {
        Looper.myQueue().addIdleHandler(new n(this));
    }
}
