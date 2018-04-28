package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0248j;

public class DotProgressBar extends View {
    /* renamed from: a */
    static final /* synthetic */ boolean f6801a = (!DotProgressBar.class.desiredAssertionStatus());
    /* renamed from: b */
    private final boolean f6802b;
    /* renamed from: c */
    private final Drawable f6803c;
    /* renamed from: d */
    private final Drawable f6804d;
    /* renamed from: e */
    private final String f6805e;
    /* renamed from: f */
    private final bt f6806f;
    /* renamed from: g */
    private int f6807g;
    /* renamed from: h */
    private float f6808h;
    /* renamed from: i */
    private int f6809i;
    /* renamed from: j */
    private int f6810j;
    /* renamed from: k */
    private final int f6811k;
    /* renamed from: l */
    private final int f6812l;
    /* renamed from: m */
    private int f6813m;
    /* renamed from: n */
    private Float f6814n;
    /* renamed from: o */
    private Paint f6815o;
    /* renamed from: p */
    private boolean f6816p;

    public DotProgressBar(Context context) {
        this(context, null);
    }

    public DotProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6807g = 0;
        this.f6808h = 0.0f;
        this.f6809i = 0;
        this.f6810j = 0;
        this.f6813m = 0;
        this.f6814n = null;
        this.f6815o = null;
        this.f6816p = true;
        this.f6811k = dv.m1932b(getContext(), 2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0248j.DotProgressBar);
        this.f6802b = obtainStyledAttributes.getBoolean(C0248j.DotProgressBar_draw_continous, true);
        this.f6804d = getResources().getDrawable(obtainStyledAttributes.getResourceId(C0248j.DotProgressBar_highlight_resource, C0243e.general__shared__jindu_01));
        this.f6803c = getResources().getDrawable(obtainStyledAttributes.getResourceId(C0248j.DotProgressBar_normal_resource, C0243e.general__shared__jindu_02));
        this.f6805e = m9967a(obtainStyledAttributes.getString(C0248j.DotProgressBar_draw_position));
        this.f6816p = obtainStyledAttributes.getBoolean(C0248j.DotProgressBar_width_adaptive, true);
        obtainStyledAttributes.recycle();
        if (this.f6802b) {
            this.f6806f = new bs();
            this.f6812l = dv.m1932b(getContext(), 5.0f);
        } else {
            this.f6806f = new bu();
            this.f6812l = dv.m1932b(getContext(), 9.0f);
        }
        this.f6815o = new Paint();
        this.f6815o.setAntiAlias(true);
    }

    public int getNums() {
        return this.f6807g;
    }

    public void setNums(int i) {
        if (f6801a || this.f6807g >= 0) {
            this.f6807g = i;
            m9968a();
            invalidate();
            return;
        }
        throw new AssertionError();
    }

    public void setCurrentIndex(int i) {
        if (i < -1) {
            i = -1;
        } else if (i >= this.f6807g) {
            i = this.f6807g - 1;
        }
        if (this.f6813m != i) {
            this.f6813m = i;
            invalidate();
        }
    }

    public void setPercentage(float f) {
        this.f6814n = Float.valueOf(f);
        invalidate();
    }

    /* renamed from: a */
    private String m9967a(String str) {
        if (str == null || (!str.equalsIgnoreCase("left") && !str.equalsIgnoreCase("center") && !str.equalsIgnoreCase("right"))) {
            return "left";
        }
        return str;
    }

    /* renamed from: a */
    private void m9969a(Canvas canvas, boolean z, float f, int i, int i2) {
        Drawable drawable;
        if (z) {
            drawable = this.f6803c;
        } else {
            drawable = this.f6804d;
        }
        while (i < i2) {
            int round = Math.round(((float) ((this.f6811k + (this.f6812l * 2)) * i)) + f);
            int intrinsicHeight = (this.f6809i / 2) - (drawable.getIntrinsicHeight() / 2);
            drawable.setBounds(round, intrinsicHeight, drawable.getIntrinsicWidth() + round, drawable.getIntrinsicHeight() + intrinsicHeight);
            drawable.draw(canvas);
            i++;
        }
    }

    /* renamed from: a */
    private void m9968a() {
        float paddingLeft = (float) ((this.f6810j - getPaddingLeft()) - getPaddingRight());
        float f = (float) ((this.f6811k * (this.f6807g - 1)) + ((this.f6807g * 2) * this.f6812l));
        if (this.f6805e.equalsIgnoreCase("left")) {
            this.f6808h = 0.0f;
        } else if (this.f6805e.equalsIgnoreCase("center")) {
            this.f6808h = (paddingLeft - f) / 2.0f;
        } else {
            this.f6808h = paddingLeft - f;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.f6816p) {
            this.f6807g = Math.round((float) (this.f6810j / (this.f6811k + (this.f6812l * 2)))) - 1;
        }
        if (this.f6814n != null) {
            if (((double) this.f6814n.floatValue()) < 0.005d) {
                this.f6813m = -1;
            } else {
                this.f6813m = Math.round(this.f6814n.floatValue() * ((float) this.f6807g));
                if (0.5d < ((double) this.f6814n.floatValue()) && ((double) this.f6814n.floatValue()) < 0.995d) {
                    this.f6813m--;
                }
            }
        }
        this.f6806f.mo1752a(canvas);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.f6810j = i3 - i;
            this.f6809i = i4 - i2;
            m9968a();
        }
    }
}
