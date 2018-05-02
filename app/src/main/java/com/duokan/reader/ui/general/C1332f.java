package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreAbsBook;

/* renamed from: com.duokan.reader.ui.general.f */
public class C1332f extends C1283z {
    /* renamed from: a */
    private static final Rect f7184a = new Rect();
    /* renamed from: h */
    private static final Rect f7185h = new Rect();
    /* renamed from: i */
    private final Rect f7186i = new Rect();
    /* renamed from: j */
    private final gl f7187j;
    /* renamed from: k */
    private final Drawable f7188k;
    /* renamed from: l */
    private final bd f7189l;
    /* renamed from: m */
    private Drawable f7190m = null;
    /* renamed from: n */
    private Drawable f7191n = null;
    /* renamed from: o */
    private Drawable f7192o = null;
    /* renamed from: p */
    private Drawable f7193p = null;
    /* renamed from: q */
    private int f7194q = 255;
    /* renamed from: r */
    private String f7195r = null;
    /* renamed from: s */
    private final Transformation f7196s = new Transformation();
    /* renamed from: t */
    private final Rect f7197t = new Rect();
    /* renamed from: u */
    private AlphaAnimation f7198u = null;
    /* renamed from: v */
    private float f7199v = 0.0f;
    /* renamed from: w */
    private final Callback f7200w = new C1333g(this);

    public C1332f(Context context, int i) {
        super(context, false);
        if (i != 0) {
            this.f7188k = cn.m10370a(context, i);
        } else {
            this.f7188k = null;
        }
        if (this.f7188k != null) {
            this.f7188k.getPadding(this.f7186i);
        } else {
            this.f7186i.setEmpty();
        }
        this.f7187j = new gl(this.c);
        this.f7187j.m10717a(PicStretch.SCALE_FILL);
        this.f7189l = new bd();
        this.f7189l.m10274b(m10611b().getDimensionPixelSize(C0242d.general_font__shared__e));
        this.f7189l.m10267a(-1);
        this.f7189l.m10280d(2);
        this.f7189l.m10276c(49);
        this.f7187j.setCallback(this.f7200w);
    }

    /* renamed from: a */
    public Context m10606a() {
        return this.c;
    }

    /* renamed from: b */
    public Resources m10611b() {
        return this.c.getResources();
    }

