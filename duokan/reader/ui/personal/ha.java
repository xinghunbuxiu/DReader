package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;

class ha extends FrameLayout {
    final /* synthetic */ fl a;

    ha(fl flVar, Context context) {
        this.a = flVar;
        super(context);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        canvas.save();
        canvas.clipRect(0, Math.min(this.a.c.getViewportBounds().top + this.a.y, getMeasuredHeight()), getMeasuredWidth(), getMeasuredHeight());
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }
}
