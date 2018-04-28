package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

class dh extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ HangTagView f7096a;

    public dh(HangTagView hangTagView, Context context) {
        this.f7096a = hangTagView;
        super(context);
        setWillNotDraw(false);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f7096a.f6862d == null || this.f7096a.f6861c == null) {
            this.f7096a.f6863e = 0;
            this.f7096a.f6864f = 0;
            return;
        }
        this.f7096a.f6863e = this.f7096a.f6861c.getIntrinsicWidth();
        this.f7096a.f6864f = (this.f7096a.f6861c.getIntrinsicHeight() + (this.f7096a.f6862d.getMeasuredHeight() / 2)) + this.f7096a.getMaxOverScrollHeight();
        setPadding(0, this.f7096a.f6861c.getIntrinsicHeight(), 0, 0);
        super.onMeasure(i, i2);
    }

    public void draw(Canvas canvas) {
        if (this.f7096a.f6861c != null && this.f7096a.f6862d != null && this.f7096a.f6863e > 0 && this.f7096a.f6864f > 0) {
            int top = ((this.f7096a.f6862d.getTop() + this.f7096a.f6862d.getBottom()) / 2) - this.f7096a.f6864f;
            int width = (getWidth() - this.f7096a.f6863e) / 2;
            this.f7096a.f6861c.setBounds(width, top, this.f7096a.f6863e + width, this.f7096a.f6864f + top);
            this.f7096a.f6861c.draw(canvas);
        }
        super.draw(canvas);
    }
}
