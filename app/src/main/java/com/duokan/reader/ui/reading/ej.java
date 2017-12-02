package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.dv;

class ej extends View {
    final /* synthetic */ ei a;

    ej(ei eiVar, Context context) {
        this.a = eiVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = (Rect) dv.g.a();
        rect.set(this.a.c.getPaddingLeft(), this.a.c.getPaddingTop(), this.a.c.getWidth() - this.a.c.getPaddingRight(), this.a.c.getHeight() - this.a.c.getPaddingBottom());
        this.a.d.setBounds(rect);
        this.a.d.draw(canvas);
        dv.g.a(rect);
    }
}
