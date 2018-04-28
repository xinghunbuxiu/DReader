package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;

class at implements Runnable {
    /* renamed from: a */
    final /* synthetic */ as f985a;
    /* renamed from: b */
    private final View f986b;

    public at(as asVar, View view) {
        this.f985a = asVar;
        this.f986b = view;
    }

    public void run() {
        if (this.f985a.f983g == this && this.f986b.isInTouchMode()) {
            this.f985a.f983g = null;
            MotionEvent b = this.f985a.f979c != null ? this.f985a.f979c : this.f985a.f978a;
            if (this.f985a.m1618c() && b != null && b.getActionMasked() != 1 && b.getActionMasked() != 3) {
                this.f985a.f984h = true;
                b = MotionEvent.obtainNoHistory(b);
                b.setAction(2);
                this.f986b.dispatchTouchEvent(b);
                b.recycle();
                this.f985a.f984h = false;
            }
        }
    }
}
