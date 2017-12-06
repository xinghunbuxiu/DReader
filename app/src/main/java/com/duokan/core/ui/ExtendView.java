package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

import com.duokan.core.sys.TaskHandler;

public class ExtendView extends FrameLayout {
    private Drawable drawable;
    private final Rect rect;
    private final Rect rect1;
    private Animation animation;

    public ExtendView(Context context) {
        this(context, null);
    }

    public ExtendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rect = new Rect();
        this.rect1 = new Rect();
        this.animation = null;
        setWillNotDraw(false);
    }

    public Drawable getBackground() {
        return this.drawable;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.drawable != drawable) {
            this.drawable = drawable;
            setBackground();
        }
    }

    public void draw(Canvas canvas) {
        if (this.animation != null) {
            if (!this.animation.hasStarted()) {
                this.animation.start();
                invalidate();
            } else if (!this.animation.hasEnded()) {
                invalidate(this.rect);
            }
            Transformation transformation = (Transformation) UTools.c.getRect();
            this.animation.getTransformation(getDrawingTime(), transformation);
            this.rect.left = Math.round((((float) this.rect1.left) + (((float) (getLeft() - this.rect1.left)) * transformation.getAlpha())) - ((float) getLeft()));
            this.rect.top = Math.round((((float) this.rect1.top) + (((float) (getTop() - this.rect1.top)) * transformation.getAlpha())) - ((float) getTop()));
            this.rect.right = Math.round((((float) this.rect1.right) + (((float) (getRight() - this.rect1.right)) * transformation.getAlpha())) - ((float) getLeft()));
            this.rect.bottom = Math.round((((float) this.rect1.bottom) + (((float) (getBottom() - this.rect1.bottom)) * transformation.getAlpha())) - ((float) getTop()));
            UTools.c.getRect(transformation);
        } else {
            this.rect.set(0, 0, getWidth(), getHeight());
        }
        super.draw(canvas);
    }

    protected boolean drawChild(Canvas canvas, View view, long time) {
        canvas.save();
        canvas.clipRect(this.rect.left + getPaddingLeft(), this.rect.top + getPaddingTop(), this.rect.right - getPaddingRight(), this.rect.bottom - getPaddingBottom());
        boolean drawChild = super.drawChild(canvas, view, time);
        canvas.restore();
        return drawChild;
    }

    public void requestLayout() {
        if (!(this.animation != null || getWindowToken() == null || isLayoutRequested() || getParent().isLayoutRequested())) {
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.initialize(0, 0, 0, 0);
            alphaAnimation.setDuration(200);
            this.rect1.set(getLeft(), getTop(), getRight(), getBottom());
            this.animation = alphaAnimation;
            this.animation.setAnimationListener(new MyAnimation(this));
        }
        super.requestLayout();
    }

    private void setBackground() {
        if (this.drawable == null) {
            super.setBackgroundDrawable(null);
        } else {
            super.setBackgroundDrawable(new MyDrawable(this, this.drawable, 0));
        }
    }

    class MyDrawable extends InsetDrawable {
        final ExtendView extendView;

        public MyDrawable(ExtendView extendView, Drawable drawable, int i) {
            super(drawable, i);
            this.extendView = extendView;
        }

        public void draw(Canvas canvas) {
            this.extendView.drawable.setBounds(this.extendView.rect);
            this.extendView.drawable.draw(canvas);
        }
    }

    class MyAnimation implements Animation.AnimationListener {
        final ExtendView a;

        MyAnimation(ExtendView extendView) {
            this.a = extendView;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            TaskHandler.PostTask(new Run(this));
        }
    }
    class Run implements Runnable {
        final MyAnimation animation1;

        Run(MyAnimation nVar) {
            this.animation1 = nVar;
        }

        public void run() {
            this.animation1.a.animation = null;
        }
    }
}
