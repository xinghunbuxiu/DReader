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
import android.view.View.MeasureSpec;
import java.io.File;

public class DkTextView extends View implements Callback {
    /* renamed from: a */
    private final bd f6790a;
    /* renamed from: b */
    private final Rect f6791b;

    public DkTextView(Context context) {
        this(context, null);
    }

    public DkTextView(Context context, AttributeSet attributeSet) {
        TruncateAt truncateAt;
        super(context, attributeSet);
        this.f6790a = new bd();
        this.f6791b = new Rect();
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
        this.f6790a.m10276c(integer);
        this.f6790a.m10280d(integer2);
        this.f6790a.m10274b(dimensionPixelSize);
        this.f6790a.m10267a(color);
        this.f6790a.m10270a(string);
        this.f6790a.m10268a(truncateAt);
        this.f6790a.getIntrinsicWidth();
        this.f6790a.setCallback(this);
        setDrawingCacheEnabled(true);
        setWillNotDraw(false);
        setWillNotCacheDrawing(true);
    }

    public void setGravity(int i) {
        this.f6790a.m10276c(i);
    }

    public String getText() {
        return this.f6790a.m10265a();
    }

    public void setText(int i) {
        setText(getResources().getString(i));
    }

    public void setText(String str) {
        this.f6790a.m10270a(str);
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public void setTextColor(int i) {
        this.f6790a.m10267a(i);
    }

    public float getTextSize() {
        return this.f6790a.m10272b();
    }

    public void setTextSize(float f) {
        this.f6790a.m10274b(Math.round(TypedValue.applyDimension(2, f, getResources().getDisplayMetrics())));
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public void setTextPixelSize(int i) {
        this.f6790a.m10274b(i);
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public boolean getChsToChtChars() {
        return this.f6790a.m10277c();
    }

    public void setChsToChtChars(boolean z) {
        this.f6790a.m10271a(z);
    }

    public double getFirstLineIndent() {
        return this.f6790a.m10278d();
    }

    public void setFirstLineIndent(double d) {
        this.f6790a.m10266a(d);
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.f6790a.m10268a(truncateAt);
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public void setEnTypefaceFile(File file) {
        this.f6790a.m10269a(file);
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public double getLineGap() {
        return this.f6790a.m10281e();
    }

    public void setLineGap(double d) {
        this.f6790a.m10273b(d);
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public double getParaSpacing() {
        return this.f6790a.m10282f();
    }

    public void setParaSpacing(double d) {
        this.f6790a.m10275c(d);
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public double getTabStop() {
        return this.f6790a.m10283g();
    }

    public void setTabStop(double d) {
        this.f6790a.m10279d(d);
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public void setMaxLines(int i) {
        this.f6790a.m10280d(i);
        if (!this.f6790a.m10285i()) {
            requestLayout();
        }
    }

    public Rect getTextBounds() {
        this.f6791b.set(this.f6790a.m10284h());
        this.f6791b.offset(this.f6790a.getBounds().left, this.f6790a.m10284h().top);
        return this.f6791b;
    }

    protected void onMeasure(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int size = MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) : Integer.MAX_VALUE;
        if (MeasureSpec.getMode(i2) != 0) {
            i3 = MeasureSpec.getSize(i2);
        }
        this.f6790a.setBounds(getPaddingLeft(), getPaddingTop(), size - getPaddingRight(), i3 - getPaddingBottom());
        setMeasuredDimension(resolveSize(Math.max(getSuggestedMinimumWidth(), this.f6790a.getIntrinsicWidth() + paddingRight), i), resolveSize(Math.max(getSuggestedMinimumHeight(), this.f6790a.getIntrinsicHeight() + paddingBottom), i2));
        this.f6790a.setBounds(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f6790a.draw(canvas);
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
