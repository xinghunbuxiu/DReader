package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.AnimUtils;

class en extends View {
    /* renamed from: a */
    final /* synthetic */ em f10093a;

    en(em emVar, Context context) {
        this.f10093a = emVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        rect.set(this.f10093a.f10088c.getPaddingLeft(), this.f10093a.f10088c.getPaddingTop(), this.f10093a.f10088c.getWidth() - this.f10093a.f10088c.getPaddingRight(), this.f10093a.f10088c.getHeight() - this.f10093a.f10088c.getPaddingBottom());
        this.f10093a.f10089d.setBounds(rect);
        this.f10093a.f10089d.draw(canvas);
        AnimUtils.f1198g.clearAnimation(rect);
    }
}
