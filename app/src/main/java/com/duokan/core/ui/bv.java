package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;

class bv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bu f1037a;
    /* renamed from: b */
    private final View f1038b;

    public bv(bu buVar, View view) {
        this.f1037a = buVar;
        this.f1038b = view;
    }

    public void run() {
        if (this.f1037a.f1035d == this) {
            this.f1037a.f1035d = null;
            MotionEvent b = this.f1037a.f1034c != null ? this.f1037a.f1034c : this.f1037a.f1033a;
            if (this.f1037a.m1618c() && b != null && b.getActionMasked() != 1 && b.getActionMasked() != 3) {
                this.f1037a.f1036e = true;
                b = MotionEvent.obtainNoHistory(b);
                b.setAction(2);
                this.f1038b.dispatchTouchEvent(b);
                b.recycle();
                this.f1037a.f1036e = false;
            }
        }
    }
}
