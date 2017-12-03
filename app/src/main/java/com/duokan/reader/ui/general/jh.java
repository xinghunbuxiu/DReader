package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.duokan.core.ui.HorzLinearView;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.Scrollable.ScrollState;

import org.apache.http.HttpStatus;

public class jh extends ViewGroup {
    static final /* synthetic */ boolean a = (!jh.class.desiredAssertionStatus());
    private final FrameLayout b;
    private final ImageView c;
    private final ImageView d;
    private final LinearScrollView e;
    private final HorzLinearView f;
    private boolean g = false;
    private Drawable h = null;
    private Drawable i = null;

    public jh(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new FrameLayout(context);
        this.c = new ImageView(context);
        this.d = new ImageView(context);
        this.e = new LinearScrollView(context);
        this.f = new HorzLinearView(context);
        this.e.setThumbEnabled(false);
        this.c.setOnClickListener(new ji(this));
        this.d.setOnClickListener(new jj(this));
        this.e.setOnScrollListener(new jk(this));
        addView(this.b, new MarginLayoutParams(-2, -2));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.b.addView(this.c, layoutParams);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.b.addView(this.d, layoutParams);
        addView(this.e, new MarginLayoutParams(-1, -2));
        this.e.addView(this.f);
        this.e.setScrollInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void a(int i, int i2, int i3, int i4) {
        this.c.setPadding(i, i2, i3, i4);
        this.d.setPadding(i, i2, i3, i4);
        requestLayout();
        invalidate();
    }

    public Drawable getScrollLeftDrawable() {
        return this.h;
    }

    public void setScrollLeftResource(int i) {
        setScrollLeftDrawable(getResources().getDrawable(i));
    }

    public void setScrollLeftDrawable(Drawable drawable) {
        this.h = drawable;
        this.c.setImageDrawable(this.h);
        requestLayout();
        invalidate();
    }

    public Drawable getScrollRightView() {
        return this.d.getDrawable();
    }

    public void setScrollRightResource(int i) {
        setScrollRightDrawable(getResources().getDrawable(i));
    }

    public void setScrollRightDrawable(Drawable drawable) {
        this.i = drawable;
        this.d.setImageDrawable(this.i);
        requestLayout();
        invalidate();
    }

    public boolean a() {
        return this.g;
    }

    public int getToolCount() {
        return this.f.getChildCount();
    }

    public View a(int i) {
        return this.f.a(i);
    }

    public void a(View view) {
        this.f.a(view, new LinearLayout.LayoutParams(-2, -2, 1.0f));
        requestLayout();
        invalidate();
    }

    public void b() {
        if (this.e.getScrollState() == ScrollState.IDLE && !this.e.c()) {
            Rect a = this.e.a();
            b(a);
            this.e.a(a.left, a.top, HttpStatus.SC_OK, null, null);
        }
    }

    public void c() {
        if (this.e.getScrollState() == ScrollState.IDLE && !this.e.d()) {
            Rect a = this.e.a();
            a(a);
            this.e.a(a.left, a.top, HttpStatus.SC_OK, null, null);
        }
    }

    protected void onMeasure(int i, int i2) {
        this.f.getLayoutParams().width = -2;
        this.f.setGravity(17);
        if (this.f.getChildCount() < 1) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        measureChildWithMargins(this.e, i, 0, i2, 0);
        int contentWidth = this.e.getContentWidth();
        int contentHeight = this.e.getContentHeight();
        measureChildWithMargins(this.b, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0);
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredHeight = this.b.getMeasuredHeight();
        int measuredWidth2;
        int measuredWidth3;
        if (mode == Integer.MIN_VALUE) {
            if (this.e.getMeasuredWidth() < contentWidth) {
                this.g = true;
                measuredWidth2 = this.e.getMeasuredWidth() - measuredWidth;
                i3 = 1;
                measuredWidth3 = this.f.getChildAt(0).getMeasuredWidth();
                while (i3 < this.f.getChildCount()) {
                    View childAt = this.f.getChildAt(i3);
                    if (childAt.getMeasuredWidth() + measuredWidth3 > measuredWidth2) {
                        break;
                    }
                    i3++;
                    measuredWidth3 = childAt.getMeasuredWidth() + measuredWidth3;
                }
                measureChildWithMargins(this.e, MeasureSpec.makeMeasureSpec((getPaddingLeft() + measuredWidth3) + getPaddingRight(), 1073741824), 0, i2, 0);
            } else {
                this.g = false;
            }
        } else if (mode != 1073741824) {
            this.g = false;
        } else if (this.e.getMeasuredWidth() < contentWidth) {
            this.g = true;
            measuredWidth2 = this.e.getMeasuredWidth() - measuredWidth;
            measuredWidth3 = 0;
            i4 = 0;
            for (i3 = 0; i3 < this.f.getChildCount(); i3++) {
                View childAt2 = this.f.getChildAt(i3);
                if (childAt2.getMeasuredWidth() + i4 > measuredWidth2) {
                    break;
                }
                measuredWidth3++;
                i4 += childAt2.getMeasuredWidth();
            }
            if (measuredWidth3 > 0) {
                this.f.getLayoutParams().width = ((int) Math.ceil((double) ((((float) (measuredWidth2 - i4)) / ((float) measuredWidth3)) * ((float) this.f.getChildCount())))) + this.f.getMeasuredWidth();
            }
            measureChildWithMargins(this.e, MeasureSpec.makeMeasureSpec((getPaddingLeft() + measuredWidth2) + getPaddingRight(), 1073741824), 0, i2, 0);
        } else {
            this.g = false;
        }
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i4 = (((this.g ? measuredWidth : 0) + this.e.getMeasuredWidth()) + getPaddingLeft()) + getPaddingRight();
        } else {
            i4 = size;
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            if (this.g) {
                i3 = Math.max(contentHeight, measuredHeight);
            } else {
                i3 = contentHeight;
            }
            i3 = (i3 + getPaddingTop()) + getPaddingBottom();
        } else {
            i3 = size2;
        }
        setMeasuredDimension(i4, i3);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int measuredWidth2 = this.e.getMeasuredWidth();
        int measuredHeight2 = this.e.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        int i5 = ((i4 - i2) - measuredHeight2) / 2;
        this.e.layout(paddingLeft, i5, paddingLeft + measuredWidth2, measuredHeight2 + i5);
        this.e.scrollTo(0, 0);
        measuredWidth2 += paddingLeft;
        measuredHeight2 = ((i4 - i2) - measuredHeight) / 2;
        this.b.layout(measuredWidth2, measuredHeight2, measuredWidth + measuredWidth2, measuredHeight + measuredHeight2);
        if (a()) {
            this.c.setVisibility(4);
            this.d.setVisibility(0);
            return;
        }
        this.c.setVisibility(4);
        this.d.setVisibility(4);
    }

