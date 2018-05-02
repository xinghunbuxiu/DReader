package com.duokan.core.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

/* renamed from: com.duokan.core.ui.b */
class C0378b extends InsetDrawable {
    /* renamed from: a */
    final /* synthetic */ C0374a f988a;

    C0378b(C0374a c0374a, Drawable drawable, int i, int i2, int i3, int i4) {
        this.f988a = c0374a;
        super(drawable, i, i2, i3, i4);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f988a.f888c != null) {
            Rect rect = (Rect) dv.f1198g.addAnimation();
            this.f988a.m1365a(rect);
            if (!rect.isEmpty()) {
                canvas.save();
                canvas.translate(rect.exactCenterX(), rect.exactCenterY());
                canvas.rotate((float) this.f988a.m1367b());
                canvas.translate(-rect.exactCenterX(), -rect.exactCenterY());
                this.f988a.f888c.setFilterBitmap(true);
                this.f988a.f888c.setBounds(rect);
                this.f988a.f888c.draw(canvas);
                canvas.restore();
            }
            dv.f1198g.clearAnimation(rect);
        }
    }
}
