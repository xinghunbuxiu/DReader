package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;

class bv implements Runnable {
    final /* synthetic */ bu a;
    private final View b;

    public bv(bu buVar, View view) {
        this.a = buVar;
        this.b = view;
    }

    public void run() {
        if (this.a.d == this) {
            this.a.d = null;
            MotionEvent b = this.a.c != null ? this.a.c : this.a.a;
            if (this.a.c() && b != null && b.getActionMasked() != 1 && b.getActionMasked() != 3) {
                this.a.e = true;
                b = MotionEvent.obtainNoHistory(b);
                b.setAction(2);
                this.b.dispatchTouchEvent(b);
                b.recycle();
                this.a.e = false;
            }
        }
    }
}
