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
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.dv;
import com.duokan.reader.DkApp;
import org.apache.http.HttpStatus;

public class jn extends FrameLayout {
    /* renamed from: a */
    private final jq f10445a;
    /* renamed from: b */
    private final int f10446b;
    /* renamed from: c */
    private RectF f10447c;
    /* renamed from: d */
    private int f10448d;
    /* renamed from: e */
    private boolean f10449e;
    /* renamed from: f */
    private final Runnable f10450f;
    /* renamed from: g */
    private final Rect f10451g;
    /* renamed from: h */
    private final Rect f10452h;

    public jn(Context context, AttributeSet attributeSet, Runnable runnable) {
        super(context, attributeSet);
        this.f10446b = HttpStatus.SC_OK;
        this.f10447c = null;
        this.f10448d = 0;
        this.f10449e = false;
        this.f10451g = new Rect();
        this.f10452h = new Rect();
        this.f10445a = new jq(this, DkApp.get().noDensityScaleContext(context));
        addView(this.f10445a, new LayoutParams(-2, -2));
        this.f10450f = runnable;
    }

    public jn(Context context, Runnable runnable) {
        this(context, null, runnable);
    }

    public void setVerticalOffset(int i) {
        this.f10448d = i;
    }

    public View getCenterView() {
        return this.f10445a.m14499a();
    }

    /* renamed from: a */
    public void m14488a(Rect rect) {
        if (rect != null) {
            this.f10447c = new RectF(rect);
            requestLayout();
            invalidate();
        }
    }

    /* renamed from: a */
    public void m14487a() {
        if (!this.f10449e) {
            this.f10449e = true;
            Animation a = m14486a(this.f10445a.f10456b, this.f10445a.f10455a);
            if (this.f10450f != null) {
                a.setAnimationListener(new jo(this));
            }
            a.setDuration(200);
            this.f10445a.m14502a(a);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f10447c != null) {
            this.f10452h.left = i;
            this.f10452h.top = i2;
            this.f10452h.right = i3;
            this.f10452h.bottom = i4;
            if (((float) this.f10452h.centerX()) - this.f10447c.centerX() > 0.0f) {
                this.f10445a.m14500a(0);
            } else {
                this.f10445a.m14500a(1);
            }
            this.f10445a.measure(0, 0);
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.f10447c.offset((float) (-iArr[0]), (float) (-iArr[1]));
            int i5 = (int) ((this.f10447c.top - ((float) this.f10452h.top)) - ((float) this.f10448d));
            int i6 = (int) ((((float) this.f10452h.bottom) - this.f10447c.bottom) - ((float) this.f10448d));
            int measuredHeight = this.f10445a.getMeasuredHeight();
            int b = dv.m1932b(getContext(), 50.0f);
            if (i5 <= measuredHeight && i6 < measuredHeight) {
                i5 = ((i4 - i2) / 2) - (this.f10445a.getMeasuredHeight() / 2);
                this.f10451g.top = i5;
                this.f10451g.bottom = i5 + this.f10445a.getMeasuredHeight();
            } else if (i5 > i6) {
                this.f10451g.top = (int) ((this.f10447c.top - ((float) this.f10445a.getMeasuredHeight())) - ((float) this.f10448d));
                this.f10451g.bottom = (int) (this.f10447c.top - ((float) this.f10448d));
            } else {
                this.f10451g.top = (int) (this.f10447c.bottom + ((float) this.f10448d));
                this.f10451g.bottom = Math.min((int) ((this.f10447c.bottom + ((float) this.f10445a.getMeasuredHeight())) + ((float) this.f10448d)), i4);
            }
            if (((float) this.f10452h.centerX()) - this.f10447c.centerX() > 0.0f) {
                this.f10451g.left = i;
                this.f10451g.right = Math.min(this.f10445a.getMeasuredWidth(), i3 - b);
            } else {
                this.f10451g.left = Math.max(i3 - this.f10445a.getMeasuredWidth(), b);
                this.f10451g.right = i3;
            }
            this.f10445a.m14501a(this.f10451g);
            this.f10445a.layout(this.f10451g.left, this.f10451g.top, this.f10451g.right, this.f10451g.bottom);
        }
    }

    /* renamed from: a */
    protected AnimationSet m14486a(int i, Rect rect) {
        AnimationSet animationSet = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(0.0f, i == 0 ? (float) (rect.left - rect.right) : (float) ((-rect.left) + rect.right), 0.0f, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(200);
        return animationSet;
    }

    /* renamed from: b */
    protected AnimationSet m14489b(int i, Rect rect) {
        AnimationSet animationSet = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(i == 0 ? (float) (rect.left - rect.right) : (float) ((-rect.left) + rect.right), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(200);
        return animationSet;
    }
}
