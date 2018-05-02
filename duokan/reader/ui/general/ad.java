package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

class ad extends FrameLayout {
    static final /* synthetic */ boolean a = (!BubbleFloatingView.class.desiredAssertionStatus());
    final /* synthetic */ BubbleFloatingView b;
    private final ImageView c;
    private final ImageView d;
    private final ViewGroup e;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = Integer.MAX_VALUE;
    private int l = Integer.MAX_VALUE;
    private boolean m = true;

    public ad(BubbleFloatingView bubbleFloatingView, Context context) {
        this.b = bubbleFloatingView;
        super(context, null);
        setClickable(true);
        this.e = new FrameLayout(context);
        addView(this.e, new LayoutParams(-2, -2));
        this.c = new ImageView(context);
        addView(this.c, new LayoutParams(-2, -2));
        this.d = new ImageView(context);
        addView(this.d, new LayoutParams(-2, -2));
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(int i) {
        this.j = i;
    }

    public void b(int i) {
        if (i != 0) {
            this.c.setImageResource(i);
        }
    }

    public void c(int i) {
        if (i != 0) {
            this.d.setImageResource(i);
        }
    }

    public View a() {
        if (this.e.getChildCount() == 1) {
            return this.e.getChildAt(0);
        }
        return null;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f = i;
        this.h = i2;
        this.g = i3;
        this.i = i4;
    }

    public void d(int i) {
        if (i != 0) {
            this.e.removeAllViews();
            LayoutInflater.from(getContext()).inflate(i, this.e);
        }
    }

    public void a(View view, LayoutParams layoutParams) {
        if (a || view != null) {
            this.e.removeAllViews();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-2, -2);
            }
            this.e.addView(view, layoutParams);
            return;
        }
        throw new AssertionError();
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            b();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    protected void onMeasure(int i, int i2) {
        if (this.b.c == null || this.b.c.length <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int size;
        int size2 = MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) : Integer.MAX_VALUE;
        if (MeasureSpec.getMode(i2) != 0) {
            size = MeasureSpec.getSize(i2);
        } else {
            size = Integer.MAX_VALUE;
        }
        measureChildWithMargins(this.c, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0);
        measureChildWithMargins(this.e, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0);
        measureChildWithMargins(this.d, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0);
        setMeasuredDimension(Math.min(this.e.getMeasuredWidth(), this.k), Math.min(Math.max((this.c.getMeasuredHeight() + this.e.getMeasuredHeight()) - this.h, (this.d.getMeasuredHeight() + this.e.getMeasuredHeight()) - this.i), this.l));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        if (this.m) {
            this.c.setVisibility(4);
            this.d.setVisibility(0);
            measuredWidth = (this.j - (this.d.getMeasuredWidth() / 2)) - i;
            if (measuredWidth < this.f) {
                measuredWidth = this.f;
            }
            if (this.d.getMeasuredWidth() + measuredWidth > (i3 - i) - this.g) {
                measuredWidth = ((i3 - i) - this.g) - this.d.getMeasuredWidth();
            }
            this.d.layout(measuredWidth, this.e.getMeasuredHeight() - this.i, this.d.getMeasuredWidth() + measuredWidth, (this.e.getMeasuredHeight() - this.i) + this.d.getMeasuredHeight());
            this.e.measure(MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), MeasureSpec.makeMeasureSpec(this.e.getMeasuredHeight(), 1073741824));
            this.e.layout(0, 0, i3 - i, this.e.getMeasuredHeight());
            return;
        }
        this.c.setVisibility(0);
        this.d.setVisibility(4);
        measuredWidth = (this.j - (this.c.getMeasuredWidth() / 2)) - i;
        if (measuredWidth < this.f) {
            measuredWidth = this.f;
        }
        if (this.c.getMeasuredWidth() + measuredWidth > (i3 - i) - this.g) {
            measuredWidth = ((i3 - i) - this.g) - this.c.getMeasuredWidth();
        }
        this.c.layout(measuredWidth, 0, this.c.getMeasuredWidth() + measuredWidth, this.c.getMeasuredHeight());
        measuredWidth = this.c.getMeasuredHeight() - this.h;
        int measuredHeight = this.e.getMeasuredHeight() + measuredWidth;
        this.e.measure(MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight - measuredWidth, 1073741824));
        this.e.layout(0, measuredWidth, i3 - i, measuredHeight);
    }

    private final void b() {
        getViewTreeObserver().addOnPreDrawListener(new ae(this));
    }
}
