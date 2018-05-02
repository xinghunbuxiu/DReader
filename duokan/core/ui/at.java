package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;

class at implements Runnable {
    final /* synthetic */ as a;
    private final View b;

    public at(as asVar, View view) {
        this.a = asVar;
        this.b = view;
    }

    public void run() {
        if (this.a.g == this && this.b.isInTouchMode()) {
            this.a.g = null;
            MotionEvent b = this.a.c != null ? this.a.c : this.a.a;
            if (this.a.c() && b != null && b.getActionMasked() != 1 && b.getActionMasked() != 3) {
                this.a.h = true;
                b = MotionEvent.obtainNoHistory(b);
                b.setAction(2);
                this.b.dispatchTouchEvent(b);
                b.recycle();
                this.a.h = false;
            }
        }
    }
}
