package com.duokan.reader.ui.reading;

import android.view.ViewGroup;

import com.duokan.core.app.ActivatedController;

class kh implements Runnable {
    final /* synthetic */ ActivatedController a;
    final /* synthetic */ kd b;

    kh(kd kdVar, ActivatedController controller) {
        this.b = kdVar;
        this.a = controller;
    }

    public void run() {
        this.b.removeSubController(this.a);
        ((ViewGroup) this.b.getContentView()).removeView(this.a.getContentView());
    }
}
