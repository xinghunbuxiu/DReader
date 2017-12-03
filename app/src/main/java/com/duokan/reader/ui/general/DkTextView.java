package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class DkTextView extends View implements Callback {
    private final bd a;
    private final Rect b;

    public DkTextView(Context context) {
        this(context, null);
    }

    public DkTextView(Context context, AttributeSet attributeSet) {
        TruncateAt truncateAt;
        super(context, attributeSet);
        this.a = new bd();
        this.b = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842901, 16842904, 16842923, 16842927, 16843087, 16843091});
        int integer = obtainStyledAttributes.getInteger(3, 3);
        int integer2 = obtainStyledAttributes.getInteger(5, Integer.MAX_VALUE);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 16);
        int color = obtainStyledAttributes.getColor(1, -16777216);
        String string = obtainStyledAttributes.hasValue(4) ? obtainStyledAttributes.getString(4) : "";
        switch (obtainStyledAttributes.getInt(2, 0)) {
            case 2:
                truncateAt = TruncateAt.MIDDLE;
                break;
            case 3:
                truncateAt = TruncateAt.END;
                break;
            default:
                truncateAt = TruncateAt.END;
                break;
        }
        obtainStyledAttributes.recycle();
        this.a.c(integer);
        this.a.d(integer2);
        this.a.b(dimensionPixelSize);
        this.a.a(color);
        this.a.a(string);
        this.a.a(truncateAt);
        this.a.getIntrinsicWidth();
        this.a.setCallback(this);
        setDrawingCacheEnabled(true);
        setWillNotDraw(false);
        setWillNotCacheDrawing(true);
    }

    public void setGravity(int i) {
        this.a.c(i);
    }

    public String getText() {
        return this.a.a();
    }

    public void setText(int i) {
        setText(getResources().getString(i));
    }

    public void setText(String str) {
        this.a.a(str);
        if (!this.a.i()) {
            requestLayout();
        }
    }

    public void setTextColor(int i) {
        this.a.a(i);
    }

    public float getTextSize() {
        return this.a.b();
    }

    public void setTextSize(float f) {
        this.a.b(Math.round(TypedValue.applyDimension(2, f, getResources().getDisplayMetrics())));
        if (!this.a.i()) {
            requestLayout();
        }
    }

    public void setTextPixelSize(int i) {
        this.a.b(i);
        if (!this.a.i()) {
            requestLayout();
        }
    }

    public boolean getChsToChtChars() {
        return this.a.c();
    }

    public void setChsToChtChars(boolean z) {
        this.a.a(z);
    }

    public double getFirstLineIndent() {
        return this.a.d();
    }

    public void setFirstLineIndent(double d) {
        this.a.a(d);
        if (!this.a.i()) {
            requestLayout();
        }
    }

    public double getLineGap() {
        return this.a.e();
    }

    public void setLineGap(double d) {
        this.a.b(d);
        if (!this.a.i()) {
            requestLayout();
        }
    }

    public double getParaSpacing() {
        return this.a.f();
    }

    public void setParaSpacing(double d) {
        this.a.c(d);
        if (!this.a.i()) {
            requestLayout();
        }
    }

    public double getTabStop() {
        return this.a.g();
    }

    public void setTabStop(double d) {
        this.a.d(d);
        if (!this.a.i()) {
            requestLayout();
        }
    }

    public void setMaxLines(int i) {
        this.a.d(i);
        if (!this.a.i()) {
            requestLayout();
        }
    }

    public Rect getTextBounds() {
        this.b.set(this.a.h());
        this.b.offset(this.a.getBounds().left, this.a.h().top);
        return this.b;
    }

    protected void onMeasure(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int size = MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) : Integer.MAX_VALUE;
        if (MeasureSpec.getMode(i2) != 0) {
            i3 = MeasureSpec.getSize(i2);
        }
        this.a.setBounds(getPaddingLeft(), getPaddingTop(), size - getPaddingRight(), i3 - getPaddingBottom());
        setMeasuredDimension(resolveSize(Math.max(getSuggestedMinimumWidth(), this.a.getIntrinsicWidth() + paddingRight), i), resolveSize(Math.max(getSuggestedMinimumHeight(), this.a.getIntrinsicHeight() + paddingBottom), i2));
        this.a.setBounds(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.draw(canvas);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        postDelayed(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        removeCallbacks(runnable);
    }
}
