package com.duokan.reader.domain.document;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import com.duokan.reader.common.bitmap.a;

public class ap {
    static final /* synthetic */ boolean a = (!al.class.desiredAssertionStatus());
    final /* synthetic */ al b;
    private final bc c;
    private final ak d;
    private final Rect e;
    private final m f;
    private final float g;
    private final ar h;
    private final Object i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private Bitmap o;

    private ap(al alVar, bc bcVar, ak akVar, Rect rect, m mVar, float f, Object obj, ar arVar) {
        this.b = alVar;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = null;
        this.c = bcVar;
        this.d = akVar;
        this.e = rect;
        this.f = mVar;
        this.g = f;
        this.i = obj;
        this.h = arVar;
    }

    public Rect a() {
        return this.e;
    }

    public m b() {
        return this.f;
    }

    public float c() {
        return this.g;
    }

    public Object d() {
        return this.i;
    }

    public boolean e() {
        return this.k;
    }

    public boolean f() {
        return this.j && this.o == null;
    }

    public int a(Rect rect, float f) {
        RectF rectF = new RectF(((float) this.e.left) / this.g, ((float) this.e.top) / this.g, ((float) this.e.right) / this.g, ((float) this.e.bottom) / this.g);
        RectF rectF2 = new RectF(((float) rect.left) / f, ((float) rect.top) / f, ((float) rect.right) / f, ((float) rect.bottom) / f);
        if (Float.compare(this.g, f) == 0 && rectF.contains(rectF2)) {
            return Integer.MAX_VALUE;
        }
        if (!rectF.intersect(rectF2)) {
            return 0;
        }
        double height = (double) (rectF.height() * rectF.width());
        return (int) Math.floor(((height * ((double) (Math.min(this.g, f) / Math.max(this.g, f)))) / ((double) (rectF2.width() * rectF2.height()))) * 2.147483647E9d);
    }

    public boolean a(Canvas canvas, float f, float f2, float f3) {
        if (!a && !this.l) {
            throw new AssertionError();
        } else if (!this.l || !this.k) {
            return false;
        } else {
            if (!a && this.o == null) {
                throw new AssertionError();
            } else if (this.o == null) {
                return false;
            } else {
                canvas.save();
                if (Float.compare(f3, 1.0f) == 0) {
                    canvas.drawBitmap(this.o, f, f2, null);
                } else {
                    canvas.translate(f, f2);
                    canvas.scale(f3, f3);
                    canvas.translate(-f, -f2);
                    canvas.drawBitmap(this.o, f, f2, null);
                }
                canvas.restore();
                return true;
            }
        }
    }

    public int g() {
        return this.e.width();
    }

    public int h() {
        return this.e.height();
    }

    public int i() {
        return this.e.width() * this.e.height();
    }

    public int j() {
        return i() * a.a(k());
    }

    public Config k() {
        return this.f.p ? Config.ARGB_8888 : Config.RGB_565;
    }
}
