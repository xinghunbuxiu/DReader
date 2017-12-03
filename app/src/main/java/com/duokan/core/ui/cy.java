package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

class cy extends ViewGroup {
    private boolean a = false;

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public cy(Context context) {
        super(context);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        UTools.addAnimation((View) this, new cz(this, z, i, i2, i3, i4));
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    public void forceLayout() {
        if (!this.a) {
            super.forceLayout();
        }
    }

    public void requestLayout() {
        if (!this.a) {
            super.requestLayout();
        }
    }

    public da a(AttributeSet attributeSet) {
        return new da(getContext(), attributeSet);
    }

    protected da a() {
        return new da(-2, -2);
    }

    protected da a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new da((MarginLayoutParams) layoutParams) : new da(layoutParams);
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        this.a = true;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            int[] iArr;
            int i6;
            int max;
            a aVar = (a) getChildAt(i5);
            da daVar = (da) aVar.getLayoutParams();
            Rect rect = daVar.a;
            View view = daVar.b == null ? null : (View) daVar.b.get();
            if (view != null) {
                rect.set(0, 0, view.getWidth(), view.getHeight());
                UTools.closeAnimation(rect, view, (View) this);
            }
            switch (aVar.getGravity()) {
                case 3:
                    iArr = new int[]{3, 5, 17};
                    break;
                case 5:
                    iArr = new int[]{5, 3, 17};
                    break;
                case j.a /*48*/:
                    iArr = new int[]{48, 80, 17};
                    break;
                case 80:
                    iArr = new int[]{80, 48, 17};
                    break;
                default:
                    iArr = new int[]{17};
                    break;
            }
            a(aVar, iArr);
            int paddingLeft = daVar.leftMargin + getPaddingLeft();
            int width = ((getWidth() - getPaddingRight()) - daVar.rightMargin) - aVar.getMeasuredWidth();
            int paddingTop = daVar.topMargin + getPaddingTop();
            int height = ((getHeight() - getPaddingBottom()) - daVar.bottomMargin) - aVar.getMeasuredHeight();
            int i7;
            switch (aVar.getGravity()) {
                case 3:
                    i6 = rect.right + daVar.leftMargin;
                    max = Math.max(paddingTop, Math.min(((((rect.top + rect.bottom) - aVar.getMeasuredHeight()) / 2) + daVar.topMargin) - daVar.bottomMargin, height));
                    break;
                case 5:
                    i6 = (rect.left - daVar.rightMargin) - aVar.getMeasuredWidth();
                    max = Math.max(daVar.topMargin, Math.min(((((rect.top + rect.bottom) - aVar.getMeasuredHeight()) / 2) + daVar.topMargin) - daVar.bottomMargin, height));
                    break;
                case j.a /*48*/:
                    i7 = rect.bottom + daVar.topMargin;
                    i6 = Math.max(paddingLeft, Math.min(((((rect.left + rect.right) - aVar.getMeasuredWidth()) / 2) + daVar.leftMargin) - daVar.rightMargin, width));
                    max = i7;
                    break;
                case 80:
                    i7 = (rect.top - daVar.bottomMargin) - aVar.getMeasuredHeight();
                    i6 = Math.max(daVar.leftMargin, Math.min(((((rect.left + rect.right) - aVar.getMeasuredWidth()) / 2) + daVar.leftMargin) - daVar.rightMargin, width));
                    max = i7;
                    break;
                default:
                    i6 = ((((rect.left + rect.right) - aVar.getMeasuredWidth()) / 2) + daVar.leftMargin) - daVar.rightMargin;
                    max = ((((rect.top + rect.bottom) - aVar.getMeasuredHeight()) / 2) + daVar.topMargin) - daVar.bottomMargin;
                    break;
            }
            aVar.layout(i6, max, aVar.getMeasuredWidth() + i6, aVar.getMeasuredHeight() + max);
            switch (aVar.getGravity()) {
                case 3:
                case 5:
                    aVar.a(rect.centerY() - (aVar.getIndicatorPosition().y + aVar.getTop()));
                    break;
                case j.a /*48*/:
                case 80:
                    aVar.a(rect.centerX() - (aVar.getIndicatorPosition().x + aVar.getLeft()));
                    break;
                default:
                    break;
            }
            aVar.invalidate();
        }
        this.a = false;
    }

    private void a(a aVar, int[] iArr) {
        int i;
        int i2;
        da daVar = (da) aVar.getLayoutParams();
        int[] iArr2 = new int[iArr.length];
        for (i = 0; i < iArr.length; i++) {
            iArr2[i] = a(aVar, iArr[i], iArr.length - i);
        }
        int i3 = 0;
        for (i = 0; i < iArr.length; i++) {
            if (iArr2[i] > iArr2[i3]) {
                i3 = i;
            }
        }
        i = iArr[i3];
        switch (i) {
            case 3:
                i3 = daVar.a.right;
                i2 = 0;
                break;
            case 5:
                i3 = getWidth() - daVar.a.left;
                i2 = 0;
                break;
            case j.a /*48*/:
                i2 = daVar.a.bottom;
                i3 = 0;
                break;
            case 80:
                i2 = getHeight() - daVar.a.top;
                i3 = 0;
                break;
            default:
                i3 = getWidth() - daVar.a.width();
                i2 = getHeight() - daVar.a.height();
                break;
        }
        aVar.setGravity(i);
        measureChildWithMargins(aVar, MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), i3, MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE), i2);
    }

    private int a(a aVar, int i, int i2) {
        int width;
        da daVar = (da) aVar.getLayoutParams();
        aVar.setGravity(i);
        measureChildWithMargins(aVar, MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE), 0);
        switch (i) {
            case 3:
                width = ((((getWidth() - daVar.a.right) - getPaddingRight()) - daVar.leftMargin) - daVar.rightMargin) - aVar.getMeasuredWidth();
                break;
            case 5:
                width = (((daVar.a.left - getPaddingLeft()) - daVar.leftMargin) - daVar.rightMargin) - aVar.getMeasuredWidth();
                break;
            case j.a /*48*/:
                width = ((((getHeight() - daVar.a.bottom) - getPaddingBottom()) - daVar.topMargin) - daVar.bottomMargin) - aVar.getMeasuredHeight();
                break;
            case 80:
                width = (((daVar.a.top - getPaddingTop()) - daVar.topMargin) - daVar.bottomMargin) - aVar.getMeasuredHeight();
                break;
            default:
                width = Math.min(((((daVar.a.width() - getPaddingLeft()) - getPaddingRight()) - daVar.leftMargin) - daVar.rightMargin) - aVar.getMeasuredWidth(), ((((daVar.a.height() - getPaddingTop()) - getPaddingBottom()) - daVar.topMargin) - daVar.bottomMargin) - aVar.getMeasuredHeight());
                break;
        }
        if (width >= 0) {
            return i2;
        }
        return width;
    }
}
