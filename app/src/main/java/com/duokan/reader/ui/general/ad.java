package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

class ad extends FrameLayout {
    /* renamed from: a */
    static final /* synthetic */ boolean f6915a = (!BubbleFloatingView.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ BubbleFloatingView f6916b;
    /* renamed from: c */
    private final ImageView f6917c;
    /* renamed from: d */
    private final ImageView f6918d;
    /* renamed from: e */
    private final ViewGroup f6919e;
    /* renamed from: f */
    private int f6920f = 0;
    /* renamed from: g */
    private int f6921g = 0;
    /* renamed from: h */
    private int f6922h = 0;
    /* renamed from: i */
    private int f6923i = 0;
    /* renamed from: j */
    private int f6924j = 0;
    /* renamed from: k */
    private int f6925k = Integer.MAX_VALUE;
    /* renamed from: l */
    private int f6926l = Integer.MAX_VALUE;
    /* renamed from: m */
    private boolean f6927m = true;

    public ad(BubbleFloatingView bubbleFloatingView, Context context) {
        this.f6916b = bubbleFloatingView;
        super(context, null);
        setClickable(true);
        this.f6919e = new FrameLayout(context);
        addView(this.f6919e, new LayoutParams(-2, -2));
        this.f6917c = new ImageView(context);
        addView(this.f6917c, new LayoutParams(-2, -2));
        this.f6918d = new ImageView(context);
        addView(this.f6918d, new LayoutParams(-2, -2));
    }

    /* renamed from: a */
    public void m10222a(boolean z) {
        this.f6927m = z;
    }

    /* renamed from: a */
    public void m10219a(int i) {
        this.f6924j = i;
    }

    /* renamed from: b */
    public void m10223b(int i) {
        if (i != 0) {
            this.f6917c.setImageResource(i);
        }
    }

    /* renamed from: c */
    public void m10224c(int i) {
        if (i != 0) {
            this.f6918d.setImageResource(i);
        }
    }

    /* renamed from: a */
    public View m10218a() {
        if (this.f6919e.getChildCount() == 1) {
            return this.f6919e.getChildAt(0);
        }
        return null;
    }

    /* renamed from: a */
    public void m10220a(int i, int i2, int i3, int i4) {
        this.f6920f = i;
        this.f6922h = i2;
        this.f6921g = i3;
        this.f6923i = i4;
    }

    /* renamed from: d */
    public void m10225d(int i) {
        if (i != 0) {
            this.f6919e.removeAllViews();
            LayoutInflater.from(getContext()).inflate(i, this.f6919e);
        }
    }

    /* renamed from: a */
    public void m10221a(View view, LayoutParams layoutParams) {
        if (f6915a || view != null) {
            ViewGroup.LayoutParams layoutParams2;
            this.f6919e.removeAllViews();
            if (layoutParams2 == null) {
                layoutParams2 = new LayoutParams(-2, -2);
            }
            this.f6919e.addView(view, layoutParams2);
            return;
        }
        throw new AssertionError();
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            m10216b();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m10216b();
    }

    protected void onMeasure(int i, int i2) {
        if (this.f6916b.f6770c == null || this.f6916b.f6770c.length <= 0) {
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
        measureChildWithMargins(this.f6917c, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0);
        measureChildWithMargins(this.f6919e, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0);
        measureChildWithMargins(this.f6918d, MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE), 0, MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), 0);
        setMeasuredDimension(Math.min(this.f6919e.getMeasuredWidth(), this.f6925k), Math.min(Math.max((this.f6917c.getMeasuredHeight() + this.f6919e.getMeasuredHeight()) - this.f6922h, (this.f6918d.getMeasuredHeight() + this.f6919e.getMeasuredHeight()) - this.f6923i), this.f6926l));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        if (this.f6927m) {
            this.f6917c.setVisibility(4);
            this.f6918d.setVisibility(0);
            measuredWidth = (this.f6924j - (this.f6918d.getMeasuredWidth() / 2)) - i;
            if (measuredWidth < this.f6920f) {
                measuredWidth = this.f6920f;
            }
            if (this.f6918d.getMeasuredWidth() + measuredWidth > (i3 - i) - this.f6921g) {
                measuredWidth = ((i3 - i) - this.f6921g) - this.f6918d.getMeasuredWidth();
            }
            this.f6918d.layout(measuredWidth, this.f6919e.getMeasuredHeight() - this.f6923i, this.f6918d.getMeasuredWidth() + measuredWidth, (this.f6919e.getMeasuredHeight() - this.f6923i) + this.f6918d.getMeasuredHeight());
            this.f6919e.measure(MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), MeasureSpec.makeMeasureSpec(this.f6919e.getMeasuredHeight(), 1073741824));
            this.f6919e.layout(0, 0, i3 - i, this.f6919e.getMeasuredHeight());
            return;
        }
        this.f6917c.setVisibility(0);
        this.f6918d.setVisibility(4);
        measuredWidth = (this.f6924j - (this.f6917c.getMeasuredWidth() / 2)) - i;
        if (measuredWidth < this.f6920f) {
            measuredWidth = this.f6920f;
        }
        if (this.f6917c.getMeasuredWidth() + measuredWidth > (i3 - i) - this.f6921g) {
            measuredWidth = ((i3 - i) - this.f6921g) - this.f6917c.getMeasuredWidth();
        }
        this.f6917c.layout(measuredWidth, 0, this.f6917c.getMeasuredWidth() + measuredWidth, this.f6917c.getMeasuredHeight());
        measuredWidth = this.f6917c.getMeasuredHeight() - this.f6922h;
        int measuredHeight = this.f6919e.getMeasuredHeight() + measuredWidth;
        this.f6919e.measure(MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight - measuredWidth, 1073741824));
        this.f6919e.layout(0, measuredWidth, i3 - i, measuredHeight);
    }

    /* renamed from: b */
    private final void m10216b() {
        getViewTreeObserver().addOnPreDrawListener(new ae(this));
    }
}
