package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;

class cl extends View {
    final /* synthetic */ cj a;

    public cl(cj cjVar, Context context) {
        this.a = cjVar;
        super(context);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (this.a.d.isEmpty() && displayMetrics.heightPixels - getHeight() >= UTools.getMinimumHeight(getContext(), 100.0f)) {
            a(this.a.d);
            this.a.d();
        } else if (!this.a.d.isEmpty() && displayMetrics.heightPixels - getHeight() >= UTools.getMinimumHeight(getContext(), 100.0f)) {
            Rect rect = (Rect) UTools.g.getRect();
            a(rect);
            if (!this.a.d.equals(rect)) {
                this.a.d.set(rect);
                this.a.f();
            }
            UTools.g.getRect(rect);
        } else if (!this.a.d.isEmpty()) {
            this.a.d.setEmpty();
            this.a.e();
        }
    }

    private void a(Rect rect) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        rect.set(0, 0, getWidth(), getHeight());
        UTools.closeAnimation(rect, (View) this);
        rect.top = rect.bottom;
        rect.bottom = displayMetrics.heightPixels;
    }
}
