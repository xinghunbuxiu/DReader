package com.duokan.reader.ui.reading;

import android.view.ViewGroup;
import com.duokan.core.app.ActivatedController;

class kr implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ActivatedController f10525a;
    /* renamed from: b */
    final /* synthetic */ kn f10526b;

    kr(kn knVar, ActivatedController c0303e) {
        this.f10526b = knVar;
        this.f10525a = c0303e;
    }

    public void run() {
        this.f10526b.removeSubController(this.f10525a);
        ((ViewGroup) this.f10526b.getContentView()).removeView(this.f10525a.getContentView());
    }
}
