package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.document.az;

public class xx extends View implements OnPreDrawListener {
    /* renamed from: a */
    static final /* synthetic */ boolean f11164a = (!xx.class.desiredAssertionStatus());
    /* renamed from: b */
    private final az f11165b;
    /* renamed from: c */
    private final xy f11166c;
    /* renamed from: d */
    private final Rect f11167d = new Rect();
    /* renamed from: e */
    private int f11168e = -1;

    public xx(Context context, az azVar) {
        super(context);
        if (f11164a || azVar != null) {
            this.f11165b = azVar;
            this.f11166c = new xy(this, -1, -1);
            return;
        }
        throw new AssertionError();
    }

    public void setLineGap(float f) {
        this.f11165b.m6403a(f);
        requestLayout();
        invalidate();
    }

    public void setParaSpacing(float f) {
        this.f11165b.m6408b(f);
        requestLayout();
        invalidate();
    }

    public void setTabStop(float f) {
        this.f11165b.m6412c(f);
        requestLayout();
        invalidate();
    }

    public void setFirstLineIndent(float f) {
        this.f11165b.m6415d(f);
        requestLayout();
    }

    public void setTextSize(int i) {
        this.f11165b.m6409b(i);
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.f11165b.m6413c(i);
        requestLayout();
        invalidate();
    }

    public void setMaxWidth(int i) {
        this.f11168e = i;
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int size = MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) - paddingRight : Integer.MAX_VALUE;
        if (this.f11168e > 0 && size > this.f11168e) {
            size = this.f11168e;
        }
        this.f11165b.m6404a(size - paddingRight);
        setMeasuredDimension(resolveSize(Math.max(getSuggestedMinimumWidth(), this.f11165b.m6407b() + paddingRight), i), resolveSize(Math.max(getSuggestedMinimumHeight(), paddingBottom + this.f11165b.m6411c()), i2));
    }

    public boolean onPreDraw() {
        invalidate();
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = (RectF) dv.f1199h.addAnimation();
        RectF rectF2 = (RectF) dv.f1199h.addAnimation();
        Rect rect = (Rect) dv.f1198g.addAnimation();
        if (dv.m1925a(rectF, (View) this)) {
            rectF2.set(0.0f, 0.0f, (float) getResources().getDisplayMetrics().widthPixels, (float) getResources().getDisplayMetrics().heightPixels);
            dv.m1938b(rectF2, (View) this);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            rectF.offset((float) (-paddingLeft), (float) (-paddingTop));
            rectF2.round(rect);
            this.f11166c.setBounds(paddingLeft, paddingTop, this.f11166c.getIntrinsicWidth() + paddingLeft, this.f11166c.getIntrinsicHeight() + paddingTop);
            this.f11166c.m10247a(rect.width());
            this.f11166c.m10251b(rect.height());
            rectF.round(rect);
            this.f11166c.m10249a(rect);
            this.f11166c.draw(canvas);
        }
        dv.f1199h.clearAnimation(rectF);
        dv.f1199h.clearAnimation(rectF2);
        dv.f1198g.clearAnimation(rect);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            this.f11166c.m10246a();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11166c.m10246a();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
