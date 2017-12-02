package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.duokan.reader.ui.general.a;

class fx extends a {
    final /* synthetic */ fu a;

    public fx(fu fuVar, Context context) {
        this.a = fuVar;
        super(context);
        setWillNotDraw(false);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (e()) {
            invalidate();
        }
        canvas.save();
        canvas.translate(0.0f, (float) (getHeight() - Math.round(getAnimateRate() * ((float) getHeight()))));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }
}
