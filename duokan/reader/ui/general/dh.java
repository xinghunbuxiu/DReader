package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

class dh extends FrameLayout {
    final /* synthetic */ HangTagView a;

    public dh(HangTagView hangTagView, Context context) {
        this.a = hangTagView;
        super(context);
        setWillNotDraw(false);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a.d == null || this.a.c == null) {
            this.a.e = 0;
            this.a.f = 0;
            return;
        }
        this.a.e = this.a.c.getIntrinsicWidth();
        this.a.f = (this.a.c.getIntrinsicHeight() + (this.a.d.getMeasuredHeight() / 2)) + this.a.getMaxOverScrollHeight();
        setPadding(0, this.a.c.getIntrinsicHeight(), 0, 0);
        super.onMeasure(i, i2);
    }

    public void draw(Canvas canvas) {
        if (this.a.c != null && this.a.d != null && this.a.e > 0 && this.a.f > 0) {
            int top = ((this.a.d.getTop() + this.a.d.getBottom()) / 2) - this.a.f;
            int width = (getWidth() - this.a.e) / 2;
            this.a.c.setBounds(width, top, this.a.e + width, this.a.f + top);
            this.a.c.draw(canvas);
        }
        super.draw(canvas);
    }
}