    private void a(Rect rect) {
        rect.offset(rect.width(), 0);
        if (rect.right < this.f.getWidth()) {
            int c = c(rect);
            if (a || c >= 0) {
                View childAt = this.f.getChildAt(c);
                if (childAt.getWidth() < rect.width()) {
                    rect.offsetTo(childAt.getLeft(), rect.top);
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
        rect.offsetTo(this.f.getWidth() - rect.width(), rect.top);
    }

    private void b(Rect rect) {
        rect.offset(-rect.width(), 0);
        if (rect.left > 0) {
            int d = d(rect);
            if (a || d >= 0) {
                View childAt = this.f.getChildAt(d);
                if (childAt.getWidth() < rect.width()) {
                    rect.offsetTo(childAt.getRight() - rect.width(), rect.top);
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
        rect.offsetTo(0, rect.top);
    }

    private int c(Rect rect) {
        for (int i = 0; i < this.f.getChildCount(); i++) {
            View childAt = this.f.getChildAt(i);
            Rect rect2 = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom)) {
                return i;
            }
        }
        return -1;
    }

    private int d(Rect rect) {
        int i = -1;
        for (int i2 = 0; i2 < this.f.getChildCount(); i2++) {
            View childAt = this.f.getChildAt(i2);
            Rect rect2 = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom)) {
                i = i2;
            }
        }
        return i;
    }
}
