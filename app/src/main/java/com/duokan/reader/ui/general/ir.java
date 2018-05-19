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

public class ir extends ViewGroup {
    /* renamed from: a */
    static final /* synthetic */ boolean f7398a = (!ir.class.desiredAssertionStatus());
    /* renamed from: b */
    private final FrameLayout f7399b;
    /* renamed from: c */
    private final ImageView f7400c;
    /* renamed from: d */
    private final ImageView f7401d;
    /* renamed from: e */
    private final LinearScrollView f7402e;
    /* renamed from: f */
    private final HorzLinearView f7403f;
    /* renamed from: g */
    private boolean f7404g = false;
    /* renamed from: h */
    private Drawable f7405h = null;
    /* renamed from: i */
    private Drawable f7406i = null;

    public ir(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7399b = new FrameLayout(context);
        this.f7400c = new ImageView(context);
        this.f7401d = new ImageView(context);
        this.f7402e = new LinearScrollView(context);
        this.f7403f = new HorzLinearView(context);
        this.f7402e.setThumbEnabled(false);
        this.f7400c.setOnClickListener(new is(this));
        this.f7401d.setOnClickListener(new it(this));
        this.f7402e.setOnScrollListener(new iu(this));
        addView(this.f7399b, new MarginLayoutParams(-2, -2));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f7399b.addView(this.f7400c, layoutParams);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f7399b.addView(this.f7401d, layoutParams);
        addView(this.f7402e, new MarginLayoutParams(-1, -2));
        this.f7402e.addView(this.f7403f);
        this.f7402e.setScrollInterpolator(new AccelerateDecelerateInterpolator());
    }

    /* renamed from: a */
    public void m10808a(int i, int i2, int i3, int i4) {
        this.f7400c.setPadding(i, i2, i3, i4);
        this.f7401d.setPadding(i, i2, i3, i4);
        requestLayout();
        invalidate();
    }

    public Drawable getScrollLeftDrawable() {
        return this.f7405h;
    }

    public void setScrollLeftResource(int i) {
        setScrollLeftDrawable(getResources().getDrawable(i));
    }

    public void setScrollLeftDrawable(Drawable drawable) {
        this.f7405h = drawable;
        this.f7400c.setImageDrawable(this.f7405h);
        requestLayout();
        invalidate();
    }

    public Drawable getScrollRightView() {
        return this.f7401d.getDrawable();
    }

    public void setScrollRightResource(int i) {
        setScrollRightDrawable(getResources().getDrawable(i));
    }

