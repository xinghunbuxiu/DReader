package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import org.apache.http.HttpStatus;

public class BubbleFloatingView extends FrameLayout {
    private final ad a;
    private int b;
    private RectF[] c;
    private int d;
    private boolean e;

    public BubbleFloatingView(Context context) {
        this(context, null);
    }

    public BubbleFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        this.c = null;
        this.d = 0;
        this.e = true;
        this.a = new ad(this, context);
        addView(this.a, new LayoutParams(-2, -2));
    }

    public void setUpArrow(int i) {
        this.a.b(i);
    }

    public void setDownArrow(int i) {
        this.a.c(i);
    }

    public void setVerticalOffset(int i) {
        this.d = i;
    }

    public View getCenterView() {
        return this.a.a();
    }

    public void a(int i, int i2, int i3, int i4) {
        this.a.a(i, i2, i3, i4);
    }

    public void setCenterViewResource(int i) {
        this.a.d(i);
    }

    public void a(View view, LayoutParams layoutParams) {
        this.a.a(view, layoutParams);
    }

    public void a(Rect[] rectArr, boolean z, int i) {
        if (rectArr != null && rectArr.length > 0) {
            this.b = i;
            RectF[] rectFArr = new RectF[rectArr.length];
            for (int i2 = 0; i2 < rectFArr.length; i2++) {
                rectFArr[i2] = new RectF(rectArr[i2]);
            }
            a(rectFArr, z, i);
        }
    }

    public void a(RectF[] rectFArr, boolean z, int i) {
        if (rectFArr != null && rectFArr.length > 0) {
            this.b = i;
            this.c = rectFArr;
            this.e = z;
            requestLayout();
            invalidate();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.c != null) {
            Rect rect = new Rect(i, i2, i3, i4);
            RectF rectF = new RectF(this.c[0]);
            RectF rectF2 = new RectF(this.c[this.c.length - 1]);
            if (this.e) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                rectF.offset((float) (-iArr[0]), (float) (-iArr[1]));
                if (rectF != rectF2) {
                    rectF2.offset((float) (-iArr[0]), (float) (-iArr[1]));
                }
            }
            int i5 = (int) ((rectF.top - ((float) rect.top)) - ((float) this.d));
            int i6 = (int) ((((float) rect.bottom) - rectF2.bottom) - ((float) this.d));
            int measuredHeight = this.a.getMeasuredHeight();
            if (i5 <= measuredHeight && i6 < measuredHeight) {
                i6 = ((i3 - i) / 2) - (this.a.getMeasuredWidth() / 2);
                int measuredHeight2 = ((i4 - i2) / 2) - (this.a.getMeasuredHeight() / 2);
                this.a.a(false);
                this.a.a((this.a.getMeasuredWidth() / 2) + i6);
                this.a.layout(i6, measuredHeight2, this.a.getMeasuredWidth() + i6, this.a.getMeasuredHeight() + measuredHeight2);
            } else if (i5 > i6) {
                i6 = (int) ((rectF.left + (rectF.width() / 2.0f)) - ((float) (this.a.getMeasuredWidth() / 2)));
                if (i6 < 0) {
                    i6 = 0;
                }
                if (this.a.getMeasuredWidth() + i6 > i3) {
                    i6 = i3 - this.a.getMeasuredWidth();
                }
                this.a.a(true);
                this.a.a((int) (rectF.left + (rectF.width() / 2.0f)));
                this.a.layout(i6, (int) ((rectF.top - ((float) this.a.getMeasuredHeight())) - ((float) this.d)), this.a.getMeasuredWidth() + i6, (int) (rectF.top - ((float) this.d)));
            } else {
                i6 = (int) ((rectF2.left + (rectF2.width() / 2.0f)) - ((float) (this.a.getMeasuredWidth() / 2)));
                if (i6 < 0) {
                    i6 = 0;
                }
                if (this.a.getMeasuredWidth() + i6 > i3) {
                    i6 = i3 - this.a.getMeasuredWidth();
                }
                this.a.a(false);
                this.a.a((int) (rectF2.left + (rectF2.width() / 2.0f)));
                this.a.layout(i6, (int) (rectF2.bottom + ((float) this.d)), this.a.getMeasuredWidth() + i6, Math.min((int) ((rectF2.bottom + ((float) this.a.getMeasuredHeight())) + ((float) this.d)), i4));
            }
        }
    }

    protected AnimationSet a(int i, boolean z) {
        if (z) {
            float left = (((float) i) - ((float) getLeft())) / ((float) getWidth());
            AnimationSet animationSet = new AnimationSet(false);
            Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, left, 1, 1.0f);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            scaleAnimation.setDuration((long) this.b);
            scaleAnimation.setInterpolator(new OvershootInterpolator(1.2f));
            alphaAnimation.setDuration((long) this.b);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration((long) this.b);
            return animationSet;
        }
        left = (((float) i) - ((float) getLeft())) / ((float) getWidth());
        animationSet = new AnimationSet(false);
        scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, left, 1, 0.0f);
        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        scaleAnimation.setDuration((long) this.b);
        scaleAnimation.setInterpolator(new OvershootInterpolator(1.2f));
        alphaAnimation.setDuration((long) this.b);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration((long) this.b);
        return animationSet;
    }

    protected View getBubbleView() {
        return this.a;
    }
}
