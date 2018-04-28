package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;

public class PinView extends FrameLayout {
    /* renamed from: a */
    static final /* synthetic */ boolean f6882a = (!PinView.class.desiredAssertionStatus());
    /* renamed from: b */
    private DkTextView f6883b;
    /* renamed from: c */
    private final Point f6884c;

    public PinView(Context context) {
        this(context, null);
    }

    public PinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundColor(0);
        setAddStatesFromChildren(true);
        this.f6883b = new DkTextView(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842901, 16842904, 16842923, 16842927, 16843087, 16843091});
        this.f6883b.setTextSize((float) obtainStyledAttributes.getDimensionPixelSize(0, 20));
        this.f6883b.setTextPixelSize(obtainStyledAttributes.getDimensionPixelSize(0, 20));
        this.f6883b.setTextColor(obtainStyledAttributes.getColor(1, -16777216));
        switch (obtainStyledAttributes.getInt(2, 2)) {
            case 1:
                this.f6883b.setEllipsize(TruncateAt.START);
                break;
            case 2:
                this.f6883b.setEllipsize(TruncateAt.MIDDLE);
                break;
            case 3:
                this.f6883b.setEllipsize(TruncateAt.END);
                break;
            case 4:
                if (!f6882a) {
                    throw new AssertionError();
                }
                break;
        }
        this.f6883b.setGravity(obtainStyledAttributes.getInteger(3, 3));
        this.f6883b.setText(obtainStyledAttributes.hasValue(4) ? obtainStyledAttributes.getString(4) : "");
        this.f6883b.setMaxLines(obtainStyledAttributes.hasValue(5) ? obtainStyledAttributes.getInt(5, Integer.MAX_VALUE) : Integer.MAX_VALUE);
        this.f6883b.setBackgroundResource(C0243e.general__shared__pin_view_bg);
        this.f6883b.setGravity(119);
        this.f6883b.setLineGap(1.2999999523162842d);
        this.f6883b.setPadding(dv.m1932b(context, 15.0f), dv.m1932b(context, 15.0f), dv.m1932b(context, 15.0f), dv.m1932b(context, 15.0f));
        this.f6884c = new Point(dv.m1932b(context, 4.0f), dv.m1932b(context, 7.5f));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = this.f6884c.x;
        layoutParams.topMargin = this.f6884c.y;
        layoutParams.gravity = 51;
        this.f6883b.setLayoutParams(layoutParams);
        addView(this.f6883b);
        View imageView = new ImageView(context);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageResource(C0243e.general__shared__pin);
        addView(imageView, new FrameLayout.LayoutParams(-2, -2));
    }

    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int measuredHeight;
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                measuredWidth = childAt == this.f6883b ? childAt.getMeasuredWidth() + this.f6884c.x : childAt.getMeasuredWidth();
                measuredHeight = childAt == this.f6883b ? childAt.getMeasuredHeight() + this.f6884c.y : childAt.getMeasuredHeight();
                measuredWidth = Math.max(i4, measuredWidth);
                measuredHeight = Math.max(i5, measuredHeight);
            } else {
                measuredWidth = i4;
                measuredHeight = i5;
            }
            i3++;
            i4 = measuredWidth;
            i5 = measuredHeight;
        }
        measuredWidth = (getPaddingLeft() + getPaddingRight()) + i4;
        measuredHeight = Math.max((getPaddingTop() + getPaddingBottom()) + i5, getSuggestedMinimumHeight());
        measuredWidth = Math.max(measuredWidth, getSuggestedMinimumWidth());
        Drawable foreground = getForeground();
        if (foreground != null) {
            measuredHeight = Math.max(measuredHeight, foreground.getMinimumHeight());
            measuredWidth = Math.max(measuredWidth, foreground.getMinimumWidth());
        }
        setMeasuredDimension(resolveSize(measuredWidth, i), resolveSize(measuredHeight, i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        for (int i5 = 0; i5 < childCount; i5++) {
            int i6;
            int i7;
            View childAt = getChildAt(i5);
            if (childAt == this.f6883b) {
                i6 = this.f6884c.x + paddingLeft;
            } else {
                i6 = paddingLeft;
            }
            if (childAt == this.f6883b) {
                i7 = this.f6884c.y + paddingTop;
            } else {
                i7 = paddingTop;
            }
            if (childAt.getVisibility() != 8) {
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    public void setText(String str) {
        this.f6883b.setText(str);
    }

    public void setText(int i) {
        this.f6883b.setText(getResources().getString(i));
    }

    public void setTextColor(int i) {
        this.f6883b.setTextColor(i);
    }

    public void setMaxLines(int i) {
        this.f6883b.setMaxLines(i);
    }

    public void setTextSize(int i) {
        this.f6883b.setTextSize((float) i);
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.f6883b.setEllipsize(truncateAt);
    }
}
