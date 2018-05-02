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
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0247i;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.ee;

/* renamed from: com.duokan.reader.ui.reading.g */
public class C1455g extends Drawable {
    /* renamed from: a */
    private final Context f10206a;
    /* renamed from: b */
    private final su f10207b;
    /* renamed from: c */
    private final int f10208c;
    /* renamed from: d */
    private final int f10209d;
    /* renamed from: e */
    private final Paint f10210e;
    /* renamed from: f */
    private final Paint f10211f;
    /* renamed from: g */
    private final ee f10212g;
    /* renamed from: h */
    private final Transformation f10213h = new Transformation();
    /* renamed from: i */
    private final Rect f10214i = new Rect();
    /* renamed from: j */
    private Animation f10215j = null;
    /* renamed from: k */
    private String f10216k = "";
    /* renamed from: l */
    private boolean f10217l = false;
    /* renamed from: m */
    private boolean f10218m = false;

    public C1455g(Context context, su suVar) {
        this.f10206a = context;
        this.f10207b = suVar;
        this.f10208c = dv.m1932b(context, 80.0f);
        this.f10209d = dv.m1932b(context, 25.0f);
        this.f10216k = context.getResources().getString(C0247i.reading__shared__add_to_bookshelf_ok_plus);
        this.f10212g = (ee) suVar.mo1992G();
        this.f10210e = new Paint();
        this.f10210e.setColor(Color.parseColor("#cccccc"));
        this.f10210e.setAntiAlias(true);
        this.f10211f = new Paint(this.f10210e);
        this.f10211f.setTextSize((float) dv.m1932b(context, 14.0f));
        this.f10211f.setSubpixelText(true);
        this.f10210e.setStrokeWidth((float) dv.m1932b(context, 1.0f));
        this.f10210e.setStyle(Style.STROKE);
    }

    public void draw(Canvas canvas) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (!(this.f10215j == null || this.f10215j.hasEnded())) {
            if (!this.f10215j.hasStarted()) {
                this.f10215j.setStartTime(currentAnimationTimeMillis);
            }
            this.f10215j.getTransformation(currentAnimationTimeMillis, this.f10213h);
            this.f10210e.setAlpha((int) (this.f10213h.getAlpha() * 255.0f));
            this.f10211f.setAlpha(this.f10210e.getAlpha());
            invalidateSelf();
        }
        canvas.drawRoundRect(new RectF(getBounds()), (float) (this.f10209d / 2), (float) (this.f10209d / 2), this.f10210e);
        dv.m1913a(canvas, this.f10216k, getBounds(), 17, this.f10211f);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return this.f10208c;
    }

    public int getIntrinsicHeight() {
        return this.f10209d;
    }

    /* renamed from: a */
    public Rect m14192a() {
        return this.f10214i;
    }

    /* renamed from: a */
    public void m14194a(int i, int i2, int i3, int i4) {
        this.f10214i.set(i, i2, i3, i4);
    }

    /* renamed from: a */
    public void m14193a(int i) {
        this.f10210e.setColor(i);
        this.f10211f.setColor(i);
    }

    /* renamed from: b */
    public void m14195b() {
        if (!this.f10218m) {
            this.f10218m = true;
            UmengManager.get().onEvent("READING_ADD_BOOKB", "YES");
            this.f10212g.m4405a(new C1456h(this));
        }
    }
}
