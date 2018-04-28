package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;

class hn extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ fz f8664a;

    hn(fz fzVar, Context context) {
        this.f8664a = fzVar;
        super(context);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        canvas.save();
        canvas.clipRect(0, Math.min(this.f8664a.f8576c.getViewportBounds().top + this.f8664a.f8597x, getMeasuredHeight()), getMeasuredWidth(), getMeasuredHeight());
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }
}
