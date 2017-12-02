package com.duokan.reader.ui.reading;

import android.view.ViewGroup;

import com.duokan.core.app.e;

class kh implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ kd b;

    kh(kd kdVar, e eVar) {
        this.b = kdVar;
        this.a = eVar;
    }

    public void run() {
        this.b.removeSubController(this.a);
        ((ViewGroup) this.b.getContentView()).removeView(this.a.getContentView());
    }
}
