package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.ui.C0392q;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

class fm extends er {
    /* renamed from: a */
    final /* synthetic */ PagesController f7240a;
    /* renamed from: c */
    private final dt f7241c;
    /* renamed from: d */
    private final C0392q f7242d;
    /* renamed from: e */
    private PointF f7243e;
    /* renamed from: f */
    private float f7244f;
    /* renamed from: g */
    private boolean f7245g;
    /* renamed from: h */
    private boolean f7246h;

    private fm(PagesController pagesController) {
        this.f7240a = pagesController;
        this.f7241c = new dt();
        this.f7242d = new C0392q();
        this.f7243e = new PointF(0.0f, 0.0f);
        this.f7244f = 0.0f;
        this.f7245g = false;
        this.f7246h = false;
    }

    /* renamed from: c */
    protected void mo526c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        mo510a(view, motionEvent, z, esVar);
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        this.f7241c.m1612b(view, z);
        this.f7241c.m1882a(dv.getScaledTouchSlop(this.f7240a.getContext()) * Math.round(this.f7240a.getResources().getDisplayMetrics().density * 2.0f));
        this.f7241c.m1881a(2.0f);
        this.f7241c.m1885b(135.0f);
        this.f7241c.m1887c(225.0f);
        this.f7242d.m1612b(view, z);
        this.f7242d.m2168a((float) m1603a(view, 30));
        this.f7243e = new PointF(0.0f, 0.0f);
        this.f7244f = 0.0f;
        this.f7245g = false;
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (this.f7240a.m9241h() <= this.f7240a.f6188f) {
            m1613b(false);
        } else if (this.f7245g) {
            this.f7242d.m1611b(view, motionEvent, z, new fn(this));
            if (!m1623e()) {
                if (motionEvent.getActionMasked() == 1) {
                    int a = m1603a(view, 20);
                    this.f7243e.x = Float.compare(this.f7243e.x, 0.0f) == 0 ? this.f7244f : this.f7243e.x;
                    if (this.f7243e.x > ((float) a)) {
                        m10663e(this.f7243e, new PointF((float) m1602a(view), 0.0f));
                    } else {
                        m10663e(this.f7243e, new PointF((float) (m1602a(view) * -1), 0.0f));
                    }
                    this.f7245g = false;
                    return;
                }
                this.f7241c.m1611b(view, motionEvent, z, new fo(this));
            }
        } else if (motionEvent.getPointerCount() > 1) {
            m1613b(false);
        } else if (this.f7246h) {
            m1613b(false);
        } else if (!m10657a()) {
            m1613b(false);
        } else if (this.f7240a.mo1860a(this.f7240a.m9244k())) {
            this.f7241c.m1611b(view, motionEvent, z, new fp(this));
            if (this.f7245g) {
                mo510a(view, motionEvent, z, esVar);
            }
        } else {
            m1613b(false);
        }
    }

    /* renamed from: e */
    private void m10663e(PointF pointF, PointF pointF2) {
        int i = 0;
        fs k = this.f7240a.m9244k();
        if (k != null) {
            int width = k.getContentView().getWidth();
            int round = Math.round(pointF.x);
            boolean z = pointF2.x > 0.0f;
            if (pointF2.x > 0.0f) {
                i = width;
            } else if (pointF2.x < 0.0f) {
            }
            long abs = (long) ((Math.abs(((float) i) - ((float) round)) / ((float) width)) * 300.0f);
            this.f7246h = true;
            m10656a(k, round, i, abs, new fq(this, z));
        }
    }

    /* renamed from: a */
    private void m10656a(fs fsVar, int i, int i2, long j, AnimationListener animationListener) {
        Animation frVar = new fr(this, (float) i, (float) i2, 0.0f, 0.0f, fsVar);
        frVar.setDuration(j);
        frVar.setFillAfter(true);
        frVar.setFillEnabled(true);
        frVar.setAnimationListener(animationListener);
        fsVar.getContentView().startAnimation(frVar);
    }

    /* renamed from: a */
    private boolean m10657a() {
        if (this.f7240a.m9239g() != null && this.f7240a.m9241h() > 0) {
            return true;
        }
        return false;
    }
}
