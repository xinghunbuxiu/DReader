package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.duokan.core.sys.AsyncCache;
import com.duokan.core.sys.C0357e;
import com.duokan.core.sys.C0358f;
import com.duokan.reader.common.bitmap.C0544a;

/* renamed from: com.duokan.reader.ui.general.b */
public abstract class C1326b extends Drawable {
    /* renamed from: a */
    private final Config f6954a;
    /* renamed from: b */
    private final Rect f6955b = new Rect();
    /* renamed from: c */
    private final AsyncCache f6956c;
    /* renamed from: d */
    private float f6957d = 1.0f;
    /* renamed from: e */
    private float f6958e = 0.25f;
    /* renamed from: f */
    private float f6959f = 0.6f;
    /* renamed from: g */
    private int f6960g = 0;
    /* renamed from: h */
    private int f6961h = 0;
    /* renamed from: i */
    private C1327c f6962i = null;
    /* renamed from: j */
    private C1327c f6963j = null;

    /* renamed from: a */
    protected abstract void mo2512a(Bitmap bitmap, RectF rectF, float f);

    public C1326b(Config config, AsyncCache asyncCache) {
        this.f6954a = config;
        this.f6956c = asyncCache;
    }

    /* renamed from: a */
    public final void m10247a(int i) {
        this.f6960g = i;
    }

    /* renamed from: b */
    public final void m10251b(int i) {
        this.f6961h = i;
    }

    /* renamed from: a */
    public final void m10249a(Rect rect) {
        this.f6955b.set(rect);
    }

    /* renamed from: a */
    public final void m10246a() {
        if (this.f6962i != null) {
            this.f6956c.m818b(this.f6962i);
            this.f6962i = null;
        }
        if (this.f6963j != null) {
            this.f6956c.m818b(this.f6963j);
            this.f6963j = null;
        }
    }

    public void draw(Canvas canvas) {
        int i = 0;
        canvas.save();
        canvas.translate((float) getBounds().left, (float) getBounds().top);
        C0358f c1328d = new C1328d(this, m10244a(this.f6955b, C0544a.m2428a(canvas), C0544a.m2442b(canvas)), this.f6957d);
        if (this.f6962i != null && (this.f6962i.m1010c() || this.f6962i.f7019d.mo775a(c1328d) == 0)) {
            this.f6956c.m818b(this.f6962i);
            this.f6962i = null;
        }
        if (this.f6963j != null && (this.f6963j.m1010c() || this.f6963j.f7019d.mo775a(c1328d) == 0)) {
            this.f6956c.m818b(this.f6963j);
            this.f6963j = null;
        }
        if (this.f6962i == null) {
            this.f6962i = (C1327c) this.f6956c.m812a(c1328d, 1);
        } else {
            int a = this.f6962i.f7019d.mo775a(c1328d);
            if (a < Integer.MAX_VALUE) {
                C0357e c0357e = (C1327c) this.f6956c.m812a(c1328d, a + 1);
                if (c0357e != null) {
                    if (c0357e.m1012e()) {
                        this.f6956c.m818b(this.f6962i);
                        this.f6962i = c0357e;
                    } else {
                        this.f6956c.m815a(c0357e);
                    }
                }
            }
        }
        if (this.f6962i != null) {
            int round = Math.round(this.f6962i.f7019d.m2570b().left * this.f6957d);
            int round2 = Math.round(this.f6962i.f7019d.m2570b().top * this.f6957d);
            float c = this.f6957d / this.f6962i.f7019d.m2571c();
            if (this.f6962i.f7019d.mo775a(c1328d) == Integer.MAX_VALUE) {
                i = 1;
            }
            if (!this.f6962i.m2562a(canvas, round, round2, c, null)) {
                m10245a(canvas);
            } else if (i == 0) {
                invalidateSelf();
            }
        } else {
            m10245a(canvas);
        }
        if (this.f6963j == this.f6962i) {
            this.f6963j = null;
        }
        if (this.f6963j != null && this.f6963j.m1012e()) {
            this.f6963j = null;
        }
        if (this.f6963j == null && i == 0) {
            this.f6963j = (C1327c) this.f6956c.m813a(c1328d, new C1327c(this, c1328d));
            this.f6956c.m815a(this.f6963j);
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

    /* renamed from: a */
    private void m10245a(Canvas canvas) {
        invalidateSelf();
    }

    /* renamed from: a */
    private Rect m10244a(Rect rect, int i, int i2) {
        if (rect.isEmpty()) {
            return new Rect();
        }
        Rect rect2 = new Rect(0, 0, m10250b(), m10252c());
        Rect rect3 = new Rect(rect);
        int i3 = (int) (((float) this.f6960g) * (this.f6958e + 1.0f));
        int i4 = (int) (((float) this.f6961h) * (this.f6959f + 1.0f));
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

    /* renamed from: b */
    protected int m10250b() {
        return (int) (((float) getIntrinsicWidth()) * this.f6957d);
    }

    /* renamed from: c */
    protected int m10252c() {
        return (int) (((float) getIntrinsicHeight()) * this.f6957d);
    }
}