    public void setScrollRightDrawable(Drawable drawable) {
        this.f7406i = drawable;
        this.f7401d.setImageDrawable(this.f7406i);
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public boolean m10810a() {
        return this.f7404g;
    }

    public int getToolCount() {
        return this.f7403f.getChildCount();
    }

    /* renamed from: a */
    public View m10807a(int i) {
        return this.f7403f.getTabView(i);
    }

    /* renamed from: a */
    public void m10809a(View view) {
        this.f7403f.mo455a(view, new LinearLayout.LayoutParams(-2, -2, 1.0f));
        requestLayout();
        invalidate();
    }

    /* renamed from: b */
    public void m10811b() {
        if (this.f7402e.getScrollState() == ScrollState.IDLE && !this.f7402e.m1282c()) {
            Rect a = this.f7402e.m1276a();
            m10803b(a);
            this.f7402e.mo434a(a.left, a.top, HttpStatus.SC_OK, null, null);
        }
    }

    /* renamed from: c */
    public void m10812c() {
        if (this.f7402e.getScrollState() == ScrollState.IDLE && !this.f7402e.m1283d()) {
            Rect a = this.f7402e.m1276a();
            m10801a(a);
            this.f7402e.mo434a(a.left, a.top, HttpStatus.SC_OK, null, null);
        }
    }

    protected void onMeasure(int i, int i2) {
        this.f7403f.getLayoutParams().width = -2;
        this.f7403f.setGravity(17);
        if (this.f7403f.getChildCount() < 1) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        measureChildWithMargins(this.f7402e, i, 0, i2, 0);
        int contentWidth = this.f7402e.getContentWidth();
        int contentHeight = this.f7402e.getContentHeight();
        measureChildWithMargins(this.f7399b, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0);
        int measuredWidth = this.f7399b.getMeasuredWidth();
        int measuredHeight = this.f7399b.getMeasuredHeight();
        int measuredWidth2;
        int measuredWidth3;
        if (mode == Integer.MIN_VALUE) {
            if (this.f7402e.getMeasuredWidth() < contentWidth) {
                this.f7404g = true;
                measuredWidth2 = this.f7402e.getMeasuredWidth() - measuredWidth;
                i3 = 1;
                measuredWidth3 = this.f7403f.getChildAt(0).getMeasuredWidth();
                while (i3 < this.f7403f.getChildCount()) {
                    View childAt = this.f7403f.getChildAt(i3);
                    if (childAt.getMeasuredWidth() + measuredWidth3 > measuredWidth2) {
                        break;
                    }
                    i3++;
                    measuredWidth3 = childAt.getMeasuredWidth() + measuredWidth3;
                }
                measureChildWithMargins(this.f7402e, MeasureSpec.makeMeasureSpec((getPaddingLeft() + measuredWidth3) + getPaddingRight(), 1073741824), 0, i2, 0);
            } else {
                this.f7404g = false;
            }
        } else if (mode != 1073741824) {
            this.f7404g = false;
        } else if (this.f7402e.getMeasuredWidth() < contentWidth) {
            this.f7404g = true;
            measuredWidth2 = this.f7402e.getMeasuredWidth() - measuredWidth;
            measuredWidth3 = 0;
            i4 = 0;
            for (i3 = 0; i3 < this.f7403f.getChildCount(); i3++) {
                View childAt2 = this.f7403f.getChildAt(i3);
                if (childAt2.getMeasuredWidth() + i4 > measuredWidth2) {
                    break;
                }
                measuredWidth3++;
                i4 += childAt2.getMeasuredWidth();
            }
            if (measuredWidth3 > 0) {
                this.f7403f.getLayoutParams().width = ((int) Math.ceil((double) ((((float) (measuredWidth2 - i4)) / ((float) measuredWidth3)) * ((float) this.f7403f.getChildCount())))) + this.f7403f.getMeasuredWidth();
            }
            measureChildWithMargins(this.f7402e, MeasureSpec.makeMeasureSpec((getPaddingLeft() + measuredWidth2) + getPaddingRight(), 1073741824), 0, i2, 0);
        } else {
            this.f7404g = false;
        }
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i4 = (((this.f7404g ? measuredWidth : 0) + this.f7402e.getMeasuredWidth()) + getPaddingLeft()) + getPaddingRight();
        } else {
            i4 = size;
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            if (this.f7404g) {
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
        int measuredWidth = this.f7399b.getMeasuredWidth();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int measuredWidth2 = this.f7402e.getMeasuredWidth();
        int measuredHeight2 = this.f7402e.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        int i5 = ((i4 - i2) - measuredHeight2) / 2;
        this.f7402e.layout(paddingLeft, i5, paddingLeft + measuredWidth2, measuredHeight2 + i5);
        this.f7402e.scrollTo(0, 0);
        measuredWidth2 += paddingLeft;
        measuredHeight2 = ((i4 - i2) - measuredHeight) / 2;
        this.f7399b.layout(measuredWidth2, measuredHeight2, measuredWidth + measuredWidth2, measuredHeight + measuredHeight2);
        if (m10810a()) {
            this.f7400c.setVisibility(4);
            this.f7401d.setVisibility(0);
            return;
        }
        this.f7400c.setVisibility(4);
        this.f7401d.setVisibility(4);
    }

    /* renamed from: a */
    private void m10801a(Rect rect) {
        rect.offset(rect.width(), 0);
        if (rect.right < this.f7403f.getWidth()) {
            int c = m10804c(rect);
            if (f7398a || c >= 0) {
                View childAt = this.f7403f.getChildAt(c);
                if (childAt.getWidth() < rect.width()) {
                    rect.offsetTo(childAt.getLeft(), rect.top);
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
        rect.offsetTo(this.f7403f.getWidth() - rect.width(), rect.top);
    }

    /* renamed from: b */
    private void m10803b(Rect rect) {
        rect.offset(-rect.width(), 0);
        if (rect.left > 0) {
            int d = m10806d(rect);
            if (f7398a || d >= 0) {
                View childAt = this.f7403f.getChildAt(d);
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

    /* renamed from: c */
    private int m10804c(Rect rect) {
        for (int i = 0; i < this.f7403f.getChildCount(); i++) {
            View childAt = this.f7403f.getChildAt(i);
            Rect rect2 = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: d */
    private int m10806d(Rect rect) {
        int i = -1;
        for (int i2 = 0; i2 < this.f7403f.getChildCount(); i2++) {
            View childAt = this.f7403f.getChildAt(i2);
            Rect rect2 = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom)) {
                i = i2;
            }
        }
        return i;
    }
}
