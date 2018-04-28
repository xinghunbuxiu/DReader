package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.duokan.reader.ui.general.C1321a;

class gc extends C1321a {
    /* renamed from: a */
    final /* synthetic */ fz f10221a;

    public gc(fz fzVar, Context context) {
        this.f10221a = fzVar;
        super(context);
        setWillNotDraw(false);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (m10202e()) {
            invalidate();
        }
        canvas.save();
        canvas.translate(0.0f, (float) (getHeight() - Math.round(getAnimateRate() * ((float) getHeight()))));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }
}
