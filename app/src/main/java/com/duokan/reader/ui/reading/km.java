package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

class km extends FrameLayout {
    /* renamed from: a */
    kf f10511a;
    /* renamed from: b */
    final /* synthetic */ kj f10512b;

    private km(kj kjVar, Context context) {
        this.f10512b = kjVar;
        super(context);
        this.f10511a = null;
        setWillNotDraw(false);
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        kf b = GifFrameLoader.m12418a().m12424b(this.f10512b.f10503f, this.f10512b.f10500c, this.f10512b.f10502e.width(), this.f10512b.f10502e.height());
        if (b != null) {
            b.f10495d = FrameStatus.SHOW;
            canvas.drawBitmap(b.f10493b, null, new Rect(0, 0, getWidth(), getHeight()), null);
            if (!(this.f10511a == b || this.f10511a == null)) {
                int i2 = b.f10492a + 1;
                if (i2 < this.f10512b.f10503f.mo1398a()) {
                    i = i2;
                }
                this.f10511a.f10492a = i;
                this.f10511a.f10495d = FrameStatus.DIRTY;
            }
            this.f10511a = b;
        } else if (this.f10511a != null && this.f10511a.f10495d == FrameStatus.SHOW) {
            canvas.drawBitmap(this.f10511a.f10493b, null, new Rect(0, 0, getWidth(), getHeight()), null);
        }
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int width = this.f10512b.f10502e.width();
        int height = this.f10512b.f10502e.height();
        this.f10512b.f10499b = Math.min(((float) size) / ((float) width), ((float) size2) / ((float) height));
        setMeasuredDimension(width, height);
    }
}
