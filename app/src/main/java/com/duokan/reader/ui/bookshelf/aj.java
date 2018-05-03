package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.ui.general.C1283z;
import com.duokan.reader.ui.general.C1332f;
import java.util.List;

public class aj extends C1283z {
    /* renamed from: a */
    private final cw f6105a;
    /* renamed from: h */
    private final C1332f[] f6106h = new C1332f[4];
    /* renamed from: i */
    private final Transformation f6107i = new Transformation();
    /* renamed from: j */
    private aa f6108j;
    /* renamed from: k */
    private AlphaAnimation f6109k = null;
    /* renamed from: l */
    private float f6110l = 0.0f;
    /* renamed from: m */
    private int f6111m = 255;
    /* renamed from: n */
    private boolean f6112n = false;
    /* renamed from: o */
    private final Callback f6113o = new ak(this);

    public aj(Context context) {
        super(context, true);
        this.f6105a = (cw) AppContext.getAppContext(context).queryFeature(cw.class);
        m9133a();
    }

    /* renamed from: a */
    public Rect m9137a(Rect rect, Rect rect2, int i) {
        Rect rect3 = this.f;
        float width = (float) ((rect.width() - rect3.left) - rect3.right);
        float f = width * 1.390625f;
        float f2 = width * 0.42105263f;
        float f3 = f * 0.42105263f;
        float f4 = (12.0f * width) / 256.0f;
        float f5 = (10.0f * f) / 356.0f;
        float f6 = (((f - f5) - ((8.0f * f) / 356.0f)) - (2.0f * f3)) / 3.0f;
        int i2 = i / 2;
        int i3 = i % 2;
        RectF rectF = (RectF) AnimUtils.f1199h.addAnimation();
        rectF.left = (f4 + ((((width - (2.0f * f4)) - (2.0f * f2)) / 3.0f) * ((float) (i3 + 1)))) + (((float) i3) * f2);
        rectF.right = f2 + rectF.left;
        rectF.top = ((((float) (i2 + 1)) * f6) + f5) + (((float) i2) * f3);
        rectF.bottom = rectF.top + f3;
        rectF.offset((float) rect3.left, (float) rect3.top);
        rect2.left = Math.round(rectF.centerX() - (width / 2.0f));
        rect2.top = Math.round(rectF.centerY() - (f / 2.0f));
        rect2.right = Math.round(((float) rect2.left) + width);
        rect2.bottom = Math.round(((float) rect2.top) + f);
        AnimUtils.f1199h.clearAnimation(rectF);
        return rect2;
    }

    /* renamed from: a */
    public void m9138a(aa aaVar) {
        this.f6108j = aaVar;
        this.f6109k = null;
        this.f6110l = 0.0f;
        if (aaVar != null) {
            List a = this.f6105a.m9434a(this.f6108j);
            for (int i = 0; i < this.f6106h.length; i++) {
                if (i < a.size()) {
                    this.f6106h[i].m10608a((C0800c) a.get(i), false);
                    this.f6106h[i].setVisible(true, false);
                } else {
                    this.f6106h[i].setVisible(false, false);
                }
            }
        } else {
            for (C1332f visible : this.f6106h) {
                visible.setVisible(false, false);
            }
        }
        invalidateSelf();
    }

