package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.dv;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.common.bitmap.a;

public class e extends eu {
    private final Paint a;
    private int b;
    private Bitmap c;

    public e() {
        this.a = new Paint();
        this.b = 0;
        this.c = null;
        this.a.setAntiAlias(true);
        this.a.setFilterBitmap(true);
        this.b = 60;
    }

    public e(View view) {
        this();
        b(view);
    }

    protected void a(Canvas canvas, View view) {
        if (this.b <= 0 || this.c == null) {
            super.a(canvas, view);
            return;
        }
        Rect rect = (Rect) dv.g.a();
        rect.set(0, 0, this.c.getWidth(), this.c.getHeight());
        canvas.drawBitmap(this.c, rect, getBounds(), this.a);
        dv.g.a(rect);
    }

    protected void a(View view) {
        int intrinsicWidth = getIntrinsicWidth() / 5;
        int intrinsicHeight = getIntrinsicHeight() / 5;
        if (this.b > 0 && intrinsicWidth > 0 && intrinsicHeight > 0) {
            if (this.c == null) {
                this.c = a.b(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            } else if (!(this.c.getWidth() == intrinsicWidth && this.c.getHeight() == intrinsicHeight)) {
                this.c.recycle();
                this.c = a.b(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(this.c);
            float width = ((float) intrinsicWidth) / ((float) view.getWidth());
            float height = ((float) intrinsicHeight) / ((float) view.getHeight());
            canvas.save();
            canvas.scale(width, height);
            view.draw(canvas);
            canvas.restore();
            DkUtils.blurBitmap(this.c, this.b);
        } else if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
    }

    protected void a() {
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
    }
}
