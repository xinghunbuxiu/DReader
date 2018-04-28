package com.duokan.core.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ep implements OnAttachStateChangeListener, OnPreDrawListener {
    /* renamed from: a */
    private final View f1209a;

    public ep(View view) {
        this.f1209a = view;
        if (this.f1209a.getWindowToken() != null) {
            this.f1209a.getViewTreeObserver().addOnPreDrawListener(this);
        }
        this.f1209a.addOnAttachStateChangeListener(this);
    }

    public final boolean onPreDraw() {
        this.f1209a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f1209a.removeOnAttachStateChangeListener(this);
        return mo520a(this.f1209a);
    }

    public final void onViewAttachedToWindow(View view) {
        this.f1209a.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f1209a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f1209a.removeOnAttachStateChangeListener(this);
    }

    /* renamed from: a */
    protected boolean mo520a(View view) {
        return false;
    }
}
