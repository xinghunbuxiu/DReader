package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

class aa extends FrameLayout {
    final HatGridView a;

    public aa(HatGridView hatGridView, Context context) {
        super(context);
        this.a = hatGridView;
    }

    protected void dispatchDraw(Canvas canvas) {
        canvas.clipRect(0, getScrollY(), getWidth(), (getScrollY() + getHeight()) - this.a.i.getHeight());
        super.dispatchDraw(canvas);
    }
}
