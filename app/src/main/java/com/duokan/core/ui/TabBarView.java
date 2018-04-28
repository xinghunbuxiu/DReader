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
    /* renamed from: a */
    private Drawable f856a;
    /* renamed from: b */
    private int f857b;
    /* renamed from: c */
    private int f858c;
    /* renamed from: d */
    private TranslateAnimation f859d;
    /* renamed from: e */
    private TranslateAnimation f860e;
    /* renamed from: f */
    private final bt f861f;
    /* renamed from: g */
    private int f862g;
    /* renamed from: h */
    private int f863h;
    /* renamed from: i */
    private int f864i;
    /* renamed from: j */
    private cs f865j;
    /* renamed from: k */
    private Transformation f866k;
    /* renamed from: l */
    private Rect f867l;
    /* renamed from: m */
    private boolean f868m;

    public TabBarView(Context context) {
        this(context, null);
    }

    public TabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f856a = null;
        this.f857b = -1;
        this.f858c = -1;
        this.f859d = null;
        this.f860e = null;
        this.f862g = 0;
        this.f863h = 0;
        this.f864i = 23;
        this.f865j = null;
        this.f866k = new Transformation();
        this.f867l = new Rect(0, 0, 0, 0);
        this.f868m = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948});
        CharSequence string = obtainStyledAttributes.hasValue(0) ? obtainStyledAttributes.getString(0) : "horizontal";
        obtainStyledAttributes.recycle();
        if (TextUtils.equals(string, "horizontal")) {
            this.f861f = new HorzLinearView(context);
        } else {
            this.f861f = new eq(context);
        }
        addView(this.f861f, new LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public TabBarView(Context context, int i) {
        super(context);
        this.f856a = null;
        this.f857b = -1;
        this.f858c = -1;
        this.f859d = null;
        this.f860e = null;
        this.f862g = 0;
        this.f863h = 0;
        this.f864i = 23;
        this.f865j = null;
        this.f866k = new Transformation();
        this.f867l = new Rect(0, 0, 0, 0);
        this.f868m = true;
        if (i == 1) {
            this.f861f = new eq(context);
        } else {
            this.f861f = new HorzLinearView(context);
        }
        addView(this.f861f, new LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public int getSelectedTabIndex() {
        return this.f857b;
    }

    public int getTabCount() {
        return this.f861f.getCellCount();
    }

    public void setIndicatorGravity(int i) {
        this.f864i = i;
        invalidate();
    }

    public ScaleType getDividerScaleType() {
        return this.f861f.getDividerScaleType();
    }

    public void setDividerScaleType(ScaleType scaleType) {
        this.f861f.setDividerScaleType(scaleType);
        requestLayout();
        invalidate();
    }

    public Drawable getFirstDividerDrawable() {
        return this.f861f.getFirstDivider();
    }

    public void setFirstDividerDrawable(int i) {
        setFirstDividerDrawable(getResources().getDrawable(i));
    }

    public void setFirstDividerDrawable(Drawable drawable) {
        this.f861f.setFirstDivider(drawable);
        requestLayout();
        invalidate();
    }

    public Drawable getMiddleDividerDrawable() {
        return this.f861f.getMiddleDivider();
    }

    public void setMiddleDividerDrawable(int i) {
        setMiddleDividerDrawable(getResources().getDrawable(i));
    }

    public void setMiddleDividerDrawable(Drawable drawable) {
        this.f861f.setMiddleDivider(drawable);
        requestLayout();
        invalidate();
    }

    public Drawable getLastDividerDrawable() {
        return this.f861f.getLastDivider();
    }

    public void setLastDividerDrawable(int i) {
        setLastDividerDrawable(getResources().getDrawable(i));
    }

    public void setLastDividerDrawable(Drawable drawable) {
        this.f861f.setLastDivider(drawable);
        requestLayout();
        invalidate();
    }

    public void setIgnoreRepeatedClicks(boolean z) {
        this.f868m = z;
    }

    /* renamed from: a */
    public int m1319a(int i) {
        int i2 = this.f857b;
        m1308a(i, false);
        return i2;
    }

    /* renamed from: b */
    public View m1321b(int i) {
        return m1318e(i).getChildAt(0);
    }

    /* renamed from: c */
    public View m1322c(int i) {
        ViewGroup a = m1306a();
        LayoutInflater.from(getContext()).inflate(i, a, true);
        if (this.f861f.getChildCount() == 1) {
            m1308a(0, false);
        }
        return a.getChildAt(0);
    }

    /* renamed from: a */
    public int m1320a(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LayoutParams(-1, -1));
        }
        m1306a().addView(view);
        if (this.f861f.getChildCount() == 1) {
            m1308a(0, false);
        }
        return this.f861f.getChildCount() - 1;
    }

    public void setIndicatorDrawable(int i) {
        setIndicatorDrawable(getResources().getDrawable(i));
    }

    public void setIndicatorDrawable(Drawable drawable) {
        this.f856a = drawable;
        invalidate();
    }

    public void setSelectionChangeListener(cs csVar) {
        this.f865j = csVar;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f856a != null && this.f857b >= 0) {
            m1314b();
            m1316c();
            m1309a(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f856a != null) {
            m1310a(null, false);
        }
    }

    public void setTabEnabled(boolean z) {
        for (int i = 0; i < this.f861f.getCellCount(); i++) {
            this.f861f.mo456a(i).setEnabled(z);
        }
    }

    /* renamed from: a */
    private void m1308a(int i, boolean z) {
        if (this.f857b != i || !this.f868m) {
            FrameLayout e;
            this.f858c = this.f857b;
            if (this.f857b >= 0) {
                e = m1318e(this.f857b);
                e.setSelected(false);
                e.getChildAt(0).setSelected(false);
            }
            e = null;
            if (i >= 0) {
                e = m1318e(i);
                this.f857b = i;
            }
            m1310a(e, z);
            if (this.f865j != null) {
                this.f865j.mo1697a(this.f858c, this.f857b, z);
            }
        }
    }

    /* renamed from: a */
    private void m1310a(FrameLayout frameLayout, boolean z) {
        if (this.f857b < 0) {
            this.f859d = null;
            this.f860e = null;
            setIndicatorCenter(0);
            setIndicatorWidth(0);
            invalidate();
        } else if (this.f856a == null || getVisibility() != 0) {
            if (frameLayout != null) {
                frameLayout.setSelected(true);
                frameLayout.getChildAt(0).setSelected(true);
            }
            post(new cn(this, z));
        } else {
            Rect selectedTabRect = getSelectedTabRect();
            if (!m1317c(selectedTabRect)) {
                if (this.f861f instanceof eq) {
                    this.f859d = new TranslateAnimation(0.0f, 0.0f, (float) getIndicatorCenter(), (float) m1303a(selectedTabRect));
                    this.f860e = new TranslateAnimation(0.0f, 0.0f, (float) getIndicatorWidth(), (float) m1312b(selectedTabRect));
                } else {
                    this.f859d = new TranslateAnimation((float) getIndicatorCenter(), (float) m1303a(selectedTabRect), 0.0f, 0.0f);
                    this.f860e = new TranslateAnimation((float) getIndicatorWidth(), (float) m1312b(selectedTabRect), 0.0f, 0.0f);
                }
                this.f859d.initialize(selectedTabRect.width(), selectedTabRect.height(), getWidth(), getHeight());
                this.f859d.setDuration(200);
                this.f859d.setFillAfter(true);
                this.f859d.setFillEnabled(true);
                this.f859d.setInterpolator(new AccelerateDecelerateInterpolator());
                this.f860e.initialize(selectedTabRect.width(), selectedTabRect.height(), getWidth(), getHeight());
                this.f860e.setDuration(200);
                this.f860e.setFillAfter(true);
                this.f860e.setFillEnabled(true);
                this.f860e.setInterpolator(new AccelerateDecelerateInterpolator());
                this.f860e.setAnimationListener(new co(this, frameLayout, z));
                invalidate();
            } else if (frameLayout != null) {
                frameLayout.setSelected(true);
                frameLayout.getChildAt(0).setSelected(true);
            }
        }
    }

    private Rect getSelectedTabRect() {
        if (this.f857b < 0) {
            return new Rect(0, 0, 0, 0);
        }
        Rect rect = new Rect();
        dv.m1906a(new RectF(), m1321b(this.f857b), (View) this).round(rect);
        return rect;
    }

    /* renamed from: a */
    private int m1303a(Rect rect) {
        if (this.f861f instanceof eq) {
            return rect.centerY();
        }
        return rect.centerX();
    }

    /* renamed from: a */
    private FrameLayout m1306a() {
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setOnClickListener(new cq(this));
        frameLayout.setOnTouchListener(new cr(this));
        this.f861f.mo455a(frameLayout, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        return frameLayout;
    }

    /* renamed from: a */
    private int m1304a(FrameLayout frameLayout) {
        for (int i = 0; i < this.f861f.getCellCount(); i++) {
            if (this.f861f.mo456a(i) == frameLayout) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: e */
    private FrameLayout m1318e(int i) {
        return (FrameLayout) this.f861f.mo456a(i);
    }

    /* renamed from: d */
    protected void m1323d(int i) {
        setIndicatorCenter(i);
        invalidate();
    }

    private int getIndicatorCenter() {
        return this.f862g;
    }

    private void setIndicatorCenter(int i) {
        this.f862g = i;
    }

    private int getIndicatorWidth() {
        return this.f863h;
    }

    private void setIndicatorWidth(int i) {
        this.f863h = i;
    }

    /* renamed from: b */
    private void m1314b() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f859d != null && !this.f859d.hasEnded()) {
            if (!this.f859d.hasStarted()) {
                this.f859d.setStartTime(currentAnimationTimeMillis);
            }
            float[] fArr = new float[]{0.0f, 0.0f};
            this.f859d.getTransformation(currentAnimationTimeMillis, this.f866k);
            this.f866k.getMatrix().mapPoints(fArr);
            if (this.f861f instanceof eq) {
                this.f862g = Math.round(fArr[1]);
            } else {
                this.f862g = Math.round(fArr[0]);
            }
            invalidate();
        }
    }

    /* renamed from: c */
    private void m1316c() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f860e != null && !this.f860e.hasEnded()) {
            if (!this.f860e.hasStarted()) {
                this.f860e.setStartTime(currentAnimationTimeMillis);
            }
            float[] fArr = new float[]{0.0f, 0.0f};
            this.f860e.getTransformation(currentAnimationTimeMillis, this.f866k);
            this.f866k.getMatrix().mapPoints(fArr);
            if (this.f861f instanceof eq) {
                this.f863h = Math.round(fArr[1]);
            } else {
                this.f863h = Math.round(fArr[0]);
            }
            invalidate();
        }
    }

    /* renamed from: a */
    private void m1309a(Canvas canvas) {
        canvas.save();
        if (this.f861f instanceof eq) {
            this.f867l.set(0, this.f862g - (this.f863h / 2), getWidth(), this.f862g + ((this.f863h + 1) / 2));
        } else {
            this.f867l.set(this.f862g - (this.f863h / 2), 0, this.f862g + ((this.f863h + 1) / 2), getHeight());
        }
        dv.m1911a(canvas, this.f856a, this.f867l, this.f864i);
        canvas.restore();
    }

    /* renamed from: b */
    private int m1312b(Rect rect) {
        if (this.f861f instanceof eq) {
            return rect.height();
        }
        return rect.width();
    }

    /* renamed from: c */
    private boolean m1317c(Rect rect) {
        if (this.f861f instanceof eq) {
            if (this.f862g == rect.centerY() && this.f863h == rect.height()) {
                return true;
            }
            return false;
        } else if (this.f862g == rect.centerX() && this.f863h == rect.width()) {
            return true;
        } else {
            return false;
        }
    }
}
