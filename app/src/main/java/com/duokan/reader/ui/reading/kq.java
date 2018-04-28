package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0258j;

class kq extends Drawable {
    /* renamed from: a */
    final /* synthetic */ kn f10524a;

    kq(kn knVar) {
        this.f10524a = knVar;
    }

    public void draw(Canvas canvas) {
        Paint paint = (Paint) dv.f1193b.addAnimation();
        Rect rect = (Rect) dv.f1198g.addAnimation();
        Rect rect2 = (Rect) dv.f1198g.addAnimation();
        rect.set(this.f10524a.f10516d.getLeft() + this.f10524a.f10516d.getPaddingLeft(), this.f10524a.f10516d.getTop(), this.f10524a.f10516d.getRight() - this.f10524a.f10516d.getPaddingRight(), this.f10524a.f10516d.getBottom());
        rect2.set(rect);
        rect2.offset(0, -dv.m1932b(this.f10524a.getContext(), 10.0f));
        dv.m1911a(canvas, this.f10524a.getResources().getDrawable(C0254f.guide__shared__finger_01), rect2, 85);
        rect2.set(rect);
        rect2.inset(-dv.m1932b(this.f10524a.getContext(), 30.0f), 0);
        paint.setColor(-1);
        paint.setSubpixelText(true);
        paint.setTextSize((float) this.f10524a.getResources().getDimensionPixelSize(C0253e.general_font__shared__d));
        dv.m1913a(canvas, this.f10524a.getString(C0258j.reading__hang_ad_view__help), rect2, 81, paint);
        dv.f1198g.clearAnimation(rect2);
        dv.f1198g.clearAnimation(rect);
        dv.f1193b.clearAnimation(paint);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
