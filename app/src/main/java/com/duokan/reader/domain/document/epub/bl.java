package com.duokan.reader.domain.document.epub;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class bl extends Drawable {
    /* renamed from: a */
    final /* synthetic */ az f4571a;
    /* renamed from: b */
    final /* synthetic */ bk f4572b;

    bl(bk bkVar, az azVar) {
        this.f4572b = bkVar;
        this.f4571a = azVar;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        for (int i = 0; i < this.f4572b.f4569g.length; i++) {
            canvas.drawBitmap(this.f4572b.f4569g[i], (float) (bounds.left + this.f4572b.f4568f[i].left), (float) (bounds.top + this.f4572b.f4568f[i].top), null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
