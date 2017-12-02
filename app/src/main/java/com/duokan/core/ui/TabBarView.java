package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class TabBarView extends FrameLayout {
    private Drawable a;
    private int b;
    private int c;
    private TranslateAnimation d;
    private TranslateAnimation e;
    private final bt f;
    private int g;
    private int h;
    private int i;
    private cs j;
    private Transformation k;
    private Rect l;
    private boolean m;

    public TabBarView(Context context) {
        this(context, null);
    }

    public TabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = -1;
        this.c = -1;
        this.d = null;
        this.e = null;
        this.g = 0;
        this.h = 0;
        this.i = 23;
        this.j = null;
        this.k = new Transformation();
        this.l = new Rect(0, 0, 0, 0);
        this.m = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948});
        CharSequence string = obtainStyledAttributes.hasValue(0) ? obtainStyledAttributes.getString(0) : "horizontal";
        obtainStyledAttributes.recycle();
        if (TextUtils.equals(string, "horizontal")) {
            this.f = new HorzLinearView(context);
        } else {
            this.f = new eq(context);
        }
        addView(this.f, new LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public TabBarView(Context context, int i) {
        super(context);
        this.a = null;
        this.b = -1;
        this.c = -1;
        this.d = null;
        this.e = null;
        this.g = 0;
        this.h = 0;
        this.i = 23;
        this.j = null;
        this.k = new Transformation();
        this.l = new Rect(0, 0, 0, 0);
        this.m = true;
        if (i == 1) {
            this.f = new eq(context);
        } else {
            this.f = new HorzLinearView(context);
        }
        addView(this.f, new LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public int getSelectedTabIndex() {
        return this.b;
    }

    public int getTabCount() {
        return this.f.getCellCount();
    }

    public void setIndicatorGravity(int i) {
        this.i = i;
        invalidate();
    }

    public ScaleType getDividerScaleType() {
        return this.f.getDividerScaleType();
    }

    public void setDividerScaleType(ScaleType scaleType) {
        this.f.setDividerScaleType(scaleType);
        requestLayout();
        invalidate();
    }

    public Drawable getFirstDividerDrawable() {
        return this.f.getFirstDivider();
    }

    public void setFirstDividerDrawable(int i) {
        setFirstDividerDrawable(getResources().getDrawable(i));
    }

    public void setFirstDividerDrawable(Drawable drawable) {
        this.f.setFirstDivider(drawable);
        requestLayout();
        invalidate();
    }

    public Drawable getMiddleDividerDrawable() {
        return this.f.getMiddleDivider();
    }

    public void setMiddleDividerDrawable(int i) {
        setMiddleDividerDrawable(getResources().getDrawable(i));
    }

    public void setMiddleDividerDrawable(Drawable drawable) {
        this.f.setMiddleDivider(drawable);
        requestLayout();
        invalidate();
    }

    public Drawable getLastDividerDrawable() {
        return this.f.getLastDivider();
    }

    public void setLastDividerDrawable(int i) {
        setLastDividerDrawable(getResources().getDrawable(i));
    }

    public void setLastDividerDrawable(Drawable drawable) {
        this.f.setLastDivider(drawable);
        requestLayout();
        invalidate();
    }

    public void setIgnoreRepeatedClicks(boolean z) {
        this.m = z;
    }

    public int a(int i) {
        int i2 = this.b;
        a(i, false);
        return i2;
    }

    public View b(int i) {
        return e(i).getChildAt(0);
    }

    public View c(int i) {
        ViewGroup a = a();
        LayoutInflater.from(getContext()).inflate(i, a, true);
        if (this.f.getChildCount() == 1) {
            a(0, false);
        }
        return a.getChildAt(0);
    }

    public int a(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LayoutParams(-1, -1));
        }
        a().addView(view);
        if (this.f.getChildCount() == 1) {
            a(0, false);
        }
        return this.f.getChildCount() - 1;
    }

    public void setIndicatorDrawable(int i) {
        setIndicatorDrawable(getResources().getDrawable(i));
    }

    public void setIndicatorDrawable(Drawable drawable) {
        this.a = drawable;
        invalidate();
    }

    public void setSelectionChangeListener(cs csVar) {
        this.j = csVar;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a != null && this.b >= 0) {
            b();
            c();
            a(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.a != null) {
            a(null, false);
        }
    }

    public void setTabEnabled(boolean z) {
        for (int i = 0; i < this.f.getCellCount(); i++) {
            this.f.a(i).setEnabled(z);
        }
    }

    private void a(int i, boolean z) {
        if (this.b != i || !this.m) {
            FrameLayout e;
            this.c = this.b;
            if (this.b >= 0) {
                e = e(this.b);
                e.setSelected(false);
                e.getChildAt(0).setSelected(false);
            }
            e = null;
            if (i >= 0) {
                e = e(i);
                this.b = i;
            }
            a(e, z);
            if (this.j != null) {
                this.j.a(this.c, this.b, z);
            }
        }
    }

    private void a(FrameLayout frameLayout, boolean z) {
        if (this.b < 0) {
            this.d = null;
            this.e = null;
            setIndicatorCenter(0);
            setIndicatorWidth(0);
            invalidate();
        } else if (this.a == null || getVisibility() != 0) {
            if (frameLayout != null) {
                frameLayout.setSelected(true);
                frameLayout.getChildAt(0).setSelected(true);
            }
            post(new cn(this, z));
        } else {
            Rect selectedTabRect = getSelectedTabRect();
            if (!c(selectedTabRect)) {
                if (this.f instanceof eq) {
                    this.d = new TranslateAnimation(0.0f, 0.0f, (float) getIndicatorCenter(), (float) a(selectedTabRect));
                    this.e = new TranslateAnimation(0.0f, 0.0f, (float) getIndicatorWidth(), (float) b(selectedTabRect));
                } else {
                    this.d = new TranslateAnimation((float) getIndicatorCenter(), (float) a(selectedTabRect), 0.0f, 0.0f);
                    this.e = new TranslateAnimation((float) getIndicatorWidth(), (float) b(selectedTabRect), 0.0f, 0.0f);
                }
                this.d.initialize(selectedTabRect.width(), selectedTabRect.height(), getWidth(), getHeight());
                this.d.setDuration(200);
                this.d.setFillAfter(true);
                this.d.setFillEnabled(true);
                this.d.setInterpolator(new AccelerateDecelerateInterpolator());
                this.e.initialize(selectedTabRect.width(), selectedTabRect.height(), getWidth(), getHeight());
                this.e.setDuration(200);
                this.e.setFillAfter(true);
                this.e.setFillEnabled(true);
                this.e.setInterpolator(new AccelerateDecelerateInterpolator());
                this.e.setAnimationListener(new co(this, frameLayout, z));
                invalidate();
            } else if (frameLayout != null) {
                frameLayout.setSelected(true);
                frameLayout.getChildAt(0).setSelected(true);
            }
        }
    }

    private Rect getSelectedTabRect() {
        if (this.b < 0) {
            return new Rect(0, 0, 0, 0);
        }
        Rect rect = new Rect();
        dv.a(new RectF(), b(this.b), (View) this).round(rect);
        return rect;
    }

    private int a(Rect rect) {
        if (this.f instanceof eq) {
            return rect.centerY();
        }
        return rect.centerX();
    }

    private FrameLayout a() {
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setOnClickListener(new cq(this));
        frameLayout.setOnTouchListener(new cr(this));
        this.f.a(frameLayout, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        return frameLayout;
    }

    private int a(FrameLayout frameLayout) {
        for (int i = 0; i < this.f.getCellCount(); i++) {
            if (this.f.a(i) == frameLayout) {
                return i;
            }
        }
        return -1;
    }

    private FrameLayout e(int i) {
        return (FrameLayout) this.f.a(i);
    }

    protected void d(int i) {
        setIndicatorCenter(i);
        invalidate();
    }

    private int getIndicatorCenter() {
        return this.g;
    }

    private void setIndicatorCenter(int i) {
        this.g = i;
    }

    private int getIndicatorWidth() {
        return this.h;
    }

    private void setIndicatorWidth(int i) {
        this.h = i;
    }

    private void b() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.d != null && !this.d.hasEnded()) {
            if (!this.d.hasStarted()) {
                this.d.setStartTime(currentAnimationTimeMillis);
            }
            float[] fArr = new float[]{0.0f, 0.0f};
            this.d.getTransformation(currentAnimationTimeMillis, this.k);
            this.k.getMatrix().mapPoints(fArr);
            if (this.f instanceof eq) {
                this.g = Math.round(fArr[1]);
            } else {
                this.g = Math.round(fArr[0]);
            }
            invalidate();
        }
    }

    private void c() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.e != null && !this.e.hasEnded()) {
            if (!this.e.hasStarted()) {
                this.e.setStartTime(currentAnimationTimeMillis);
            }
            float[] fArr = new float[]{0.0f, 0.0f};
            this.e.getTransformation(currentAnimationTimeMillis, this.k);
            this.k.getMatrix().mapPoints(fArr);
            if (this.f instanceof eq) {
                this.h = Math.round(fArr[1]);
            } else {
                this.h = Math.round(fArr[0]);
            }
            invalidate();
        }
    }

    private void a(Canvas canvas) {
        canvas.save();
        if (this.f instanceof eq) {
            this.l.set(0, this.g - (this.h / 2), getWidth(), this.g + ((this.h + 1) / 2));
        } else {
            this.l.set(this.g - (this.h / 2), 0, this.g + ((this.h + 1) / 2), getHeight());
        }
        dv.a(canvas, this.a, this.l, this.i);
        canvas.restore();
    }

    private int b(Rect rect) {
        if (this.f instanceof eq) {
            return rect.height();
        }
        return rect.width();
    }

    private boolean c(Rect rect) {
        if (this.f instanceof eq) {
            if (this.g == rect.centerY() && this.h == rect.height()) {
                return true;
            }
            return false;
        } else if (this.g == rect.centerX() && this.h == rect.width()) {
            return true;
        } else {
            return false;
        }
    }
}
