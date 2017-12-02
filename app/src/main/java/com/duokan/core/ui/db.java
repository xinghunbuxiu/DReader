package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import com.duokan.core.sys.t;

class db extends BoxView {
    final /* synthetic */ cv b;

    public db(cv cvVar, Context context) {
        this.b = cvVar;
        super(context);
        setWillNotDraw(false);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.b.t != null && !this.b.hasRunningAnimation()) {
            t.b(this.b.t);
        }
    }

    public void draw(Canvas canvas) {
        float alpha;
        int i;
        if (this.b.q != null) {
            if (!this.b.q.hasStarted()) {
                this.b.q.start();
            }
            Transformation transformation = (Transformation) dv.c.a();
            this.b.q.getTransformation(AnimationUtils.currentAnimationTimeMillis(), transformation);
            alpha = transformation.getAlpha();
            dv.c.a(transformation);
            if (this.b.q.hasEnded()) {
                this.b.q = null;
                i = 0;
            } else {
                i = 1;
            }
        } else {
            this.b.q = null;
            alpha = this.b.p;
            i = 0;
        }
        if (Float.compare(alpha, 0.0f) > 0) {
            canvas.drawColor(Color.argb(Math.round(alpha * 255.0f), 0, 0, 0));
        }
        super.draw(canvas);
        if (i != 0) {
            invalidate();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        if ((motionEvent.getActionMasked() == 0 && this.b.checkTouchOutside((int) motionEvent.getX(), (int) motionEvent.getY()) && this.b.onTouchOutside()) || this.b.w) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            this.b.x = false;
        } else if (keyEvent.getAction() == 0) {
            this.b.x = true;
        }
        if (super.dispatchKeyEvent(keyEvent)) {
            this.b.x = false;
            return true;
        }
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.b.x) {
            this.b.x = false;
            if (this.b.onBack()) {
                return true;
            }
        }
        if (this.b.v) {
            return true;
        }
        return false;
    }
}
