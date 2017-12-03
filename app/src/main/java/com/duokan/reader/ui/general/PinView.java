package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.duokan.b.e;
import com.duokan.core.ui.UTools;

public class PinView extends FrameLayout {
    static final /* synthetic */ boolean a = (!PinView.class.desiredAssertionStatus());
    private deprecatedDkTextView b;
    private final Point c;

    public PinView(Context context) {
        this(context, null);
    }

    public PinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundColor(0);
        setAddStatesFromChildren(true);
        this.b = new deprecatedDkTextView(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842901, 16842904, 16842923, 16842927, 16843087, 16843091});
        this.b.setTextSize(obtainStyledAttributes.getDimensionPixelSize(0, 20));
        this.b.setTextColor(obtainStyledAttributes.getColor(1, -16777216));
        switch (obtainStyledAttributes.getInt(2, 2)) {
            case 1:
                this.b.setEllipsize(TruncateAt.START);
                break;
            case 2:
                this.b.setEllipsize(TruncateAt.MIDDLE);
                break;
            case 3:
                this.b.setEllipsize(TruncateAt.END);
                break;
            case 4:
                if (!a) {
                    throw new AssertionError();
                }
                break;
        }
        this.b.setGravity(obtainStyledAttributes.getInteger(3, 3));
        this.b.setText(obtainStyledAttributes.hasValue(4) ? obtainStyledAttributes.getString(4) : "");
        this.b.setMaxLines(obtainStyledAttributes.hasValue(5) ? obtainStyledAttributes.getInt(5, Integer.MAX_VALUE) : Integer.MAX_VALUE);
        this.b.setBackgroundResource(e.general__shared__pin_view_bg);
        this.b.setGravity(119);
        this.b.setLineGap(1.2999999523162842d);
        this.b.setPadding(UTools.closeAnimation(context, 15.0f), UTools.closeAnimation(context, 15.0f), UTools.closeAnimation(context, 15.0f), UTools.closeAnimation(context, 15.0f));
        this.c = new Point(UTools.closeAnimation(context, 4.0f), UTools.closeAnimation(context, 7.5f));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = this.c.x;
        layoutParams.topMargin = this.c.y;
        layoutParams.gravity = 51;
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
        View imageView = new ImageView(context);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageResource(e.general__shared__pin);
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
                measuredWidth = childAt == this.b ? childAt.getMeasuredWidth() + this.c.x : childAt.getMeasuredWidth();
                measuredHeight = childAt == this.b ? childAt.getMeasuredHeight() + this.c.y : childAt.getMeasuredHeight();
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
            if (childAt == this.b) {
                i6 = this.c.x + paddingLeft;
            } else {
                i6 = paddingLeft;
            }
            if (childAt == this.b) {
                i7 = this.c.y + paddingTop;
            } else {
                i7 = paddingTop;
            }
            if (childAt.getVisibility() != 8) {
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    public void setText(String str) {
        this.b.setText(str);
    }

    public void setUseBitmapCache(boolean z) {
        this.b.setUseBitmapCache(z);
    }

    public void setUsePartialDraw(boolean z) {
        this.b.setUsePartialDraw(z);
    }

    public void setText(int i) {
        this.b.setText(getResources().getString(i));
    }

    public void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setMaxLines(int i) {
        this.b.setMaxLines(i);
    }

    public void setTextSize(int i) {
        this.b.setTextSize(i);
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.b.setEllipsize(truncateAt);
    }
}
