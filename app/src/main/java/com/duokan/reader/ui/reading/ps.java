package com.duokan.reader.ui.reading;

import com.duokan.core.app.BaseActivity;
import com.duokan.reader.DkApp;

class ps implements Runnable {
    /* renamed from: a */
    final /* synthetic */ pr f10823a;

    ps(pr prVar) {
        this.f10823a = prVar;
    }

    public void run() {
        this.f10823a.f10812d.setThumbEnabled(true);
        ((BaseActivity) DkApp.get().getTopActivity()).addOnScreenRotationChangedListener(this.f10823a.f10821m);
    }
}
