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

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreAbsBook;

public class f extends z {
    private static final Rect a = new Rect();
    private static final Rect h = new Rect();
    private final Rect i = new Rect();
    private final gw j;
    private final Drawable k;
    private final bd l;
    private Drawable m = null;
    private Drawable n = null;
    private Drawable o = null;
    private int p = 255;
    private String q = null;
    private final Transformation r = new Transformation();
    private final Rect s = new Rect();
    private AlphaAnimation t = null;
    private float u = 0.0f;
    private final Callback v = new g(this);

    public f(Context context, int i) {
        super(context, false);
        if (i != 0) {
            this.k = cn.a(context, i);
        } else {
            this.k = null;
        }
        if (this.k != null) {
            this.k.getPadding(this.i);
        } else {
            this.i.setEmpty();
        }
        this.j = new gw(this.c);
        this.j.a(PicStretch.SCALE_FILL);
        this.l = new bd();
        this.l.b(b().getDimensionPixelSize(d.general_font__shared__e));
        this.l.a(-1);
        this.l.d(2);
        this.l.c(49);
        this.j.setCallback(this.v);
    }

    public Context a() {
        return this.c;
    }

    public Resources b() {
        return this.c.getResources();
    }

    public void a(c cVar, boolean z) {
        this.t = null;
        this.u = 0.0f;
        a(false);
        this.q = cVar.aw();
        this.l.a(this.q);
        this.l.setAlpha(this.p);
        this.m = this.c.getResources().getDrawable(l.a(a()).c(cVar));
        this.m.setAlpha(this.p);
        if (!z) {
            a(cVar);
            b(cVar);
        }
        l.a(this.c).a().a(cVar).a(new h(this)).a(new x(this.c)).a(this.j);
        invalidateSelf();
    }

    public void a(DkStoreAbsBook dkStoreAbsBook) {
        this.t = null;
        this.u = 0.0f;
        a(false);
        this.q = dkStoreAbsBook.getTitle();
        this.l.a(this.q);
        this.l.setAlpha(this.p);
        this.m = this.c.getResources().getDrawable(e.general__shared__epub);
        this.m.setAlpha(this.p);
        l.a(this.c).a().b(dkStoreAbsBook.getCoverUri()).a(new i(this)).a(new x(this.c)).a(this.j);
        invalidateSelf();
    }

    public void a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        this.t = null;
        this.u = 0.0f;
        a(false);
        this.q = dkCloudNoteBookInfo.getTitle();
        this.l.a(this.q);
        this.l.setAlpha(this.p);
        this.m = this.c.getResources().getDrawable(l.a(a()).a(dkCloudNoteBookInfo.getBookFormat()));
        this.m.setAlpha(this.p);
        l.a(this.c).a().b(dkCloudNoteBookInfo.getBookCoverUrl()).a(new j(this)).a(new x(this.c)).a(this.j);
        invalidateSelf();
    }

    public void a(Rect rect, long j) {
        this.s.set(rect);
        this.t = new AlphaAnimation(0.1f, 1.0f);
        this.t.setDuration(j);
        this.t.setFillEnabled(true);
        this.t.setFillAfter(true);
        this.t.setAnimationListener(new k(this));
        invalidateSelf();
    }

    public boolean c() {
        return this.k != null;
    }

    public boolean d() {
        return this.t != null;
    }

    public boolean e() {
        return this.j.d();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (!(this.t == null || this.t.hasEnded())) {
            if (!this.t.hasStarted()) {
                this.t.setStartTime(currentAnimationTimeMillis);
            }
            this.t.getTransformation(currentAnimationTimeMillis, this.r);
            this.u = this.r.getAlpha();
            a(true);
            invalidateSelf();
        }
        Rect bounds = getBounds();
        Rect rect = (Rect) UTools.g.getRect();
        rect.set(bounds);
        if (this.u != 0.0f) {
            float f = (float) ((((bounds.left + this.i.left) + bounds.right) - this.i.right) / 2);
            float f2 = (float) (((bounds.bottom + (bounds.top + this.i.top)) - this.i.bottom) / 2);
            float centerX = (((((((float) this.s.centerX()) - f) * 10.0f) * this.u) + (10.0f * f)) - ((float) this.s.centerX())) / 9.0f;
            f = (((((float) this.s.centerY()) * f) - (f2 * ((float) this.s.centerX()))) + ((f2 - ((float) this.s.centerY())) * centerX)) / (f - ((float) this.s.centerX()));
            f2 = (((((10.0f * 0.42105263f) - 10.0f) * this.u) + 10.0f) - 0.42105263f) / 9.0f;
            canvas.scale(f2, f2, centerX, f);
            RectF rectF = (RectF) UTools.h.getRect();
            rectF.set((centerX - ((float) (this.s.width() / 2))) - ((float) this.i.left), (f - ((float) (this.s.height() / 2))) - ((float) this.i.top), (centerX + ((float) (this.s.width() / 2))) + ((float) this.i.right), (f + ((float) (this.s.height() / 2))) + ((float) this.i.bottom));
            rectF.round(rect);
            UTools.h.getRect(rectF);
        }
        a.set(rect.left + this.i.left, rect.top + this.i.top, rect.right - this.i.right, rect.bottom - this.i.bottom);
        this.j.setBounds(a);
        this.j.draw(canvas);
        if (this.m.isVisible()) {
            this.m.setBounds(a);
            this.m.draw(canvas);
            h.set(a);
            bounds = h;
            bounds.left = (int) (((double) bounds.left) + (((double) a.width()) * 0.15d));
            bounds = h;
            bounds.top = (int) (((double) bounds.top) + (((double) a.height()) * 0.25d));
            bounds = h;
            bounds.right = (int) (((double) bounds.right) - (((double) a.width()) * 0.1d));
            this.l.setBounds(h);
            this.l.draw(canvas);
        }
        if (this.k != null) {
            this.k.setBounds(rect);
            this.k.draw(canvas);
        }
        if (this.o != null) {
            canvas.save();
            canvas.translate((float) UTools.getMinimumHeight(a(), 2.0f), (float) (-Math.round(1.5f * ((float) this.o.getIntrinsicHeight()))));
            UTools.addAnimation(canvas, this.o, a, 85);
            canvas.restore();
        }
        if (this.n != null) {
            UTools.addAnimation(canvas, this.n, a, 53);
        }
        UTools.g.getRect(rect);
        canvas.restore();
    }

    public void setAlpha(int i) {
        if (this.p != i) {
            this.p = i;
            this.j.setAlpha(this.p);
            if (this.n != null) {
                this.n.setAlpha(this.p);
            }
            if (this.o != null) {
                this.o.setAlpha(this.p);
            }
            if (this.m != null) {
                this.m.setAlpha(this.p);
            }
            if (this.l != null) {
                this.l.setAlpha(this.p);
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
        rect.set(this.i);
        return !this.i.isEmpty();
    }

    private void a(c cVar) {
        this.n = l.a(this.c).b(cVar);
        if (this.n != null) {
            this.n.setAlpha(this.p);
        }
    }

    private void b(c cVar) {
        this.o = l.a(this.c).a(cVar);
        if (this.o != null) {
            this.o.setAlpha(this.p);
        }
    }
}
