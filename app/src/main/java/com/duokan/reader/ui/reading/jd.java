package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

import com.duokan.core.ui.UTools;
import com.duokan.reader.DkApp;

import org.apache.http.HttpStatus;

public class jd extends FrameLayout {
    private final jg a;
    private final int b;
    private RectF c;
    private int d;
    private boolean e;
    private final Runnable f;
    private final Rect g;
    private final Rect h;

    public jd(Context context, AttributeSet attributeSet, Runnable runnable) {
        super(context, attributeSet);
        this.b = HttpStatus.SC_OK;
        this.c = null;
        this.d = 0;
        this.e = false;
        this.g = new Rect();
        this.h = new Rect();
        this.a = new jg(this, DkApp.get().noDensityScaleContext(context));
        addView(this.a, new LayoutParams(-2, -2));
        this.f = runnable;
    }

    public jd(Context context, Runnable runnable) {
        this(context, null, runnable);
    }

    public void setVerticalOffset(int i) {
        this.d = i;
    }

    public View getCenterView() {
        return this.a.a();
    }

    public void a(Rect rect) {
        if (rect != null) {
            this.c = new RectF(rect);
            requestLayout();
            invalidate();
        }
    }

    public void a() {
        if (!this.e) {
            this.e = true;
            Animation a = a(this.a.b, this.a.a);
            if (this.f != null) {
                a.setAnimationListener(new je(this));
            }
            a.setDuration(200);
            this.a.a(a);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.c != null) {
            this.h.left = i;
            this.h.top = i2;
            this.h.right = i3;
            this.h.bottom = i4;
            if (((float) this.h.centerX()) - this.c.centerX() > 0.0f) {
                this.a.a(0);
            } else {
                this.a.a(1);
            }
            this.a.measure(0, 0);
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.c.offset((float) (-iArr[0]), (float) (-iArr[1]));
            int i5 = (int) ((this.c.top - ((float) this.h.top)) - ((float) this.d));
            int i6 = (int) ((((float) this.h.bottom) - this.c.bottom) - ((float) this.d));
            int measuredHeight = this.a.getMeasuredHeight();
            int b = UTools.closeAnimation(getContext(), 50.0f);
            if (i5 <= measuredHeight && i6 < measuredHeight) {
                i5 = ((i4 - i2) / 2) - (this.a.getMeasuredHeight() / 2);
                this.g.top = i5;
                this.g.bottom = i5 + this.a.getMeasuredHeight();
            } else if (i5 > i6) {
                this.g.top = (int) ((this.c.top - ((float) this.a.getMeasuredHeight())) - ((float) this.d));
                this.g.bottom = (int) (this.c.top - ((float) this.d));
            } else {
                this.g.top = (int) (this.c.bottom + ((float) this.d));
                this.g.bottom = Math.min((int) ((this.c.bottom + ((float) this.a.getMeasuredHeight())) + ((float) this.d)), i4);
            }
            if (((float) this.h.centerX()) - this.c.centerX() > 0.0f) {
                this.g.left = i;
                this.g.right = Math.min(this.a.getMeasuredWidth(), i3 - b);
            } else {
                this.g.left = Math.max(i3 - this.a.getMeasuredWidth(), b);
                this.g.right = i3;
            }
            this.a.a(this.g);
            this.a.layout(this.g.left, this.g.top, this.g.right, this.g.bottom);
        }
    }

    protected AnimationSet a(int i, Rect rect) {
        AnimationSet animationSet = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(0.0f, i == 0 ? (float) (rect.left - rect.right) : (float) ((-rect.left) + rect.right), 0.0f, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(200);
        return animationSet;
    }

    protected AnimationSet b(int i, Rect rect) {
        AnimationSet animationSet = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(i == 0 ? (float) (rect.left - rect.right) : (float) ((-rect.left) + rect.right), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(200);
        return animationSet;
    }
}
