package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class BoxView extends FrameLayout {
    static final /* synthetic */ boolean a = (!BoxView.class.desiredAssertionStatus());
    private int b;
    private int c;
    private boolean d;
    private cm e;

    public BoxView(Context context) {
        this(context, null);
    }

    public BoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.c = -1;
        this.d = false;
        this.e = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843039, 16843040});
        this.b = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.c = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        obtainStyledAttributes.recycle();
    }

    public void setMaxWidth(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }

    public boolean getResizeLayoutForSoftInput() {
        return this.d;
    }

    public void setResizeLayoutForSoftInput(boolean z) {
        if (this.d != z) {
            this.d = z;
            cj a = cj.a(getContext());
            if (this.d) {
                if (this.e == null) {
                    this.e = new e(this);
                    a.a(this.e);
                }
            } else if (this.e != null) {
                a.b(this.e);
                this.e = null;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                if (this.b >= 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(this.b, size), Integer.MIN_VALUE);
                    break;
                }
                break;
            case 0:
                if (this.b >= 0) {
                    i = MeasureSpec.makeMeasureSpec(this.b, Integer.MIN_VALUE);
                    break;
                }
                break;
            case 1073741824:
                if (this.b >= 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(this.b, size), 1073741824);
                    break;
                }
                break;
            default:
                if (!a) {
                    throw new AssertionError();
                }
                break;
        }
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                if (this.c >= 0) {
                    i2 = MeasureSpec.makeMeasureSpec(Math.min(this.c, size2), Integer.MIN_VALUE);
                    break;
                }
                break;
            case 0:
                if (this.c >= 0) {
                    i2 = MeasureSpec.makeMeasureSpec(this.c, Integer.MIN_VALUE);
                    break;
                }
                break;
            case 1073741824:
                if (this.c >= 0) {
                    i2 = MeasureSpec.makeMeasureSpec(Math.min(this.c, size2), 1073741824);
                    break;
                }
                break;
            default:
                if (!a) {
                    throw new AssertionError();
                }
                break;
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d) {
            cj a = cj.a(getContext());
            if (a.a()) {
                Rect rect = (Rect) UTools.g.getRect();
                UTools.getRect(rect, (View) this, null);
                int max = Math.max(0, rect.bottom - a.b().top);
                UTools.g.getRect(rect);
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
        if (this.e != null) {
            cj.a(getContext()).a(this.e);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.e != null) {
            cj.a(getContext()).b(this.e);
        }
    }
}
