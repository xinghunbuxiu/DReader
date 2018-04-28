package com.duokan.core.ui;

import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

class ck implements Runnable {
    /* renamed from: a */
    final /* synthetic */ cj f1082a;

    ck(cj cjVar) {
        this.f1082a = cjVar;
    }

    public void run() {
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 1000;
        layoutParams.token = this.f1082a.f1078b.getWindow().getDecorView().getWindowToken();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.softInputMode = 16;
        layoutParams.flags &= -1793;
        layoutParams.flags |= 65536;
        layoutParams.flags |= 131096;
        this.f1082a.f1078b.getWindowManager().addView(this.f1082a.f1079c, layoutParams);
    }
}
