package com.duokan.reader.domain.document.epub;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class bl extends Drawable {
    final /* synthetic */ az a;
    final /* synthetic */ bk b;

    bl(bk bkVar, az azVar) {
        this.b = bkVar;
        this.a = azVar;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        for (int i = 0; i < this.b.g.length; i++) {
            canvas.drawBitmap(this.b.g[i], (float) (bounds.left + this.b.f[i].left), (float) (bounds.top + this.b.f[i].top), null);
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
