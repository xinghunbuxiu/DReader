package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.f;
import com.duokan.reader.ui.general.z;

import java.util.List;

public class ad extends z {
    private final cr a;
    private final f[] h = new f[4];
    private final Transformation i = new Transformation();
    private aa j;
    private AlphaAnimation k = null;
    private float l = 0.0f;
    private int m = 255;
    private boolean n = false;
    private final Callback o = new ae(this);

    public ad(Context context) {
        super(context, true);
        this.a = (cr) MyContextWrapper.getFeature(context).queryFeature(cr.class);
        a();
    }

    public Rect a(Rect rect, Rect rect2, int i) {
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
        RectF rectF = (RectF) UTools.h.getRect();
        rectF.left = (f4 + ((((width - (2.0f * f4)) - (2.0f * f2)) / 3.0f) * ((float) (i3 + 1)))) + (((float) i3) * f2);
        rectF.right = f2 + rectF.left;
        rectF.top = ((((float) (i2 + 1)) * f6) + f5) + (((float) i2) * f3);
        rectF.bottom = rectF.top + f3;
        rectF.offset((float) rect3.left, (float) rect3.top);
        rect2.left = Math.round(rectF.centerX() - (width / 2.0f));
        rect2.top = Math.round(rectF.centerY() - (f / 2.0f));
        rect2.right = Math.round(((float) rect2.left) + width);
        rect2.bottom = Math.round(((float) rect2.top) + f);
        UTools.h.getRect(rectF);
        return rect2;
    }

    public void a(aa aaVar) {
        this.j = aaVar;
        this.k = null;
        this.l = 0.0f;
        if (aaVar != null) {
            List a = this.a.a(this.j);
            for (int i = 0; i < this.h.length; i++) {
                if (i < a.size()) {
                    this.h[i].a((c) a.get(i), false);
                    this.h[i].setVisible(true, false);
                } else {
                    this.h[i].setVisible(false, false);
                }
            }
        } else {
            for (f visible : this.h) {
                visible.setVisible(false, false);
            }
        }
        invalidateSelf();
    }

    public Rect a(Rect rect, long j) {
        this.k = new AlphaAnimation(0.1f, 1.0f);
        this.k.setDuration(j);
        this.k.setFillEnabled(true);
        this.k.setFillAfter(true);
        this.k.setAnimationListener(new af(this));
        invalidateSelf();
        return a(rect, 0);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        b();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (!(this.k == null || this.k.hasEnded())) {
            if (!this.k.hasStarted()) {
                this.k.setStartTime(currentAnimationTimeMillis);
            }
            this.k.getTransformation(currentAnimationTimeMillis, this.i);
            this.l = this.i.getAlpha();
            invalidateSelf();
        }
        for (int i = 0; i < this.h.length; i++) {
            f fVar = this.h[i];
            if (fVar.isVisible()) {
                Rect rect = (Rect) UTools.g.getRect();
                b(rect, i);
                if (i != this.h.length - 1 || this.l == 0.0f) {
                    canvas.save();
                    canvas.scale(0.42105263f, 0.42105263f, (float) rect.centerX(), (float) rect.centerY());
                    Rect rect2 = (Rect) UTools.g.getRect();
                    rect2.set(fVar.getBounds());
                    fVar.setBounds(rect);
                    fVar.draw(canvas);
                    fVar.setBounds(rect2);
                    UTools.g.getRect(rect2);
                    canvas.restore();
                } else {
                    canvas.save();
                    canvas.translate((float) fVar.getBounds().centerX(), (float) fVar.getBounds().centerY());
                    canvas.scale((1.0f - this.l) * 0.42105263f, (1.0f - this.l) * 0.42105263f);
                    canvas.translate((float) (-fVar.getBounds().centerX()), (float) (-fVar.getBounds().centerY()));
                    fVar.draw(canvas);
                    canvas.restore();
                }
                UTools.g.getRect(rect);
            }
        }
    }

    public void setAlpha(int i) {
        if (this.m != i) {
            this.m = i;
            for (f fVar : this.h) {
                if (fVar != null) {
                    fVar.setAlpha(i);
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
        if (!this.n) {
            this.n = true;
            super.invalidateSelf();
            if (this.h != null) {
                for (f fVar : this.h) {
                    if (fVar != null) {
                        fVar.invalidateSelf();
                    }
                }
            }
            this.n = false;
        }
    }

    private void a() {
        for (int i = 0; i < this.h.length; i++) {
            f fVar = new f(this.c, e.general__shared__book_category_book_shadow);
            fVar.setCallback(this.o);
            fVar.setVisible(false, false);
            this.h[i] = fVar;
        }
    }

    private void b() {
        for (int i = 0; i < this.h.length; i++) {
            f fVar = this.h[i];
            a(fVar.getBounds(), i);
            fVar.setBounds(fVar.getBounds());
        }
        invalidateSelf();
    }

    private Rect a(Rect rect, int i) {
        return a(getBounds(), rect, i);
    }

    private void b(Rect rect, int i) {
        if (this.l == 0.0f) {
            rect.set(this.h[i].getBounds());
        } else if (i + 1 < this.h.length) {
            f fVar = this.h[i];
            Rect rect2 = (Rect) UTools.g.getRect();
            rect2.set(this.h[i + 1].getBounds());
            float f = (((float) (rect2.left - fVar.getBounds().left)) * ((this.l / 0.9f) - 0.11111111f)) + ((float) fVar.getBounds().left);
            float f2 = (((float) (rect2.top - fVar.getBounds().top)) * ((this.l / 0.9f) - 0.11111111f)) + ((float) fVar.getBounds().top);
            rect.set((int) f, (int) f2, (int) (((float) fVar.getBounds().width()) + f), (int) (((float) fVar.getBounds().height()) + f2));
            UTools.g.getRect(rect2);
        } else {
            rect.set(this.h[i].getBounds());
        }
    }
}
