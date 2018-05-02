package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.UTools;

class pa extends View {
    final /* synthetic */ ow a;
    final /* synthetic */ oy b;

    pa(oy oyVar, Context context, ow owVar) {
        this.b = oyVar;
        this.a = owVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = (Rect) UTools.g.getRect();
        rect.set(0, 0, this.b.f.width(), this.b.f.height());
        canvas.drawBitmap(this.b.d, this.b.f, rect, null);
        UTools.g.getRect(rect);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.b.f.width(), this.b.f.height());
    }
}
