package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;

class cl extends View {
    
    final  cj f1083a;

    public cl(cj cjVar, Context context) {
        this.f1083a = cjVar;
        super(context);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (this.f1083a.f1080d.isEmpty() && displayMetrics.heightPixels - getHeight() >= AnimUtils.m1932b(getContext(), 100.0f)) {
            m1778a(this.f1083a.f1080d);
            this.f1083a.m1768d();
        } else if (!this.f1083a.f1080d.isEmpty() && displayMetrics.heightPixels - getHeight() >= AnimUtils.m1932b(getContext(), 100.0f)) {
            Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
            m1778a(rect);
            if (!this.f1083a.f1080d.equals(rect)) {
                this.f1083a.f1080d.set(rect);
                this.f1083a.m1772f();
            }
            AnimUtils.f1198g.clearAnimation(rect);
        } else if (!this.f1083a.f1080d.isEmpty()) {
            this.f1083a.f1080d.setEmpty();
            this.f1083a.m1770e();
        }
    }

    
    private void m1778a(Rect rect) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        rect.set(0, 0, getWidth(), getHeight());
        AnimUtils.m1936b(rect, (View) this);
        rect.top = rect.bottom;
        rect.bottom = displayMetrics.heightPixels;
    }
}
