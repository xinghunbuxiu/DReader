package com.duokan.core.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

class b extends InsetDrawable {
    final /* synthetic */ a a;

    b(a aVar, Drawable drawable, int i, int i2, int i3, int i4) {
        this.a = aVar;
        super(drawable, i, i2, i3, i4);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.a.c != null) {
            Rect rect = (Rect) dv.g.a();
            this.a.a(rect);
            if (!rect.isEmpty()) {
                canvas.save();
                canvas.translate(rect.exactCenterX(), rect.exactCenterY());
                canvas.rotate((float) this.a.b());
                canvas.translate(-rect.exactCenterX(), -rect.exactCenterY());
                this.a.c.setFilterBitmap(true);
                this.a.c.setBounds(rect);
                this.a.c.draw(canvas);
                canvas.restore();
            }
            dv.g.a(rect);
        }
    }
}
