package com.duokan.reader.common.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.duokan.core.sys.C0357e;
import com.duokan.reader.common.bitmap.C0544a;

/* renamed from: com.duokan.reader.common.cache.b */
public abstract class C0570b extends C0357e {
    /* renamed from: b */
    static final /* synthetic */ boolean f1871b = (!C0567a.class.desiredAssertionStatus());
    /* renamed from: c */
    private final int f1872c;
    /* renamed from: d */
    private final int f1873d;
    /* renamed from: e */
    private final Config f1874e;
    /* renamed from: f */
    private final Rect f1875f = new Rect();
    /* renamed from: g */
    private final Rect f1876g = new Rect();
    /* renamed from: h */
    private Bitmap f1877h = null;

    /* renamed from: a */
    protected abstract void mo1753a(Bitmap bitmap);

    public C0570b(int i, int i2, Config config) {
        this.f1872c = i;
        this.f1873d = i2;
        this.f1874e = config;
    }

    /* renamed from: a */
    public final boolean m2562a(Canvas canvas, int i, int i2, float f, Paint paint) {
        if (!f1871b && !m1014g()) {
            throw new AssertionError();
        } else if (!m1014g() || !m1012e()) {
            return false;
        } else {
            if (Float.compare(f, 1.0f) == 0) {
                canvas.drawBitmap(this.f1877h, (float) i, (float) i2, paint);
            } else {
                canvas.save();
                canvas.translate((float) i, (float) i2);
                canvas.scale(f, f);
                canvas.translate((float) (-i), (float) (-i2));
                canvas.drawBitmap(this.f1877h, (float) i, (float) i2, paint);
                canvas.restore();
            }
            return true;
        }
    }

    /* renamed from: h */
    public final int mo770h() {
        return C0544a.m2425a(this.f1872c, this.f1873d, this.f1874e);
    }

    /* renamed from: i */
    public final int mo771i() {
        return C0544a.m2427a(this.f1877h);
    }

    /* renamed from: j */
    protected final boolean mo772j() {
        this.f1877h = C0544a.m2447c(this.f1872c, this.f1873d, this.f1874e);
        return true;
    }

    /* renamed from: a */
    protected final boolean mo769a(C0357e c0357e) {
        if (!c0357e.getClass().equals(getClass())) {
            return false;
        }
        C0570b c0570b = (C0570b) c0357e;
        if (c0570b.f1877h == null || this.f1874e != c0570b.f1877h.getConfig() || this.f1872c > c0570b.f1877h.getWidth() || this.f1873d > c0570b.f1877h.getHeight()) {
            return false;
        }
        this.f1877h = c0570b.f1877h;
        c0570b.f1877h = null;
        return true;
    }

    /* renamed from: k */
    protected final void mo773k() {
        if (this.f1877h != null && !this.f1877h.isRecycled()) {
            this.f1877h.recycle();
            this.f1877h = null;
        }
    }

    /* renamed from: l */
    protected final void mo774l() {
        mo1753a(this.f1877h);
    }
}
