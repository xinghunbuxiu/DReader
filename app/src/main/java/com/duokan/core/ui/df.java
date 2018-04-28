package com.duokan.core.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;

class df extends dd {
    /* renamed from: a */
    final /* synthetic */ de f1140a;

    df(de deVar, Context context) {
        this.f1140a = deVar;
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        MotionEvent a = dv.m1908a(motionEvent, (View) this, this.f1140a.f1136b.getWindow().getDecorView());
        boolean dispatchTouchEvent = this.f1140a.f1136b.getWindow().getDecorView().dispatchTouchEvent(a);
        a.recycle();
        return dispatchTouchEvent;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (getChildAt(childCount).dispatchKeyEvent(keyEvent)) {
                return true;
            }
        }
        if (hasFocus()) {
            return keyEvent.dispatch(this.f1140a.f1136b, getKeyDispatcherState(), this.f1140a.f1136b);
        }
        return this.f1140a.f1136b.dispatchKeyEvent(keyEvent);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (VERSION.SDK_INT < 21) {
            return super.onApplyWindowInsets(windowInsets);
        }
        int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        int systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
        setPadding(0, 0, 0, windowInsets.getSystemWindowInsetBottom());
        return super.onApplyWindowInsets(windowInsets.replaceSystemWindowInsets(systemWindowInsetLeft, systemWindowInsetTop, systemWindowInsetRight, 0));
    }
}