    /* renamed from: a */
    public void m10608a(C0800c c0800c, boolean z) {
        this.f7198u = null;
        this.f7199v = 0.0f;
        m9129a(false);
        this.f7195r = c0800c.ay();
        this.f7189l.m10270a(this.f7195r);
        this.f7189l.setAlpha(this.f7194q);
        this.f7190m = this.c.getResources().getDrawable(C1340l.m10931a(m10606a()).m10938d(c0800c));
        this.f7190m.setAlpha(this.f7194q);
        if (!z) {
            m10603a(c0800c);
            m10604b(c0800c);
            m10605c(c0800c);
        }
        C1340l.m10931a(this.c).m10935a().m10955a(c0800c).m10956a(new C1335h(this)).m10957a(new C1381x(this.c)).m10960a(this.f7187j);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m10610a(DkStoreAbsBook dkStoreAbsBook) {
        this.f7198u = null;
        this.f7199v = 0.0f;
        m9129a(false);
        this.f7195r = dkStoreAbsBook.getTitle();
        this.f7189l.m10270a(this.f7195r);
        this.f7189l.setAlpha(this.f7194q);
        this.f7190m = this.c.getResources().getDrawable(C0243e.general__shared__epub);
        this.f7190m.setAlpha(this.f7194q);
        C1340l.m10931a(this.c).m10935a().m10961b(dkStoreAbsBook.getCoverUri()).m10956a(new C1336i(this)).m10957a(new C1381x(this.c)).m10960a(this.f7187j);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m10609a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        this.f7198u = null;
        this.f7199v = 0.0f;
        m9129a(false);
        this.f7195r = dkCloudNoteBookInfo.getTitle();
        this.f7189l.m10270a(this.f7195r);
        this.f7189l.setAlpha(this.f7194q);
        this.f7190m = this.c.getResources().getDrawable(C1340l.m10931a(m10606a()).m10933a(dkCloudNoteBookInfo.getBookFormat()));
        this.f7190m.setAlpha(this.f7194q);
        C1340l.m10931a(this.c).m10935a().m10961b(dkCloudNoteBookInfo.getBookCoverUrl()).m10956a(new C1338j(this)).m10957a(new C1381x(this.c)).m10960a(this.f7187j);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m10607a(Rect rect, long j) {
        this.f7197t.set(rect);
        this.f7198u = new AlphaAnimation(0.1f, 1.0f);
        this.f7198u.setDuration(j);
        this.f7198u.setFillEnabled(true);
        this.f7198u.setFillAfter(true);
        this.f7198u.setAnimationListener(new C1339k(this));
        invalidateSelf();
    }

    /* renamed from: c */
    public boolean m10612c() {
        return this.f7188k != null;
    }

    /* renamed from: d */
    public boolean m10613d() {
        return this.f7198u != null;
    }

    /* renamed from: e */
    public boolean m10614e() {
        return this.f7187j.m10724d();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (!(this.f7198u == null || this.f7198u.hasEnded())) {
            if (!this.f7198u.hasStarted()) {
                this.f7198u.setStartTime(currentAnimationTimeMillis);
            }
            this.f7198u.getTransformation(currentAnimationTimeMillis, this.f7196s);
            this.f7199v = this.f7196s.getAlpha();
            m9129a(true);
            invalidateSelf();
        }
        Rect bounds = getBounds();
        Rect rect = (Rect) dv.f1198g.addAnimation();
        rect.set(bounds);
        if (this.f7199v != 0.0f) {
            float f = (float) ((((bounds.left + this.f7186i.left) + bounds.right) - this.f7186i.right) / 2);
            float f2 = (float) (((bounds.bottom + (bounds.top + this.f7186i.top)) - this.f7186i.bottom) / 2);
            float centerX = (((((((float) this.f7197t.centerX()) - f) * 10.0f) * this.f7199v) + (10.0f * f)) - ((float) this.f7197t.centerX())) / 9.0f;
            f = (((((float) this.f7197t.centerY()) * f) - (f2 * ((float) this.f7197t.centerX()))) + ((f2 - ((float) this.f7197t.centerY())) * centerX)) / (f - ((float) this.f7197t.centerX()));
            f2 = (((((10.0f * 0.42105263f) - 10.0f) * this.f7199v) + 10.0f) - 0.42105263f) / 9.0f;
            canvas.scale(f2, f2, centerX, f);
            RectF rectF = (RectF) dv.f1199h.addAnimation();
            rectF.set((centerX - ((float) (this.f7197t.width() / 2))) - ((float) this.f7186i.left), (f - ((float) (this.f7197t.height() / 2))) - ((float) this.f7186i.top), (centerX + ((float) (this.f7197t.width() / 2))) + ((float) this.f7186i.right), (f + ((float) (this.f7197t.height() / 2))) + ((float) this.f7186i.bottom));
            rectF.round(rect);
            dv.f1199h.clearAnimation(rectF);
        }
        f7184a.set(rect.left + this.f7186i.left, rect.top + this.f7186i.top, rect.right - this.f7186i.right, rect.bottom - this.f7186i.bottom);
        this.f7187j.setBounds(f7184a);
        this.f7187j.draw(canvas);
        if (this.f7190m.isVisible()) {
            this.f7190m.setBounds(f7184a);
            this.f7190m.draw(canvas);
            f7185h.set(f7184a);
            bounds = f7185h;
            bounds.left = (int) (((double) bounds.left) + (((double) f7184a.width()) * 0.15d));
            bounds = f7185h;
            bounds.top = (int) (((double) bounds.top) + (((double) f7184a.height()) * 0.25d));
            bounds = f7185h;
            bounds.right = (int) (((double) bounds.right) - (((double) f7184a.width()) * 0.1d));
            this.f7189l.setBounds(f7185h);
            this.f7189l.draw(canvas);
        }
        if (this.f7188k != null) {
            this.f7188k.setBounds(rect);
            this.f7188k.draw(canvas);
        }
        if (this.f7192o != null) {
            canvas.save();
            canvas.translate((float) dv.m1932b(m10606a(), 2.0f), (float) (-Math.round(1.5f * ((float) this.f7192o.getIntrinsicHeight()))));
            dv.m1911a(canvas, this.f7192o, f7184a, 85);
            canvas.restore();
        }
        if (this.f7193p != null) {
            canvas.save();
            canvas.translate(0.0f, (float) ((-this.f7193p.getIntrinsicHeight()) / 2));
            dv.m1911a(canvas, this.f7193p, f7184a, 83);
            canvas.restore();
        }
        if (this.f7191n != null) {
            dv.m1911a(canvas, this.f7191n, f7184a, 53);
        }
        dv.f1198g.clearAnimation(rect);
        canvas.restore();
    }

    public void setAlpha(int i) {
        if (this.f7194q != i) {
            this.f7194q = i;
            this.f7187j.setAlpha(this.f7194q);
            if (this.f7191n != null) {
                this.f7191n.setAlpha(this.f7194q);
            }
            if (this.f7192o != null) {
                this.f7192o.setAlpha(this.f7194q);
            }
            if (this.f7193p != null) {
                this.f7193p.setAlpha(this.f7194q);
            }
            if (this.f7190m != null) {
                this.f7190m.setAlpha(this.f7194q);
            }
            if (this.f7189l != null) {
                this.f7189l.setAlpha(this.f7194q);
            }
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public boolean getPadding(Rect rect) {
        rect.set(this.f7186i);
        return !this.f7186i.isEmpty();
    }

    /* renamed from: a */
    private void m10603a(C0800c c0800c) {
        this.f7191n = C1340l.m10931a(this.c).m10937c(c0800c);
        if (this.f7191n != null) {
            this.f7191n.setAlpha(this.f7194q);
        }
    }

    /* renamed from: b */
    private void m10604b(C0800c c0800c) {
        this.f7192o = C1340l.m10931a(this.c).m10934a(c0800c);
        if (this.f7192o != null) {
            this.f7192o.setAlpha(this.f7194q);
        }
    }

    /* renamed from: c */
    private void m10605c(C0800c c0800c) {
        this.f7193p = C1340l.m10931a(this.c).m10936b(c0800c);
        if (this.f7193p != null) {
            this.f7193p.setAlpha(this.f7194q);
        }
    }
}
