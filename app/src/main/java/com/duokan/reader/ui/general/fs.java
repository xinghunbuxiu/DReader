package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.ui.dt;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.core.ui.q;

class fs extends er {
    final /* synthetic */ PagesController a;
    private final dt c;
    private final q d;
    private PointF e;
    private float f;
    private boolean g;
    private boolean h;

    private fs(PagesController pagesController) {
        this.a = pagesController;
        this.c = new dt();
        this.d = new q();
        this.e = new PointF(0.0f, 0.0f);
        this.f = 0.0f;
        this.g = false;
        this.h = false;
    }

    protected void c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        a(view, motionEvent, z, esVar);
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
        this.c.a(UTools.getScaledTouchSlop(this.a.getContext()) * Math.round(this.a.getResources().getDisplayMetrics().density * 2.0f));
        this.c.a(2.0f);
        this.c.b(135.0f);
        this.c.c(225.0f);
        this.d.b(view, z);
        this.d.a((float) a(view, 30));
        this.e = new PointF(0.0f, 0.0f);
        this.f = 0.0f;
        this.g = false;
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.a.i() <= this.a.f) {
            b(false);
        } else if (this.g) {
            this.d.b(view, motionEvent, z, new ft(this));
            if (!e()) {
                if (motionEvent.getActionMasked() == 1) {
                    int a = a(view, 20);
                    this.e.x = Float.compare(this.e.x, 0.0f) == 0 ? this.f : this.e.x;
                    if (this.e.x > ((float) a)) {
                        e(this.e, new PointF((float) a(view), 0.0f));
                    } else {
                        e(this.e, new PointF((float) (a(view) * -1), 0.0f));
                    }
                    this.g = false;
                    return;
                }
                this.c.b(view, motionEvent, z, new fu(this));
            }
        } else if (motionEvent.getPointerCount() > 1) {
            b(false);
        } else if (this.h) {
            b(false);
        } else if (!a()) {
            b(false);
        } else if (this.a.a(this.a.l())) {
            this.c.b(view, motionEvent, z, new fv(this));
            if (this.g) {
                a(view, motionEvent, z, esVar);
            }
        } else {
            b(false);
        }
    }

    private void e(PointF pointF, PointF pointF2) {
        int i = 0;
        fy l = this.a.l();
        if (l != null) {
            int width = l.getContentView().getWidth();
            int round = Math.round(pointF.x);
            boolean z = pointF2.x > 0.0f;
            if (pointF2.x > 0.0f) {
                i = width;
            } else if (pointF2.x < 0.0f) {
            }
            long abs = (long) ((Math.abs(((float) i) - ((float) round)) / ((float) width)) * 300.0f);
            this.h = true;
            a(l, round, i, abs, new fw(this, z));
        }
    }

    private void a(fy fyVar, int i, int i2, long j, AnimationListener animationListener) {
        Animation fxVar = new fx(this, (float) i, (float) i2, 0.0f, 0.0f, fyVar);
        fxVar.setDuration(j);
        fxVar.setFillAfter(true);
        fxVar.setFillEnabled(true);
        fxVar.setAnimationListener(animationListener);
        fyVar.getContentView().startAnimation(fxVar);
    }

    private boolean a() {
        if (this.a.h() != null && this.a.i() > 0) {
            return true;
        }
        return false;
    }
}
