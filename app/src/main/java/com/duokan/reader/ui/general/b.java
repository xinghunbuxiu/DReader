package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import com.duokan.core.sys.AsyncCache;
import com.duokan.core.sys.e;
import com.duokan.core.sys.f;
import com.duokan.reader.common.bitmap.a;

public abstract class b extends Drawable {
    private final Config a;
    private final Rect b = new Rect();
    private final AsyncCache c;
    private float d = 1.0f;
    private float e = 0.25f;
    private float f = 0.6f;
    private int g = 0;
    private int h = 0;
    private c i = null;
    private c j = null;

    protected abstract void a(Bitmap bitmap, RectF rectF, float f);

    public b(Config config, AsyncCache asyncCache) {
        this.a = config;
        this.c = asyncCache;
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void b(int i) {
        this.h = i;
    }

    public final void a(Rect rect) {
        this.b.set(rect);
    }

    public final void a() {
        if (this.i != null) {
            this.c.b(this.i);
            this.i = null;
        }
        if (this.j != null) {
            this.c.b(this.j);
            this.j = null;
        }
    }

    public void draw(Canvas canvas) {
        int i = 0;
        canvas.save();
        canvas.translate((float) getBounds().left, (float) getBounds().top);
        f dVar = new d(this, a(this.b, a.a(canvas), a.b(canvas)), this.d);
        if (this.i != null && (this.i.c() || this.i.d.a(dVar) == 0)) {
            this.c.b(this.i);
            this.i = null;
        }
        if (this.j != null && (this.j.c() || this.j.d.a(dVar) == 0)) {
            this.c.b(this.j);
            this.j = null;
        }
        if (this.i == null) {
            this.i = (c) this.c.a(dVar, 1);
        } else {
            int a = this.i.d.a(dVar);
            if (a < Integer.MAX_VALUE) {
                e eVar = (c) this.c.a(dVar, a + 1);
                if (eVar != null) {
                    if (eVar.e()) {
                        this.c.b(this.i);
                        this.i = eVar;
                    } else {
                        this.c.a(eVar);
                    }
                }
            }
        }
        if (this.i != null) {
            int round = Math.round(this.i.d.b().left * this.d);
            int round2 = Math.round(this.i.d.b().top * this.d);
            float c = this.d / this.i.d.c();
            if (this.i.d.a(dVar) == Integer.MAX_VALUE) {
                i = 1;
            }
            if (!this.i.a(canvas, round, round2, c, null)) {
                a(canvas);
            } else if (i == 0) {
                invalidateSelf();
            }
        } else {
            a(canvas);
        }
        if (this.j == this.i) {
            this.j = null;
        }
        if (this.j != null && this.j.e()) {
            this.j = null;
        }
        if (this.j == null && r6 == 0) {
            this.j = (c) this.c.a(dVar, new c(this, dVar));
            this.c.a(this.j);
        }
        canvas.restore();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    private void a(Canvas canvas) {
        invalidateSelf();
    }

    private Rect a(Rect rect, int i, int i2) {
        if (rect.isEmpty()) {
            return new Rect();
        }
        Rect rect2 = new Rect(0, 0, b(), c());
        Rect rect3 = new Rect(rect);
        int i3 = (int) (((float) this.g) * (this.e + 1.0f));
        int i4 = (int) (((float) this.h) * (this.f + 1.0f));
        rect3.inset((-Math.max(0, i3 - rect3.width())) / 2, (-Math.max(0, i4 - rect3.height())) / 2);
        rect3.intersect(rect2);
        i3 = Math.min(i3 * i4, rect2.width() * rect2.height());
        while (rect3.width() * rect3.height() < i3) {
            i4 = rect3.width();
            rect3.inset((-(Math.min(i3 / rect3.height(), i) - rect3.width())) / 2, 0);
            rect3.intersect(rect2);
            int height = rect3.height();
            rect3.inset(0, (-(Math.min(i3 / rect3.width(), i2) - rect3.height())) / 2);
            rect3.intersect(rect2);
            if (i4 == rect3.width() && height == rect3.height()) {
                break;
            }
        }
        if (rect3.width() % 2 == 0) {
            return rect3;
        }
        rect3.right++;
        return rect3;
    }

    protected int b() {
        return (int) (((float) getIntrinsicWidth()) * this.d);
    }

    protected int c() {
        return (int) (((float) getIntrinsicHeight()) * this.d);
    }
}
