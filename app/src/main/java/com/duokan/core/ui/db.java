package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.duokan.core.sys.UThread;

class db extends BoxView {
    /* renamed from: b */
    final /* synthetic */ cv f1128b;

    public db(cv cvVar, Context context) {
        this.f1128b = cvVar;
        super(context);
        setWillNotDraw(false);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f1128b.f1112t != null && !this.f1128b.hasRunningAnimation()) {
            UThread.post(this.f1128b.f1112t);
        }
    }

    public void draw(Canvas canvas) {
        float alpha;
        int i;
        if (this.f1128b.f1109q != null) {
            if (!this.f1128b.f1109q.hasStarted()) {
                this.f1128b.f1109q.start();
            }
            Transformation transformation = (Transformation) dv.f1194c.addAnimation();
            this.f1128b.f1109q.getTransformation(AnimationUtils.currentAnimationTimeMillis(), transformation);
            alpha = transformation.getAlpha();
            dv.f1194c.clearAnimation(transformation);
            if (this.f1128b.f1109q.hasEnded()) {
                this.f1128b.f1109q = null;
                i = 0;
            } else {
                i = 1;
            }
        } else {
            this.f1128b.f1109q = null;
            alpha = this.f1128b.f1108p;
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
        if ((motionEvent.getActionMasked() == 0 && this.f1128b.checkTouchOutside((int) motionEvent.getX(), (int) motionEvent.getY()) && this.f1128b.onTouchOutside()) || this.f1128b.f1115w) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            this.f1128b.f1116x = false;
        } else if (keyEvent.getAction() == 0) {
            this.f1128b.f1116x = true;
        }
        if (super.dispatchKeyEvent(keyEvent)) {
            this.f1128b.f1116x = false;
            return true;
        }
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.f1128b.f1116x) {
            this.f1128b.f1116x = false;
            if (this.f1128b.onBack()) {
                return true;
            }
        }
        if (this.f1128b.f1114v) {
            return true;
        }
        return false;
    }
}
