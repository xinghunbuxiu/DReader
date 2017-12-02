package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

class y extends FrameLayout {
    final /* synthetic */ HatGridView a;

    y(HatGridView hatGridView, Context context) {
        this.a = hatGridView;
        super(context);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.a.r) {
            canvas.clipRect(0, 0, getWidth(), getHeight() - Math.min(this.a.a.getScrollY() - (this.a.d.getScrollY() + this.a.t()), this.a.getHatVisibleHeight()));
        }
        super.dispatchDraw(canvas);
    }
}
