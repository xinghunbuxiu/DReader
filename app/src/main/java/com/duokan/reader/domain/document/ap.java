package com.duokan.reader.domain.document;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import com.duokan.reader.common.bitmap.C0544a;

public class ap {
    /* renamed from: a */
    static final /* synthetic */ boolean f4417a = (!al.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ al f4418b;
    /* renamed from: c */
    private final bc f4419c;
    /* renamed from: d */
    private final ak f4420d;
    /* renamed from: e */
    private final Rect f4421e;
    /* renamed from: f */
    private final C0923m f4422f;
    /* renamed from: g */
    private final float f4423g;
    /* renamed from: h */
    private final ar f4424h;
    /* renamed from: i */
    private final Object f4425i;
    /* renamed from: j */
    private boolean f4426j;
    /* renamed from: k */
    private boolean f4427k;
    /* renamed from: l */
    private boolean f4428l;
    /* renamed from: m */
    private boolean f4429m;
    /* renamed from: n */
    private boolean f4430n;
    /* renamed from: o */
    private Bitmap f4431o;

    private ap(al alVar, bc bcVar, ak akVar, Rect rect, C0923m c0923m, float f, Object obj, ar arVar) {
        this.f4418b = alVar;
        this.f4426j = false;
        this.f4427k = false;
        this.f4428l = false;
        this.f4429m = false;
        this.f4430n = false;
        this.f4431o = null;
        this.f4419c = bcVar;
        this.f4420d = akVar;
        this.f4421e = rect;
        this.f4422f = c0923m;
        this.f4423g = f;
        this.f4425i = obj;
        this.f4424h = arVar;
    }

    /* renamed from: a */
    public Rect m6382a() {
        return this.f4421e;
    }

    /* renamed from: b */
    public C0923m m6384b() {
        return this.f4422f;
    }

    /* renamed from: c */
    public float m6385c() {
        return this.f4423g;
    }

    /* renamed from: d */
    public Object m6386d() {
        return this.f4425i;
    }

    /* renamed from: e */
    public boolean m6387e() {
        return this.f4427k;
    }

    /* renamed from: f */
    public boolean m6388f() {
        return this.f4426j && this.f4431o == null;
    }

    /* renamed from: a */
    public int m6381a(Rect rect, float f) {
        RectF rectF = new RectF(((float) this.f4421e.left) / this.f4423g, ((float) this.f4421e.top) / this.f4423g, ((float) this.f4421e.right) / this.f4423g, ((float) this.f4421e.bottom) / this.f4423g);
        RectF rectF2 = new RectF(((float) rect.left) / f, ((float) rect.top) / f, ((float) rect.right) / f, ((float) rect.bottom) / f);
        if (Float.compare(this.f4423g, f) == 0 && rectF.contains(rectF2)) {
            return Integer.MAX_VALUE;
        }
        if (!rectF.intersect(rectF2)) {
            return 0;
        }
        double height = (double) (rectF.height() * rectF.width());
        return (int) Math.floor(((height * ((double) (Math.min(this.f4423g, f) / Math.max(this.f4423g, f)))) / ((double) (rectF2.width() * rectF2.height()))) * 2.147483647E9d);
    }

    /* renamed from: a */
    public boolean m6383a(Canvas canvas, float f, float f2, float f3) {
        if (!f4417a && !this.f4428l) {
            throw new AssertionError();
        } else if (!this.f4428l || !this.f4427k) {
            return false;
        } else {
            if (!f4417a && this.f4431o == null) {
                throw new AssertionError();
            } else if (this.f4431o == null) {
                return false;
            } else {
                canvas.save();
                if (Float.compare(f3, 1.0f) == 0) {
                    canvas.drawBitmap(this.f4431o, f, f2, null);
                } else {
                    canvas.translate(f, f2);
                    canvas.scale(f3, f3);
                    canvas.translate(-f, -f2);
                    canvas.drawBitmap(this.f4431o, f, f2, null);
                }
                canvas.restore();
                return true;
            }
        }
    }

    /* renamed from: g */
    public int m6389g() {
        return this.f4421e.width();
    }

    /* renamed from: h */
    public int m6390h() {
        return this.f4421e.height();
    }

    /* renamed from: i */
    public int m6391i() {
        return this.f4421e.width() * this.f4421e.height();
    }

    /* renamed from: j */
    public int m6392j() {
        return m6391i() * C0544a.m2426a(m6393k());
    }

    /* renamed from: k */
    public Config m6393k() {
        return this.f4422f.f4368p ? Config.ARGB_8888 : Config.RGB_565;
    }
}
