package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

class aa extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ HatGridView f892a;

    aa(HatGridView hatGridView, Context context) {
        this.f892a = hatGridView;
        super(context);
    }

    protected void dispatchDraw(Canvas canvas) {
        canvas.clipRect(0, getScrollY(), getWidth(), (getScrollY() + getHeight()) - this.f892a.f819i.getHeight());
        super.dispatchDraw(canvas);
    }
}
