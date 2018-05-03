package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.AnimUtils;

class pj extends View {
    /* renamed from: a */
    final /* synthetic */ pg f10792a;
    /* renamed from: b */
    final /* synthetic */ pi f10793b;

    pj(pi piVar, Context context, pg pgVar) {
        this.f10793b = piVar;
        this.f10792a = pgVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        rect.set(0, 0, this.f10793b.f10786e.width(), this.f10793b.f10786e.height());
        canvas.drawBitmap(this.f10793b.f10785d, this.f10793b.f10786e, rect, null);
        AnimUtils.f1198g.clearAnimation(rect);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f10793b.f10786e.width(), this.f10793b.f10786e.height());
    }
}
