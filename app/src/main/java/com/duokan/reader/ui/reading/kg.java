package com.duokan.reader.ui.reading;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.duokan.c.e;
import com.duokan.c.f;
import com.duokan.c.j;
import com.duokan.core.ui.dv;

class kg extends Drawable {
    final /* synthetic */ kd a;

    kg(kd kdVar) {
        this.a = kdVar;
    }

    public void draw(Canvas canvas) {
        Paint paint = (Paint) dv.b.a();
        Rect rect = (Rect) dv.g.a();
        Rect rect2 = (Rect) dv.g.a();
        rect.set(this.a.d.getLeft() + this.a.d.getPaddingLeft(), this.a.d.getTop(), this.a.d.getRight() - this.a.d.getPaddingRight(), this.a.d.getBottom());
        rect2.set(rect);
        rect2.offset(0, -dv.b(this.a.getContext(), 10.0f));
        dv.a(canvas, this.a.getResources().getDrawable(f.guide__shared__finger_01), rect2, 85);
        rect2.set(rect);
        rect2.inset(-dv.b(this.a.getContext(), 30.0f), 0);
        paint.setColor(-1);
        paint.setSubpixelText(true);
        paint.setTextSize((float) this.a.getResources().getDimensionPixelSize(e.general_font__shared__d));
        dv.a(canvas, this.a.getString(j.reading__hang_ad_view__help), rect2, 81, paint);
        dv.g.a(rect2);
        dv.g.a(rect);
        dv.b.a(paint);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
