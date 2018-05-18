package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class BoxView extends FrameLayout {
    
    static final  boolean desiredAssertionStatus = (!BoxView.class.desiredAssertionStatus());

    private int maxWidth;

    private int maxHeight;

    private boolean resizeLayoutForSoftInput;
    
    private cm f748e;

    public BoxView(Context context) {
        this(context, null);
    }

    public BoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843039, 16843040});
        this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.maxHeight = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        obtainStyledAttributes.recycle();
    }

    public void setMaxWidth(int maxWidth) {
        if (this.maxWidth != maxWidth) {
            this.maxWidth = maxWidth;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (this.maxHeight != i) {
            this.maxHeight = i;
            requestLayout();
        }
    }

    public boolean getResizeLayoutForSoftInput() {
        return this.resizeLayoutForSoftInput;
    }

    public void setResizeLayoutForSoftInput(boolean resizeLayoutForSoftInput) {
        if (this.resizeLayoutForSoftInput != resizeLayoutForSoftInput) {
            this.resizeLayoutForSoftInput = resizeLayoutForSoftInput;
            cj a = cj.m1764a(getContext());
            if (this.resizeLayoutForSoftInput) {
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int size2 = MeasureSpec.getSize(heightMeasureSpec);
        switch (MeasureSpec.getMode(widthMeasureSpec)) {
            case Integer.MIN_VALUE:
                if (this.maxWidth >= 0) {
                    widthMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(this.maxWidth, size), MeasureSpec.AT_MOST);
                    break;
                }
                break;
            case 0:
                if (this.maxWidth >= 0) {
                    widthMeasureSpec = MeasureSpec.makeMeasureSpec(this.maxWidth, MeasureSpec.AT_MOST);
                    break;
                }
                break;
            case 1073741824:
                if (this.maxWidth >= 0) {
                    widthMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(this.maxWidth, size), MeasureSpec.EXACTLY);
                    break;
                }
                break;
            default:
                if (!desiredAssertionStatus) {
                    throw new AssertionError();
                }
                break;
        }
        switch (MeasureSpec.getMode(heightMeasureSpec)) {
            case Integer.MIN_VALUE:
                if (this.maxHeight >= 0) {
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(this.maxHeight, size2), MeasureSpec.AT_MOST);
                    break;
                }
                break;
            case 0:
                if (this.maxHeight >= 0) {
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(this.maxHeight, MeasureSpec.AT_MOST);
                    break;
                }
                break;
            case 1073741824:
                if (this.maxHeight >= 0) {
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(this.maxHeight, size2), MeasureSpec.EXACTLY);
                    break;
                }
                break;
            default:
                if (!desiredAssertionStatus) {
                    throw new AssertionError();
                }
                break;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.resizeLayoutForSoftInput) {
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
                    super.onLayout(true, left, top, right, bottom + height);
                    return;
                }
            }
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f748e != null) {
            cj.m1764a(getContext()).m1774a(this.f748e);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f748e != null) {
            cj.m1764a(getContext()).m1777b(this.f748e);
        }
    }
}
