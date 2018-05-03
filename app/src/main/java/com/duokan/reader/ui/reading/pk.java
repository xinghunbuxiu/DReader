package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.AnimUtils;

class pk extends View {
    /* renamed from: a */
    final /* synthetic */ pg f10794a;
    /* renamed from: b */
    final /* synthetic */ pi f10795b;

    pk(pi piVar, Context context, pg pgVar) {
        this.f10795b = piVar;
        this.f10794a = pgVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        rect.set(0, 0, this.f10795b.f10787f.width(), this.f10795b.f10787f.height());
        canvas.drawBitmap(this.f10795b.f10785d, this.f10795b.f10787f, rect, null);
        AnimUtils.f1198g.clearAnimation(rect);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f10795b.f10787f.width(), this.f10795b.f10787f.height());
    }
}
