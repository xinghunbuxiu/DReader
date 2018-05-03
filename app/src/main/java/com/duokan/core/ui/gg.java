package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.UThread;

public class gg implements Runnable {
    /* renamed from: a */
    static final /* synthetic */ boolean f1295a = (!ZoomView.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ ZoomView f1296b;
    /* renamed from: c */
    private final PointF f1297c = new PointF();
    /* renamed from: d */
    private final PointF f1298d = new PointF();
    /* renamed from: e */
    private final float f1299e;
    /* renamed from: f */
    private final float f1300f;
    /* renamed from: g */
    private final PointF f1301g = new PointF();
    /* renamed from: h */
    private final float f1302h;
    /* renamed from: i */
    private final float f1303i;
    /* renamed from: j */
    private final Runnable f1304j;
    /* renamed from: k */
    private final Runnable f1305k;
    /* renamed from: l */
    private final AlphaAnimation f1306l = new AlphaAnimation(0.0f, 1.0f);
    /* renamed from: m */
    private final Transformation f1307m = new Transformation();
    /* renamed from: n */
    private boolean f1308n = false;

    public gg(ZoomView zoomView, float f, float f2, float f3, float f4, float f5, float f6, Runnable runnable, Runnable runnable2) {
        this.f1296b = zoomView;
        View d = zoomView.mo2335e();
        if (f1295a || d != null) {
            this.f1297c.set(f, f2);
            this.f1298d.set(f, f2);
            AnimUtils.m1900a(this.f1298d, d, (View) zoomView);
            this.f1298d.offset((float) (-zoomView.getScrollX()), (float) (-zoomView.getScrollY()));
            this.f1299e = zoomView.getZoomFactor();
            this.f1300f = (float) AnimUtils.m1927b((double) zoomView.getZoomAngle(), (double) (f6 - 180.0f), (double) (180.0f + f6));
            this.f1301g.set(f3, f4);
            this.f1302h = f5;
            this.f1303i = f6;
            this.f1304j = runnable;
            this.f1305k = runnable2;
            this.f1306l.initialize(0, 0, 0, 0);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m2153a() {
        if (!this.f1308n && !this.f1306l.hasStarted()) {
            this.f1306l.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f1306l.setDuration(300);
            this.f1306l.start();
            UThread.post((Runnable) this);
        }
    }

    /* renamed from: b */
    public void m2154b() {
        if (!this.f1308n && this.f1306l.hasStarted() && !this.f1306l.hasEnded()) {
            this.f1308n = true;
            UIdleHandler.runAction(this.f1305k);
        }
    }

    public void run() {
        if (!this.f1308n) {
            View d = this.f1296b.mo2335e();
            if (d != null) {
                this.f1306l.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.f1307m);
                float alpha = this.f1298d.x + ((this.f1301g.x - this.f1298d.x) * this.f1307m.getAlpha());
                float alpha2 = this.f1298d.y + ((this.f1301g.y - this.f1298d.y) * this.f1307m.getAlpha());
                this.f1296b.m1331a(d, this.f1297c.x, this.f1297c.y, alpha, alpha2, this.f1299e + ((this.f1302h - this.f1299e) * this.f1307m.getAlpha()), this.f1300f + ((this.f1303i - this.f1300f) * this.f1307m.getAlpha()));
                if (this.f1306l.hasEnded()) {
                    UIdleHandler.runAction(this.f1304j);
                    return;
                } else {
                    UThread.post((Runnable) this);
                    return;
                }
            }
            UIdleHandler.runAction(this.f1304j);
        }
    }
}
