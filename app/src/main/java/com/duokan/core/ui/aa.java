package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

class aa extends FrameLayout {
    final /* synthetic */ HatGridView a;

    aa(HatGridView hatGridView, Context context) {
        this.a = hatGridView;
        super(context);
    }

    protected void dispatchDraw(Canvas canvas) {
        canvas.clipRect(0, getScrollY(), getWidth(), (getScrollY() + getHeight()) - this.a.i.getHeight());
        super.dispatchDraw(canvas);
    }
}
