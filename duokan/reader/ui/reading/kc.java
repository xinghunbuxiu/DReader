package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.FrameLayout;

class kc extends FrameLayout {
    jv a;
    final /* synthetic */ jz b;

    private kc(jz jzVar, Context context) {
        this.b = jzVar;
        super(context);
        this.a = null;
        setWillNotDraw(false);
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        jv b = GifFrameLoader.a().b(this.b.f, this.b.c, this.b.e.width(), this.b.e.height());
        if (b != null) {
            b.d = FrameStatus.SHOW;
            canvas.drawBitmap(b.b, null, new Rect(0, 0, getWidth(), getHeight()), null);
            if (!(this.a == b || this.a == null)) {
                int i2 = b.a + 1;
                if (i2 < this.b.f.a()) {
                    i = i2;
                }
                this.a.a = i;
                this.a.d = FrameStatus.DIRTY;
            }
            this.a = b;
        } else if (this.a != null && this.a.d == FrameStatus.SHOW) {
            canvas.drawBitmap(this.a.b, null, new Rect(0, 0, getWidth(), getHeight()), null);
        }
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int width = this.b.e.width();
        int height = this.b.e.height();
        this.b.b = Math.min(((float) size) / ((float) width), ((float) size2) / ((float) height));
        setMeasuredDimension(width, height);
    }
}
