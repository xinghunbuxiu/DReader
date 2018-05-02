package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

/* renamed from: com.duokan.core.ui.y */
class C0397y extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ HatGridView f1343a;

    C0397y(HatGridView hatGridView, Context context) {
        this.f1343a = hatGridView;
        super(context);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (!this.f1343a.f828r) {
            canvas.clipRect(0, 0, getWidth(), getHeight() - Math.min(this.f1343a.f811a.getScrollY() - (this.f1343a.f814d.getScrollY() + this.f1343a.m1229t()), this.f1343a.getHatVisibleHeight()));
        }
        super.dispatchDraw(canvas);
    }
}
