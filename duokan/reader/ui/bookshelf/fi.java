package com.duokan.reader.ui.bookshelf;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.duokan.core.ui.UTools;

class fi extends Drawable {
    final /* synthetic */ fh a;

    fi(fh fhVar) {
        this.a = fhVar;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Paint paint = (Paint) UTools.b.getRect();
        paint.setColor(fh.e);
        paint.setStrokeWidth((float) UTools.getMinimumHeight(this.a.getContext(), 2.0f));
        canvas.drawLine(((float) (bounds.width() - UTools.getMinimumHeight(this.a.getContext(), 100.0f))) / 2.0f, ((float) (bounds.bottom - 1)) - (((float) UTools.getMinimumHeight(this.a.getContext(), 2.0f)) / 2.0f), ((float) (bounds.width() + UTools.getMinimumHeight(this.a.getContext(), 100.0f))) / 2.0f, ((float) (bounds.bottom - 1)) - (((float) UTools.getMinimumHeight(this.a.getContext(), 2.0f)) / 2.0f), paint);
        paint.setColor(fh.f);
        paint.setStrokeWidth(2.0f);
        canvas.drawLine(0.0f, ((float) (bounds.bottom - 1)) - 1.0f, (float) bounds.right, ((float) (bounds.bottom - 1)) - 1.0f, paint);
        UTools.b.getRect(paint);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
