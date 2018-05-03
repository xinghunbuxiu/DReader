package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.common.C0259a;
import com.duokan.core.ui.AnimUtils;
import com.duokan.reader.domain.document.C0931c;
import com.duokan.reader.domain.document.aj;

public class mo extends ViewGroup {
    /* renamed from: a */
    private int f10631a = -1;
    /* renamed from: b */
    private Bitmap f10632b = null;
    /* renamed from: c */
    private Bitmap f10633c = null;
    /* renamed from: d */
    private final aj f10634d;
    /* renamed from: e */
    private final mx f10635e;

    public mo(Context context, aj ajVar, mx mxVar) {
        super(context);
        setWillNotDraw(false);
        this.f10635e = mxVar;
        this.f10634d = ajVar;
        setShowClearImage(false);
    }

    /* renamed from: a */
    public void m14668a() {
        this.f10631a = -1;
    }

    /* renamed from: b */
    public void m14671b() {
        int i = this.f10631a - 1;
        if (i < -1) {
            i = this.f10634d.mo1415a() - 1;
        }
        m14669a(i);
    }

    /* renamed from: c */
    public void m14672c() {
        int i = this.f10631a + 1;
        if (i > this.f10634d.mo1415a() - 1) {
            i = -1;
        }
        m14669a(i);
    }

    /* renamed from: a */
    public boolean m14669a(int i) {
        if (this.f10631a != i) {
            this.f10631a = i;
            C0931c a = i < 0 ? null : this.f10634d.mo1416a(i);
            this.f10635e.mo2440a(i, i < 0 ? 1.0f : a.m6427a(), i < 0 ? (float) (getWidth() / 2) : a.m6429b().x, i < 0 ? (float) (getHeight() / 2) : a.m6429b().y);
            return true;
        } else if (this.f10631a != -1) {
            return false;
        } else {
            this.f10635e.mo2440a(this.f10631a, 1.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
            return true;
        }
    }

    /* renamed from: a */
    public PointF m14667a(View view, int i) {
        C0931c a = this.f10634d.mo1416a(i);
        return AnimUtils.m1900a(new PointF(a.m6429b().x, a.m6429b().y), (View) this, view);
    }

    public void setShowClearImage(boolean z) {
        m14666e();
        if (z) {
            m14665d();
        } else {
            m14666e();
        }
    }

    /* renamed from: a */
    public boolean m14670a(PointF pointF) {
        for (int i = 0; i < this.f10634d.mo1415a(); i++) {
            PointF b = this.f10634d.mo1416a(i).m6429b();
            int b2 = AnimUtils.m1932b(getContext(), 40.0f);
            int b3 = AnimUtils.m1932b(getContext(), 40.0f);
            if (new RectF(b.x - ((float) (b2 / 2)), b.y - ((float) (b3 / 2)), ((float) (b2 / 2)) + b.x, b.y + ((float) (b3 / 2))).contains(pointF.x, pointF.y)) {
                return m14669a(i);
            }
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f10634d.mo1396k().mo1402b(), this.f10634d.mo1396k().mo1403c());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10634d.mo1383a(new mp(this));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m14666e();
        if (this.f10632b != null) {
            this.f10632b.recycle();
            this.f10632b = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect(0, 0, getWidth(), getHeight());
        if (this.f10633c != null && !this.f10633c.isRecycled()) {
            canvas.drawBitmap(this.f10633c, null, rect, null);
        } else if (this.f10632b != null) {
            canvas.drawBitmap(this.f10632b, null, rect, null);
        }
    }

    /* renamed from: d */
    private void m14665d() {
        C0259a.m568a(new mq(this), new Void[0]);
    }

    /* renamed from: e */
    private void m14666e() {
        if (this.f10633c != null) {
            this.f10633c.recycle();
            this.f10633c = null;
        }
    }
}
