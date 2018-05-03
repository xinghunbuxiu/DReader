package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class BoxView extends FrameLayout {
    
    static final  boolean desiredAssertionStatus = (!BoxView.class.desiredAssertionStatus());
    
    private int f745b;
    
    private int f746c;
    
    private boolean f747d;
    
    private cm f748e;

    public BoxView(Context context) {
        this(context, null);
    }

    public BoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843039, 16843040});
        this.f745b = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f746c = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        obtainStyledAttributes.recycle();
    }

    public void setMaxWidth(int i) {
        if (this.f745b != i) {
            this.f745b = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (this.f746c != i) {
            this.f746c = i;
            requestLayout();
        }
    }

    public boolean getResizeLayoutForSoftInput() {
        return this.f747d;
    }

    public void setResizeLayoutForSoftInput(boolean z) {
        if (this.f747d != z) {
            this.f747d = z;
            cj a = cj.m1764a(getContext());
            if (this.f747d) {
                if (this.f748e == null) {
                    this.f748e = new C0381e(this);
                    a.m1774a(this.f748e);
                }
            } else if (this.f748e != null) {
                a.m1777b(this.f748e);
                this.f748e = null;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                if (this.f745b >= 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(this.f745b, size), MeasureSpec.AT_MOST);
                    break;
                }
                break;
            case 0:
                if (this.f745b >= 0) {
                    i = MeasureSpec.makeMeasureSpec(this.f745b, MeasureSpec.AT_MOST);
                    break;
                }
                break;
            case 1073741824:
                if (this.f745b >= 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(this.f745b, size), MeasureSpec.EXACTLY);
                    break;
                }
                break;
            default:
                if (!desiredAssertionStatus) {
                    throw new AssertionError();
                }
                break;
        }
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                if (this.f746c >= 0) {
                    i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f746c, size2), MeasureSpec.AT_MOST);
                    break;
                }
                break;
            case 0:
                if (this.f746c >= 0) {
                    i2 = MeasureSpec.makeMeasureSpec(this.f746c, MeasureSpec.AT_MOST);
                    break;
                }
                break;
            case 1073741824:
                if (this.f746c >= 0) {
                    i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f746c, size2), MeasureSpec.EXACTLY);
                    break;
                }
                break;
            default:
                if (!desiredAssertionStatus) {
                    throw new AssertionError();
                }
                break;
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f747d) {
            cj a = cj.m1764a(getContext());
            if (a.m1775a()) {
                Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
                AnimUtils.m1904a(rect, (View) this, null);
                int max = Math.max(0, rect.bottom - a.m1776b().top);
                AnimUtils.f1198g.clearAnimation(rect);
                if (max > 0) {
                    int height = getHeight() - max;
                    measure(MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(height, 1073741824));
                    setMeasuredDimension(getWidth(), getHeight());
                    super.onLayout(true, i, i2, i3, i2 + height);
                    return;
                }
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f748e != null) {
            cj.m1764a(getContext()).m1774a(this.f748e);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f748e != null) {
            cj.m1764a(getContext()).m1777b(this.f748e);
        }
    }
}
