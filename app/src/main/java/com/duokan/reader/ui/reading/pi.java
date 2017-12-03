package com.duokan.reader.ui.reading;

import com.duokan.core.app.BaseActivity;
import com.duokan.reader.DkApp;

class pi implements Runnable {
    final /* synthetic */ ph a;

    pi(ph phVar) {
        this.a = phVar;
    }

    public void run() {
        this.a.d.setThumbEnabled(true);
        ((BaseActivity) DkApp.get().getTopActivity()).addOnScreenRotationChangedListener(this.a.m);
    }
}
