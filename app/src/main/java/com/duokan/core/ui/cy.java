package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.umeng.analytics.pro.C2295j;

class cy extends ViewGroup {
    /* renamed from: a */
    private boolean f1119a = false;

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1791a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1792a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m1793a(layoutParams);
    }

    public cy(Context context) {
        super(context);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dv.m1921a((View) this, new cz(this, z, i, i2, i3, i4));
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    public void forceLayout() {
        if (!this.f1119a) {
            super.forceLayout();
        }
    }

    public void requestLayout() {
        if (!this.f1119a) {
            super.requestLayout();
        }
    }

    /* renamed from: a */
    public da m1792a(AttributeSet attributeSet) {
        return new da(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected da m1791a() {
        return new da(-2, -2);
    }

    /* renamed from: a */
    protected da m1793a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new da((MarginLayoutParams) layoutParams) : new da(layoutParams);
    }

    /* renamed from: a */
    private void m1790a(boolean z, int i, int i2, int i3, int i4) {
        this.f1119a = true;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            int[] iArr;
            int i6;
            int max;
            C0374a c0374a = (C0374a) getChildAt(i5);
            da daVar = (da) c0374a.getLayoutParams();
            Rect rect = daVar.f1126a;
            View view = daVar.f1127b == null ? null : (View) daVar.f1127b.get();
            if (view != null) {
                rect.set(0, 0, view.getWidth(), view.getHeight());
                dv.m1937b(rect, view, (View) this);
            }
            switch (c0374a.getGravity()) {
                case 3:
                    iArr = new int[]{3, 5, 17};
                    break;
                case 5:
                    iArr = new int[]{5, 3, 17};
                    break;
                case C2295j.f14321a /*48*/:
                    iArr = new int[]{48, 80, 17};
                    break;
                case 80:
                    iArr = new int[]{80, 48, 17};
                    break;
                default:
                    iArr = new int[]{17};
                    break;
            }
            m1788a(c0374a, iArr);
            int paddingLeft = daVar.leftMargin + getPaddingLeft();
            int width = ((getWidth() - getPaddingRight()) - daVar.rightMargin) - c0374a.getMeasuredWidth();
            int paddingTop = daVar.topMargin + getPaddingTop();
            int height = ((getHeight() - getPaddingBottom()) - daVar.bottomMargin) - c0374a.getMeasuredHeight();
            int i7;
            switch (c0374a.getGravity()) {
                case 3:
                    i6 = rect.right + daVar.leftMargin;
                    max = Math.max(paddingTop, Math.min(((((rect.top + rect.bottom) - c0374a.getMeasuredHeight()) / 2) + daVar.topMargin) - daVar.bottomMargin, height));
                    break;
                case 5:
                    i6 = (rect.left - daVar.rightMargin) - c0374a.getMeasuredWidth();
                    max = Math.max(daVar.topMargin, Math.min(((((rect.top + rect.bottom) - c0374a.getMeasuredHeight()) / 2) + daVar.topMargin) - daVar.bottomMargin, height));
                    break;
                case C2295j.f14321a /*48*/:
                    i7 = rect.bottom + daVar.topMargin;
                    i6 = Math.max(paddingLeft, Math.min(((((rect.left + rect.right) - c0374a.getMeasuredWidth()) / 2) + daVar.leftMargin) - daVar.rightMargin, width));
                    max = i7;
                    break;
                case 80:
                    i7 = (rect.top - daVar.bottomMargin) - c0374a.getMeasuredHeight();
                    i6 = Math.max(daVar.leftMargin, Math.min(((((rect.left + rect.right) - c0374a.getMeasuredWidth()) / 2) + daVar.leftMargin) - daVar.rightMargin, width));
                    max = i7;
                    break;
                default:
                    i6 = ((((rect.left + rect.right) - c0374a.getMeasuredWidth()) / 2) + daVar.leftMargin) - daVar.rightMargin;
                    max = ((((rect.top + rect.bottom) - c0374a.getMeasuredHeight()) / 2) + daVar.topMargin) - daVar.bottomMargin;
                    break;
            }
            c0374a.layout(i6, max, c0374a.getMeasuredWidth() + i6, c0374a.getMeasuredHeight() + max);
            switch (c0374a.getGravity()) {
                case 3:
                case 5:
                    c0374a.m1375a(rect.centerY() - (c0374a.getIndicatorPosition().y + c0374a.getTop()));
                    break;
                case C2295j.f14321a /*48*/:
                case 80:
                    c0374a.m1375a(rect.centerX() - (c0374a.getIndicatorPosition().x + c0374a.getLeft()));
                    break;
                default:
                    break;
            }
            c0374a.invalidate();
        }
        this.f1119a = false;
    }

    /* renamed from: a */
    private void m1788a(C0374a c0374a, int[] iArr) {
        int i;
        int i2;
        da daVar = (da) c0374a.getLayoutParams();
        int[] iArr2 = new int[iArr.length];
        for (i = 0; i < iArr.length; i++) {
            iArr2[i] = m1787a(c0374a, iArr[i], iArr.length - i);
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
                i3 = daVar.f1126a.right;
                i2 = 0;
                break;
            case 5:
                i3 = getWidth() - daVar.f1126a.left;
                i2 = 0;
                break;
            case C2295j.f14321a /*48*/:
                i2 = daVar.f1126a.bottom;
                i3 = 0;
                break;
            case 80:
                i2 = getHeight() - daVar.f1126a.top;
                i3 = 0;
                break;
            default:
                i3 = getWidth() - daVar.f1126a.width();
                i2 = getHeight() - daVar.f1126a.height();
                break;
        }
        c0374a.setGravity(i);
        measureChildWithMargins(c0374a, MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), i3, MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE), i2);
    }

    /* renamed from: a */
    private int m1787a(C0374a c0374a, int i, int i2) {
        int width;
        da daVar = (da) c0374a.getLayoutParams();
        c0374a.setGravity(i);
        measureChildWithMargins(c0374a, MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE), 0);
        switch (i) {
            case 3:
                width = ((((getWidth() - daVar.f1126a.right) - getPaddingRight()) - daVar.leftMargin) - daVar.rightMargin) - c0374a.getMeasuredWidth();
                break;
            case 5:
                width = (((daVar.f1126a.left - getPaddingLeft()) - daVar.leftMargin) - daVar.rightMargin) - c0374a.getMeasuredWidth();
                break;
            case C2295j.f14321a /*48*/:
                width = ((((getHeight() - daVar.f1126a.bottom) - getPaddingBottom()) - daVar.topMargin) - daVar.bottomMargin) - c0374a.getMeasuredHeight();
                break;
            case 80:
                width = (((daVar.f1126a.top - getPaddingTop()) - daVar.topMargin) - daVar.bottomMargin) - c0374a.getMeasuredHeight();
                break;
            default:
                width = Math.min(((((daVar.f1126a.width() - getPaddingLeft()) - getPaddingRight()) - daVar.leftMargin) - daVar.rightMargin) - c0374a.getMeasuredWidth(), ((((daVar.f1126a.height() - getPaddingTop()) - getPaddingBottom()) - daVar.topMargin) - daVar.bottomMargin) - c0374a.getMeasuredHeight());
                break;
        }
        if (width >= 0) {
            return i2;
        }
        return width;
    }
}
