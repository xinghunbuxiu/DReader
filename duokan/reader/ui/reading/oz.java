package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.UTools;

class oz extends View {
    final /* synthetic */ ow a;
    final /* synthetic */ oy b;

    oz(oy oyVar, Context context, ow owVar) {
        this.b = oyVar;
        this.a = owVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = (Rect) UTools.g.getRect();
        rect.set(0, 0, this.b.e.width(), this.b.e.height());
        canvas.drawBitmap(this.b.d, this.b.e, rect, null);
        UTools.g.getRect(rect);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.b.e.width(), this.b.e.height());
    }
}
