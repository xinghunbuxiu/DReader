package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.common.a;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.c;

public class me extends ViewGroup {
    private int a = -1;
    private Bitmap b = null;
    private Bitmap c = null;
    private final aj d;
    private final mn e;

    public me(Context context, aj ajVar, mn mnVar) {
        super(context);
        setWillNotDraw(false);
        this.e = mnVar;
        this.d = ajVar;
        setShowClearImage(false);
    }

    public void a() {
        this.a = -1;
    }

    public void b() {
        int i = this.a - 1;
        if (i < -1) {
            i = this.d.a() - 1;
        }
        a(i);
    }

    public void c() {
        int i = this.a + 1;
        if (i > this.d.a() - 1) {
            i = -1;
        }
        a(i);
    }

    public boolean a(int i) {
        if (this.a != i) {
            this.a = i;
            c a = i < 0 ? null : this.d.a(i);
            this.e.a(i, i < 0 ? 1.0f : a.a(), i < 0 ? (float) (getWidth() / 2) : a.b().x, i < 0 ? (float) (getHeight() / 2) : a.b().y);
            return true;
        } else if (this.a != -1) {
            return false;
        } else {
            this.e.a(this.a, 1.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
            return true;
        }
    }

    public PointF a(View view, int i) {
        c a = this.d.a(i);
        return dv.a(new PointF(a.b().x, a.b().y), (View) this, view);
    }

    public void setShowClearImage(boolean z) {
        e();
        if (z) {
            d();
        } else {
            e();
        }
    }

    public boolean a(PointF pointF) {
        for (int i = 0; i < this.d.a(); i++) {
            PointF b = this.d.a(i).b();
            int b2 = dv.b(getContext(), 40.0f);
            int b3 = dv.b(getContext(), 40.0f);
            if (new RectF(b.x - ((float) (b2 / 2)), b.y - ((float) (b3 / 2)), ((float) (b2 / 2)) + b.x, b.y + ((float) (b3 / 2))).contains(pointF.x, pointF.y)) {
                return a(i);
            }
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.d.k().b(), this.d.k().c());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.d.a(new mf(this));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect(0, 0, getWidth(), getHeight());
        if (this.c != null && !this.c.isRecycled()) {
            canvas.drawBitmap(this.c, null, rect, null);
        } else if (this.b != null) {
            canvas.drawBitmap(this.b, null, rect, null);
        }
    }

    private void d() {
        a.a(new mg(this), new Void[0]);
    }

    private void e() {
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
    }
}
