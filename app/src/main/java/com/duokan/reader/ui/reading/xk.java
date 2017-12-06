package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.document.az;

public class xk extends View implements OnPreDrawListener {
    static final /* synthetic */ boolean a = (!xk.class.desiredAssertionStatus());
    private final az b;
    private final xl c;
    private final Rect d = new Rect();
    private int e = -1;

    public xk(Context context, az azVar) {
        super(context);
        if (a || azVar != null) {
            this.b = azVar;
            this.c = new xl(this, -1, -1);
            return;
        }
        throw new AssertionError();
    }

    public void setLineGap(float f) {
        this.b.a(f);
        requestLayout();
        invalidate();
    }

    public void setParaSpacing(float f) {
        this.b.b(f);
        requestLayout();
        invalidate();
    }

    public void setTabStop(float f) {
        this.b.c(f);
        requestLayout();
        invalidate();
    }

    public void setFirstLineIndent(float f) {
        this.b.d(f);
        requestLayout();
    }

    public void setTextSize(int i) {
        this.b.b(i);
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.b.c(i);
        requestLayout();
        invalidate();
    }

    public void setMaxWidth(int i) {
        this.e = i;
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int size = MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) - paddingRight : Integer.MAX_VALUE;
        if (this.e > 0 && size > this.e) {
            size = this.e;
        }
        this.b.a(size - paddingRight);
        setMeasuredDimension(resolveSize(Math.max(getSuggestedMinimumWidth(), this.b.b() + paddingRight), i), resolveSize(Math.max(getSuggestedMinimumHeight(), paddingBottom + this.b.c()), i2));
    }

    public boolean onPreDraw() {
        invalidate();
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = (RectF) UTools.h.getRect();
        RectF rectF2 = (RectF) UTools.h.getRect();
        Rect rect = (Rect) UTools.g.getRect();
        if (UTools.isInRange(rectF, (View) this)) {
            rectF2.set(0.0f, 0.0f, (float) getResources().getDisplayMetrics().widthPixels, (float) getResources().getDisplayMetrics().heightPixels);
            UTools.closeAnimation(rectF2, (View) this);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            rectF.offset((float) (-paddingLeft), (float) (-paddingTop));
            rectF2.round(rect);
            this.c.setBounds(paddingLeft, paddingTop, this.c.getIntrinsicWidth() + paddingLeft, this.c.getIntrinsicHeight() + paddingTop);
            this.c.a(rect.width());
            this.c.b(rect.height());
            rectF.round(rect);
            this.c.a(rect);
            this.c.draw(canvas);
        }
        UTools.h.getRect(rectF);
        UTools.h.getRect(rectF2);
        UTools.g.getRect(rect);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            this.c.a();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.a();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
