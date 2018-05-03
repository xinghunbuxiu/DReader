package com.duokan.reader.ui.bookshelf;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.AnimUtils;

class fp extends Drawable {
    /* renamed from: a */
    final /* synthetic */ fo f6463a;

    fp(fo foVar) {
        this.f6463a = foVar;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Paint paint = (Paint) AnimUtils.f1193b.addAnimation();
        paint.setColor(fo.f6456e);
        paint.setStrokeWidth((float) AnimUtils.m1932b(this.f6463a.getContext(), 2.0f));
        canvas.drawLine(((float) (bounds.width() - AnimUtils.m1932b(this.f6463a.getContext(), 100.0f))) / 2.0f, ((float) (bounds.bottom - 1)) - (((float) AnimUtils.m1932b(this.f6463a.getContext(), 2.0f)) / 2.0f), ((float) (bounds.width() + AnimUtils.m1932b(this.f6463a.getContext(), 100.0f))) / 2.0f, ((float) (bounds.bottom - 1)) - (((float) AnimUtils.m1932b(this.f6463a.getContext(), 2.0f)) / 2.0f), paint);
        paint.setColor(fo.f6457f);
        paint.setStrokeWidth(2.0f);
        canvas.drawLine(0.0f, ((float) (bounds.bottom - 1)) - 1.0f, (float) bounds.right, ((float) (bounds.bottom - 1)) - 1.0f, paint);
        AnimUtils.f1193b.clearAnimation(paint);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