    /* renamed from: a */
    public Rect m9136a(Rect rect, long j) {
        this.f6109k = new AlphaAnimation(0.1f, 1.0f);
        this.f6109k.setDuration(j);
        this.f6109k.setFillEnabled(true);
        this.f6109k.setFillAfter(true);
        this.f6109k.setAnimationListener(new al(this));
        invalidateSelf();
        return m9132a(rect, 0);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        m9134b();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (!(this.f6109k == null || this.f6109k.hasEnded())) {
            if (!this.f6109k.hasStarted()) {
                this.f6109k.setStartTime(currentAnimationTimeMillis);
            }
            this.f6109k.getTransformation(currentAnimationTimeMillis, this.f6107i);
            this.f6110l = this.f6107i.getAlpha();
            invalidateSelf();
        }
        for (int i = 0; i < this.f6106h.length; i++) {
            C1332f c1332f = this.f6106h[i];
            if (c1332f.isVisible()) {
                Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
                m9135b(rect, i);
                if (i != this.f6106h.length - 1 || this.f6110l == 0.0f) {
                    canvas.save();
                    canvas.scale(0.42105263f, 0.42105263f, (float) rect.centerX(), (float) rect.centerY());
                    Rect rect2 = (Rect) AnimUtils.f1198g.addAnimation();
                    rect2.set(c1332f.getBounds());
                    c1332f.setBounds(rect);
                    c1332f.draw(canvas);
                    c1332f.setBounds(rect2);
                    AnimUtils.f1198g.clearAnimation(rect2);
                    canvas.restore();
                } else {
                    canvas.save();
                    canvas.translate((float) c1332f.getBounds().centerX(), (float) c1332f.getBounds().centerY());
                    canvas.scale((1.0f - this.f6110l) * 0.42105263f, (1.0f - this.f6110l) * 0.42105263f);
                    canvas.translate((float) (-c1332f.getBounds().centerX()), (float) (-c1332f.getBounds().centerY()));
                    c1332f.draw(canvas);
                    canvas.restore();
                }
                AnimUtils.f1198g.clearAnimation(rect);
            }
        }
    }

    public void setAlpha(int i) {
        if (this.f6111m != i) {
            this.f6111m = i;
            for (C1332f c1332f : this.f6106h) {
                if (c1332f != null) {
                    c1332f.setAlpha(i);
                }
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public void invalidateSelf() {
        if (!this.f6112n) {
            this.f6112n = true;
            super.invalidateSelf();
            if (this.f6106h != null) {
                for (C1332f c1332f : this.f6106h) {
                    if (c1332f != null) {
                        c1332f.invalidateSelf();
                    }
                }
            }
            this.f6112n = false;
        }
    }

    /* renamed from: a */
    private void m9133a() {
        for (int i = 0; i < this.f6106h.length; i++) {
            C1332f c1332f = new C1332f(this.c, C0243e.general__shared__book_category_book_shadow);
            c1332f.setCallback(this.f6113o);
            c1332f.setVisible(false, false);
            this.f6106h[i] = c1332f;
        }
    }

    /* renamed from: b */
    private void m9134b() {
        for (int i = 0; i < this.f6106h.length; i++) {
            C1332f c1332f = this.f6106h[i];
            m9132a(c1332f.getBounds(), i);
            c1332f.setBounds(c1332f.getBounds());
        }
        invalidateSelf();
    }

    /* renamed from: a */
    private Rect m9132a(Rect rect, int i) {
        return m9137a(getBounds(), rect, i);
    }

    /* renamed from: b */
    private void m9135b(Rect rect, int i) {
        if (this.f6110l == 0.0f) {
            rect.set(this.f6106h[i].getBounds());
        } else if (i + 1 < this.f6106h.length) {
            C1332f c1332f = this.f6106h[i];
            Rect rect2 = (Rect) AnimUtils.f1198g.addAnimation();
            rect2.set(this.f6106h[i + 1].getBounds());
            float f = (((float) (rect2.left - c1332f.getBounds().left)) * ((this.f6110l / 0.9f) - 0.11111111f)) + ((float) c1332f.getBounds().left);
            float f2 = (((float) (rect2.top - c1332f.getBounds().top)) * ((this.f6110l / 0.9f) - 0.11111111f)) + ((float) c1332f.getBounds().top);
            rect.set((int) f, (int) f2, (int) (((float) c1332f.getBounds().width()) + f), (int) (((float) c1332f.getBounds().height()) + f2));
            AnimUtils.f1198g.clearAnimation(rect2);
        } else {
            rect.set(this.f6106h[i].getBounds());
        }
    }
}
