package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

import com.duokan.core.sys.UThread;

public class ExtendView extends FrameLayout {
    private Drawable drawable;
    private final Rect rect;
    private final Rect rect1;
    private Animation alphaAnimation;

    public ExtendView(Context context) {
        this(context, null);
    }

    public ExtendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.rect1 = new Rect();
        this.alphaAnimation = null;
        setWillNotDraw(false);
    }

    public Drawable getBackground() {
        return this.drawable;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.drawable != drawable) {
            this.drawable = drawable;
            setBackgroundDrawable();
        }
    }

    public void draw(Canvas canvas) {
        if (this.alphaAnimation != null) {
            if (!this.alphaAnimation.hasStarted()) {
                this.alphaAnimation.start();
                invalidate();
            } else if (!this.alphaAnimation.hasEnded()) {
                invalidate(this.rect);
            }
            Transformation transformation = (Transformation) AnimUtils.f1194c.addAnimation();
            this.alphaAnimation.getTransformation(getDrawingTime(), transformation);
            this.rect.left = Math.round((((float) this.rect1.left) + (((float) (getLeft() - this.rect1.left)) * transformation.getAlpha())) - ((float) getLeft()));
            this.rect.top = Math.round((((float) this.rect1.top) + (((float) (getTop() - this.rect1.top)) * transformation.getAlpha())) - ((float) getTop()));
            this.rect.right = Math.round((((float) this.rect1.right) + (((float) (getRight() - this.rect1.right)) * transformation.getAlpha())) - ((float) getLeft()));
            this.rect.bottom = Math.round((((float) this.rect1.bottom) + (((float) (getBottom() - this.rect1.bottom)) * transformation.getAlpha())) - ((float) getTop()));
            AnimUtils.f1194c.clearAnimation(transformation);
        } else {
            this.rect.set(0, 0, getWidth(), getHeight());
        }
        super.draw(canvas);
    }

    @Override
    protected boolean drawChild(Canvas canvas, View view, long drawingTime) {
        canvas.save();
        canvas.clipRect(this.rect.left + getPaddingLeft(), this.rect.top + getPaddingTop(), this.rect.right - getPaddingRight(), this.rect.bottom - getPaddingBottom());
        boolean drawChild = super.drawChild(canvas, view, drawingTime);
        canvas.restore();
        return drawChild;
    }

    @Override
    public void requestLayout() {
        if (!(this.alphaAnimation != null || getWindowToken() == null || isLayoutRequested() || getParent().isLayoutRequested())) {
            this.alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.initialize(0, 0, 0, 0);
            alphaAnimation.setDuration(200);
            this.rect1.set(getLeft(), getTop(), getRight(), getBottom());
            this.alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    UThread.post(new Runnable() {
                        @Override
                        public void run() {
                            alphaAnimation = null;
                        }
                    });
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        super.requestLayout();
    }

    private void setBackgroundDrawable() {
        if (this.drawable == null) {
            super.setBackgroundDrawable(null);
        } else {
            super.setBackgroundDrawable(new C0391p(this, this.drawable, 0));
        }
    }
}
