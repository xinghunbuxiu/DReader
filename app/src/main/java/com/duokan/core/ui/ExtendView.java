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

public class ExtendView extends FrameLayout {
    private Drawable a;
    private final Rect b;
    private final Rect c;
    private Animation d;

    public ExtendView(Context context) {
        this(context, null);
    }

    public ExtendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Rect();
        this.c = new Rect();
        this.d = null;
        setWillNotDraw(false);
    }

    public Drawable getBackground() {
        return this.a;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.a != drawable) {
            this.a = drawable;
            a();
        }
    }

    public void draw(Canvas canvas) {
        if (this.d != null) {
            if (!this.d.hasStarted()) {
                this.d.start();
                invalidate();
            } else if (!this.d.hasEnded()) {
                invalidate(this.b);
            }
            Transformation transformation = (Transformation) dv.c.a();
            this.d.getTransformation(getDrawingTime(), transformation);
            this.b.left = Math.round((((float) this.c.left) + (((float) (getLeft() - this.c.left)) * transformation.getAlpha())) - ((float) getLeft()));
            this.b.top = Math.round((((float) this.c.top) + (((float) (getTop() - this.c.top)) * transformation.getAlpha())) - ((float) getTop()));
            this.b.right = Math.round((((float) this.c.right) + (((float) (getRight() - this.c.right)) * transformation.getAlpha())) - ((float) getLeft()));
            this.b.bottom = Math.round((((float) this.c.bottom) + (((float) (getBottom() - this.c.bottom)) * transformation.getAlpha())) - ((float) getTop()));
            dv.c.a(transformation);
        } else {
            this.b.set(0, 0, getWidth(), getHeight());
        }
        super.draw(canvas);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        canvas.save();
        canvas.clipRect(this.b.left + getPaddingLeft(), this.b.top + getPaddingTop(), this.b.right - getPaddingRight(), this.b.bottom - getPaddingBottom());
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    public void requestLayout() {
        if (!(this.d != null || getWindowToken() == null || isLayoutRequested() || getParent().isLayoutRequested())) {
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.initialize(0, 0, 0, 0);
            alphaAnimation.setDuration(200);
            this.c.set(getLeft(), getTop(), getRight(), getBottom());
            this.d = alphaAnimation;
            this.d.setAnimationListener(new n(this));
        }
        super.requestLayout();
    }

    private void a() {
        if (this.a == null) {
            super.setBackgroundDrawable(null);
        } else {
            super.setBackgroundDrawable(new p(this, this.a, 0));
        }
    }
}
