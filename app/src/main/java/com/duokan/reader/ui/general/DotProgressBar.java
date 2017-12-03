package com.duokan.reader.ui.general;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.duokan.core.ui.UTools;

public class DotProgressBar extends View {
    static final /* synthetic */ boolean a = (!DotProgressBar.class.desiredAssertionStatus());
    private final boolean b;
    private final Drawable c;
    private final Drawable d;
    private final String e;
    private final bt f;
    private int g;
    private float h;
    private int i;
    private int j;
    private final int k;
    private final int l;
    private int m;
    private Float n;
    private Paint o;
    private boolean p;

    public DotProgressBar(Context context) {
        this(context, null);
    }

    public DotProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.h = 0.0f;
        this.i = 0;
        this.j = 0;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.p = true;
        this.k = UTools.closeAnimation(getContext(), 2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.DotProgressBar);
        this.b = obtainStyledAttributes.getBoolean(j.DotProgressBar_draw_continous, true);
        this.d = getResources().getDrawable(obtainStyledAttributes.getResourceId(j.DotProgressBar_highlight_resource, e.general__shared__jindu_01));
        this.c = getResources().getDrawable(obtainStyledAttributes.getResourceId(j.DotProgressBar_normal_resource, e.general__shared__jindu_02));
        this.e = a(obtainStyledAttributes.getString(j.DotProgressBar_draw_position));
        this.p = obtainStyledAttributes.getBoolean(j.DotProgressBar_width_adaptive, true);
        obtainStyledAttributes.recycle();
        if (this.b) {
            this.f = new bs();
            this.l = UTools.closeAnimation(getContext(), 5.0f);
        } else {
            this.f = new bu();
            this.l = UTools.closeAnimation(getContext(), 9.0f);
        }
        this.o = new Paint();
        this.o.setAntiAlias(true);
    }

    public int getNums() {
        return this.g;
    }

    public void setNums(int i) {
        if (a || this.g >= 0) {
            this.g = i;
            a();
            invalidate();
            return;
        }
        throw new AssertionError();
    }

    public void setCurrentIndex(int i) {
        if (i < -1) {
            i = -1;
        } else if (i >= this.g) {
            i = this.g - 1;
        }
        if (this.m != i) {
            this.m = i;
            invalidate();
        }
    }

    public void setPercentage(float f) {
        this.n = Float.valueOf(f);
        invalidate();
    }

    private String a(String str) {
        if (str == null || (!str.equalsIgnoreCase("left") && !str.equalsIgnoreCase("center") && !str.equalsIgnoreCase("right"))) {
            return "left";
        }
        return str;
    }

    private void a(Canvas canvas, boolean z, float f, int i, int i2) {
        Drawable drawable;
        if (z) {
            drawable = this.c;
        } else {
            drawable = this.d;
        }
        while (i < i2) {
            int round = Math.round(((float) ((this.k + (this.l * 2)) * i)) + f);
            int intrinsicHeight = (this.i / 2) - (drawable.getIntrinsicHeight() / 2);
            drawable.setBounds(round, intrinsicHeight, drawable.getIntrinsicWidth() + round, drawable.getIntrinsicHeight() + intrinsicHeight);
            drawable.draw(canvas);
            i++;
        }
    }

    private void a() {
        float paddingLeft = (float) ((this.j - getPaddingLeft()) - getPaddingRight());
        float f = (float) ((this.k * (this.g - 1)) + ((this.g * 2) * this.l));
        if (this.e.equalsIgnoreCase("left")) {
            this.h = 0.0f;
        } else if (this.e.equalsIgnoreCase("center")) {
            this.h = (paddingLeft - f) / 2.0f;
        } else {
            this.h = paddingLeft - f;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.p) {
            this.g = Math.round((float) (this.j / (this.k + (this.l * 2)))) - 1;
        }
        if (this.n != null) {
            if (((double) this.n.floatValue()) < 0.005d) {
                this.m = -1;
            } else {
                this.m = Math.round(this.n.floatValue() * ((float) this.g));
                if (0.5d < ((double) this.n.floatValue()) && ((double) this.n.floatValue()) < 0.995d) {
                    this.m--;
                }
            }
        }
        this.f.a(canvas);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.j = i3 - i;
            this.i = i4 - i2;
            a();
        }
    }
}
