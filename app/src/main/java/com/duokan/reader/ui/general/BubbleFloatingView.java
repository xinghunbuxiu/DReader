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
    /* renamed from: a */
    private final ad f6768a;
    /* renamed from: b */
    private int f6769b;
    /* renamed from: c */
    private RectF[] f6770c;
    /* renamed from: d */
    private int f6771d;
    /* renamed from: e */
    private boolean f6772e;

    public BubbleFloatingView(Context context) {
        this(context, null);
    }

    public BubbleFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6769b = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        this.f6770c = null;
        this.f6771d = 0;
        this.f6772e = true;
        this.f6768a = new ad(this, context);
        addView(this.f6768a, new LayoutParams(-2, -2));
    }

    public void setUpArrow(int i) {
        this.f6768a.m10223b(i);
    }

    public void setDownArrow(int i) {
        this.f6768a.m10224c(i);
    }

    public void setVerticalOffset(int i) {
        this.f6771d = i;
    }

    public View getCenterView() {
        return this.f6768a.m10218a();
    }

    /* renamed from: a */
    public void m9924a(int i, int i2, int i3, int i4) {
        this.f6768a.m10220a(i, i2, i3, i4);
    }

    public void setCenterViewResource(int i) {
        this.f6768a.m10225d(i);
    }

    /* renamed from: a */
    public void m9925a(View view, LayoutParams layoutParams) {
        this.f6768a.m10221a(view, layoutParams);
    }

    /* renamed from: a */
    public void m9926a(Rect[] rectArr, boolean z, int i) {
        if (rectArr != null && rectArr.length > 0) {
            this.f6769b = i;
            RectF[] rectFArr = new RectF[rectArr.length];
            for (int i2 = 0; i2 < rectFArr.length; i2++) {
                rectFArr[i2] = new RectF(rectArr[i2]);
            }
            m9927a(rectFArr, z, i);
        }
    }

    /* renamed from: a */
    public void m9927a(RectF[] rectFArr, boolean z, int i) {
        if (rectFArr != null && rectFArr.length > 0) {
            this.f6769b = i;
            this.f6770c = rectFArr;
            this.f6772e = z;
            requestLayout();
            invalidate();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f6770c != null) {
            Rect rect = new Rect(i, i2, i3, i4);
            RectF rectF = new RectF(this.f6770c[0]);
            RectF rectF2 = new RectF(this.f6770c[this.f6770c.length - 1]);
            if (this.f6772e) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                rectF.offset((float) (-iArr[0]), (float) (-iArr[1]));
                if (rectF != rectF2) {
                    rectF2.offset((float) (-iArr[0]), (float) (-iArr[1]));
                }
            }
            int i5 = (int) ((rectF.top - ((float) rect.top)) - ((float) this.f6771d));
            int i6 = (int) ((((float) rect.bottom) - rectF2.bottom) - ((float) this.f6771d));
            int measuredHeight = this.f6768a.getMeasuredHeight();
            if (i5 <= measuredHeight && i6 < measuredHeight) {
                i6 = ((i3 - i) / 2) - (this.f6768a.getMeasuredWidth() / 2);
                int measuredHeight2 = ((i4 - i2) / 2) - (this.f6768a.getMeasuredHeight() / 2);
                this.f6768a.m10222a(false);
                this.f6768a.m10219a((this.f6768a.getMeasuredWidth() / 2) + i6);
                this.f6768a.layout(i6, measuredHeight2, this.f6768a.getMeasuredWidth() + i6, this.f6768a.getMeasuredHeight() + measuredHeight2);
            } else if (i5 > i6) {
                i6 = (int) ((rectF.left + (rectF.width() / 2.0f)) - ((float) (this.f6768a.getMeasuredWidth() / 2)));
                if (i6 < 0) {
                    i6 = 0;
                }
                if (this.f6768a.getMeasuredWidth() + i6 > i3) {
                    i6 = i3 - this.f6768a.getMeasuredWidth();
                }
                this.f6768a.m10222a(true);
                this.f6768a.m10219a((int) (rectF.left + (rectF.width() / 2.0f)));
                this.f6768a.layout(i6, (int) ((rectF.top - ((float) this.f6768a.getMeasuredHeight())) - ((float) this.f6771d)), this.f6768a.getMeasuredWidth() + i6, (int) (rectF.top - ((float) this.f6771d)));
            } else {
                i6 = (int) ((rectF2.left + (rectF2.width() / 2.0f)) - ((float) (this.f6768a.getMeasuredWidth() / 2)));
                if (i6 < 0) {
                    i6 = 0;
                }
                if (this.f6768a.getMeasuredWidth() + i6 > i3) {
                    i6 = i3 - this.f6768a.getMeasuredWidth();
                }
                this.f6768a.m10222a(false);
                this.f6768a.m10219a((int) (rectF2.left + (rectF2.width() / 2.0f)));
                this.f6768a.layout(i6, (int) (rectF2.bottom + ((float) this.f6771d)), this.f6768a.getMeasuredWidth() + i6, Math.min((int) ((rectF2.bottom + ((float) this.f6768a.getMeasuredHeight())) + ((float) this.f6771d)), i4));
            }
        }
    }

    /* renamed from: a */
    protected AnimationSet m9923a(int i, boolean z) {
        if (z) {
            float left = (((float) i) - ((float) getLeft())) / ((float) getWidth());
            AnimationSet animationSet = new AnimationSet(false);
            Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, left, 1, 1.0f);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            scaleAnimation.setDuration((long) this.f6769b);
            scaleAnimation.setInterpolator(new OvershootInterpolator(1.2f));
            alphaAnimation.setDuration((long) this.f6769b);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration((long) this.f6769b);
            return animationSet;
        }
        left = (((float) i) - ((float) getLeft())) / ((float) getWidth());
        animationSet = new AnimationSet(false);
        scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, left, 1, 0.0f);
        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        scaleAnimation.setDuration((long) this.f6769b);
        scaleAnimation.setInterpolator(new OvershootInterpolator(1.2f));
        alphaAnimation.setDuration((long) this.f6769b);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration((long) this.f6769b);
        return animationSet;
    }

    protected View getBubbleView() {
        return this.f6768a;
    }
}
