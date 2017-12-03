package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import com.duokan.core.sys.TaskHandler;

public class gg implements Runnable {
    static final /* synthetic */ boolean a = (!ZoomView.class.desiredAssertionStatus());
    final /* synthetic */ ZoomView b;
    private final PointF c = new PointF();
    private final PointF d = new PointF();
    private final float e;
    private final float f;
    private final PointF g = new PointF();
    private final float h;
    private final float i;
    private final Runnable j;
    private final Runnable k;
    private final AlphaAnimation l = new AlphaAnimation(0.0f, 1.0f);
    private final Transformation m = new Transformation();
    private boolean n = false;

    public gg(ZoomView zoomView, float f, float f2, float f3, float f4, float f5, float f6, Runnable runnable, Runnable runnable2) {
        this.b = zoomView;
        View d = zoomView.e();
        if (a || d != null) {
            this.c.set(f, f2);
            this.d.set(f, f2);
            UTools.addAnimation(this.d, d, (View) zoomView);
            this.d.offset((float) (-zoomView.getScrollX()), (float) (-zoomView.getScrollY()));
            this.e = zoomView.getZoomFactor();
            this.f = (float) UTools.closeAnimation((double) zoomView.getZoomAngle(), (double) (f6 - 180.0f), (double) (180.0f + f6));
            this.g.set(f3, f4);
            this.h = f5;
            this.i = f6;
            this.j = runnable;
            this.k = runnable2;
            this.l.initialize(0, 0, 0, 0);
            return;
        }
        throw new AssertionError();
    }

    public void a() {
        if (!this.n && !this.l.hasStarted()) {
            this.l.setInterpolator(new AccelerateDecelerateInterpolator());
            this.l.setDuration(300);
            this.l.start();
            TaskHandler.PostTask((Runnable) this);
        }
    }

    public void b() {
        if (!this.n && this.l.hasStarted() && !this.l.hasEnded()) {
            this.n = true;
            j.a(this.k);
        }
    }

    public void run() {
        if (!this.n) {
            View d = this.b.e();
            if (d != null) {
                this.l.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.m);
                float alpha = this.d.x + ((this.g.x - this.d.x) * this.m.getAlpha());
                float alpha2 = this.d.y + ((this.g.y - this.d.y) * this.m.getAlpha());
                this.b.a(d, this.c.x, this.c.y, alpha, alpha2, this.e + ((this.h - this.e) * this.m.getAlpha()), this.f + ((this.i - this.f) * this.m.getAlpha()));
                if (this.l.hasEnded()) {
                    j.a(this.j);
                    return;
                } else {
                    TaskHandler.PostTask((Runnable) this);
                    return;
                }
            }
            j.a(this.j);
        }
    }
}
