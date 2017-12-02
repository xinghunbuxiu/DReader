package com.duokan.core.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;

class df extends dd {
    final /* synthetic */ de a;

    df(de deVar, Context context) {
        this.a = deVar;
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        MotionEvent a = dv.a(motionEvent, (View) this, this.a.b.getWindow().getDecorView());
        boolean dispatchTouchEvent = this.a.b.getWindow().getDecorView().dispatchTouchEvent(a);
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
            return keyEvent.dispatch(this.a.b, getKeyDispatcherState(), this.a.b);
        }
        return this.a.b.dispatchKeyEvent(keyEvent);
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
