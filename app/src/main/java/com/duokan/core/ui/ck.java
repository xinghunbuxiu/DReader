package com.duokan.core.ui;

import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

import miuipub.date.Calendar;

class ck implements Runnable {
    final /* synthetic */ cj a;

    ck(cj cjVar) {
        this.a = cjVar;
    }

    public void run() {
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = Calendar.MILLISECOND_OF_SECOND;
        layoutParams.token = this.a.b.getWindow().getDecorView().getWindowToken();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.softInputMode = 16;
        layoutParams.flags &= -1793;
        layoutParams.flags |= 65536;
        layoutParams.flags |= 131096;
        this.a.b.getWindowManager().addView(this.a.c, layoutParams);
    }
}
