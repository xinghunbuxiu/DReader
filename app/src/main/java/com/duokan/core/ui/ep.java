package com.duokan.core.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ep implements OnAttachStateChangeListener, OnPreDrawListener {
    private final View a;

    public ep(View view) {
        this.a = view;
        if (this.a.getWindowToken() != null) {
            this.a.getViewTreeObserver().addOnPreDrawListener(this);
        }
        this.a.addOnAttachStateChangeListener(this);
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.removeOnAttachStateChangeListener(this);
        return a(this.a);
    }

    public final void onViewAttachedToWindow(View view) {
        this.a.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.removeOnAttachStateChangeListener(this);
    }

    protected boolean a(View view) {
        return false;
    }
}
