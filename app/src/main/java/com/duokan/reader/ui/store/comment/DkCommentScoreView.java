package com.duokan.reader.ui.store.comment;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.duokan.core.ui.ct;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.et;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0248j;

public class DkCommentScoreView extends View {
    /* renamed from: a */
    static final /* synthetic */ boolean f11388a = (!DkCommentScoreView.class.desiredAssertionStatus());
    /* renamed from: b */
    private final boolean f11389b;
    /* renamed from: c */
    private final Drawable f11390c;
    /* renamed from: d */
    private final Drawable f11391d;
    /* renamed from: e */
    private final int f11392e;
    /* renamed from: f */
    private int f11393f;
    /* renamed from: g */
    private int f11394g;
    /* renamed from: h */
    private float f11395h = 0.0f;
    /* renamed from: i */
    private C1453e f11396i;
    /* renamed from: j */
    private et f11397j = null;

    public DkCommentScoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0248j.DkCommentScoreView);
        this.f11389b = obtainStyledAttributes.getBoolean(C0248j.DkCommentScoreView_custom_operation, false);
        boolean z = obtainStyledAttributes.getBoolean(C0248j.DkCommentScoreView_need_login, true);
        this.f11390c = getResources().getDrawable(obtainStyledAttributes.getResourceId(C0248j.DkCommentScoreView_high_score, C0243e.bookcity_comment__shared__red_star));
        this.f11391d = getResources().getDrawable(obtainStyledAttributes.getResourceId(C0248j.DkCommentScoreView_normal_score, C0243e.bookcity_comment__shared__small_gray_star));
        this.f11392e = obtainStyledAttributes.getDimensionPixelSize(C0248j.DkCommentScoreView_score_space, 5);
        obtainStyledAttributes.recycle();
        if (this.f11389b) {
            this.f11397j = new et();
            this.f11397j.m2041a(new ct());
            this.f11397j.m2046b(this);
            this.f11397j.m2042a(new C1480c(this, z));
        }
    }

    public void setScore(float f) {
        if (!f11388a && (0.0f > f || f > 5.0f)) {
            throw new AssertionError();
        } else if (!m15366a(false)) {
            this.f11395h = m15363a(f);
            m15367b(false);
            invalidate();
        }
    }

    public void setScore(int i) {
        setScore((float) i);
    }

    public float getScore() {
        return this.f11395h;
    }

    public void setScoreChangeListener(C1453e c1453e) {
        if (f11388a || c1453e != null) {
            this.f11396i = c1453e;
            return;
        }
        throw new AssertionError();
    }

    protected void onDraw(Canvas canvas) {
        int i;
        int i2 = 0;
        int paddingLeft = (this.f11392e / 2) + getPaddingLeft();
        int intrinsicWidth = this.f11391d.getIntrinsicWidth();
        for (i = 0; i < 5; i++) {
            int i3 = ((this.f11392e + intrinsicWidth) * i) + paddingLeft;
            this.f11391d.setBounds(i3, getPaddingTop(), this.f11391d.getIntrinsicWidth() + i3, getPaddingTop() + this.f11391d.getIntrinsicHeight());
            this.f11391d.draw(canvas);
        }
        i = (int) Math.floor((double) this.f11395h);
        while (i2 < i) {
            i3 = ((this.f11392e + intrinsicWidth) * i2) + paddingLeft;
            this.f11390c.setBounds(i3, getPaddingTop(), this.f11390c.getIntrinsicWidth() + i3, getPaddingTop() + this.f11390c.getIntrinsicHeight());
            this.f11390c.draw(canvas);
            i2++;
        }
        if (((double) (this.f11395h - ((float) i))) >= 0.5d) {
            i = paddingLeft + ((this.f11392e + intrinsicWidth) * i);
            Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
            rect.set(i, getPaddingTop(), (this.f11390c.getIntrinsicWidth() / 2) + i, this.f11390c.getIntrinsicHeight() + getPaddingTop());
            canvas.save();
            canvas.clipRect(rect);
            this.f11390c.setBounds(i, getPaddingTop(), this.f11390c.getIntrinsicWidth() + i, getPaddingTop() + this.f11390c.getIntrinsicHeight());
            this.f11390c.draw(canvas);
            canvas.restore();
            AnimUtils.f1198g.clearAnimation(rect);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.f11393f = size;
        } else {
            this.f11393f = (getPaddingLeft() + getPaddingRight()) + ((this.f11390c.getIntrinsicWidth() + this.f11392e) * 5);
        }
        if (mode2 == 1073741824) {
            this.f11394g = size2;
        } else {
            this.f11394g = (getPaddingTop() + getPaddingBottom()) + this.f11390c.getIntrinsicHeight();
        }
        setMeasuredDimension(this.f11393f, this.f11394g);
    }

    /* renamed from: a */
    private void m15364a(PointF pointF) {
        int i = 5;
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i2 = (int) pointF.x;
        if (i2 < paddingLeft) {
            width = 1;
        } else if (i2 > width - paddingRight) {
            width = 5;
        } else {
            width = (int) Math.ceil((double) (((((float) i2) - ((float) paddingLeft)) - ((float) paddingRight)) / ((float) (this.f11390c.getIntrinsicWidth() + this.f11392e))));
        }
        if (width <= 0) {
            i = 1;
        } else if (width <= 5) {
            i = width;
        }
        if (this.f11395h != ((float) i) && !m15366a(true)) {
            this.f11395h = (float) i;
            invalidate();
            m15367b(true);
        }
    }

    /* renamed from: a */
    private float m15363a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 5.0f) {
            return 5.0f;
        }
        return f;
    }

    /* renamed from: a */
    private boolean m15366a(boolean z) {
        if (this.f11396i != null) {
            return this.f11396i.mo2308a(this, z);
        }
        return false;
    }

    /* renamed from: b */
    private void m15367b(boolean z) {
        if (this.f11396i != null) {
            this.f11396i.mo2307a(this, (int) this.f11395h, z);
        }
    }
}
