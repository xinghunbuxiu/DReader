package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import com.duokan.core.ui.UTools;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.ej;

public class g extends Drawable {
    private final Context a;
    private final sh b;
    private final int c;
    private final int d;
    private final Paint e;
    private final Paint f;
    private final ej g;
    private final Transformation h = new Transformation();
    private final Rect i = new Rect();
    private Animation j = null;
    private String k = "";
    private boolean l = false;
    private boolean m = false;

    public g(Context context, sh shVar) {
        this.a = context;
        this.b = shVar;
        this.c = UTools.getMinimumHeight(context, 80.0f);
        this.d = UTools.getMinimumHeight(context, 25.0f);
        this.k = context.getResources().getString(i.reading__shared__add_to_bookshelf_ok_plus);
        this.g = (ej) shVar.G();
        this.e = new Paint();
        this.e.setColor(Color.parseColor("#cccccc"));
        this.e.setAntiAlias(true);
        this.f = new Paint(this.e);
        this.f.setTextSize((float) UTools.getMinimumHeight(context, 14.0f));
        this.f.setSubpixelText(true);
        this.e.setStrokeWidth((float) UTools.getMinimumHeight(context, 1.0f));
        this.e.setStyle(Style.STROKE);
    }

    public void draw(Canvas canvas) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (!(this.j == null || this.j.hasEnded())) {
            if (!this.j.hasStarted()) {
                this.j.setStartTime(currentAnimationTimeMillis);
            }
            this.j.getTransformation(currentAnimationTimeMillis, this.h);
            this.e.setAlpha((int) (this.h.getAlpha() * 255.0f));
            this.f.setAlpha(this.e.getAlpha());
            invalidateSelf();
        }
        canvas.drawRoundRect(new RectF(getBounds()), (float) (this.d / 2), (float) (this.d / 2), this.e);
        UTools.addAnimation(canvas, this.k, getBounds(), 17, this.f);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return this.c;
    }

    public int getIntrinsicHeight() {
        return this.d;
    }

    public Rect a() {
        return this.i;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.i.set(i, i2, i3, i4);
    }

    public void a(int i) {
        this.e.setColor(i);
        this.f.setColor(i);
    }

    public void b() {
        if (!this.m) {
            this.m = true;
            UmengManager.get().onEvent("READING_ADD_BOOKB", "YES");
            this.g.a(new h(this));
        }
    }
}
