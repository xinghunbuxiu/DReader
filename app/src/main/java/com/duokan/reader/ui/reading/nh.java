package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.core.ui.et;
import com.duokan.p024c.C0255g;
import com.duokan.reader.ui.reading.p054a.ag;
import com.duokan.reader.ui.reading.p054a.ak;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

public class nh extends ActivatedController implements ak {
    /* renamed from: a */
    private final su f10667a;
    /* renamed from: b */
    private final wy f10668b;
    /* renamed from: c */
    private final NavigationFrameView f10669c;
    /* renamed from: d */
    private final FrameLayout f10670d;
    /* renamed from: e */
    private final nu f10671e;
    /* renamed from: f */
    private final et f10672f = new et();
    /* renamed from: g */
    private boolean f10673g = false;
    /* renamed from: h */
    private boolean f10674h = true;
    /* renamed from: i */
    private int f10675i = 0;
    /* renamed from: j */
    private float[] f10676j = new float[]{0.5f, 0.1f};

    public nh(IFeature mFeature, wy wyVar) {
        super(mFeature);
        this.f10668b = wyVar;
        this.f10667a = (su) getContext().queryFeature(su.class);
        this.f10669c = (NavigationFrameView) wyVar.findViewById(C0255g.reading__reading_view__navigation_frame);
        this.f10670d = (FrameLayout) wyVar.findViewById(C0255g.reading__reading_view__navigation_content);
        this.f10672f.m2043a(false);
        this.f10672f.m2041a(new ag(this));
        this.f10669c.setViewGestureDetector(this.f10672f);
        this.f10669c.setSizeChangedListener(new ni(this));
        this.f10671e = new nu(getContext(), this.f10667a, new nj(this));
        this.f10670d.addView(this.f10671e, 0, new LayoutParams(-1, -1));
        setContentView(this.f10669c);
    }

    /* renamed from: a */
    public boolean m14743a() {
        return this.f10673g;
    }

    /* renamed from: b */
    public void m14744b() {
        if (!this.f10673g) {
            mo2448f();
            mo2446a(true);
            ((C1540p) getContext().queryFeature(C1540p.class)).mo2564a(getContext(), UserInput.SHOW_BOOK_NAVIGATION);
        }
    }

    /* renamed from: c */
    public void m14745c() {
        if (this.f10673g) {
            mo2448f();
            mo2446a(false);
        }
    }

    /* renamed from: d */
    public void m14746d() {
        this.f10671e.m14792b();
    }

    protected boolean onBack() {
        if (!m14743a()) {
            return super.onBack();
        }
        m14745c();
        return true;
    }

    /* renamed from: e */
    public boolean mo2447e() {
        return this.f10673g;
    }

    /* renamed from: f */
    public void mo2448f() {
        if (!(this.f10667a.mo2106b(1) || this.f10667a.mo2106b(2))) {
            this.f10667a.mo2040a(1, 0);
        }
        if (this.f10673g) {
            this.f10667a.aN();
            this.f10675i = this.f10671e.getWidth();
            m14730a(-this.f10675i, -this.f10675i, 0, 0, 0, null);
            return;
        }
        this.f10671e.m14790a();
        this.f10669c.setVisibility(0);
        this.f10675i = 0;
        m14730a(this.f10675i, this.f10675i, this.f10671e.getWidth(), this.f10671e.getWidth(), 0, null);
    }

    /* renamed from: a */
    public void mo2444a(float f, float f2) {
        ((C1540p) getContext().queryFeature(C1540p.class)).mo2564a(getContext(), UserInput.SHOW_BOOK_NAVIGATION_GESTURE);
        this.f10675i = Math.min(this.f10671e.getWidth(), Math.max(0, this.f10675i + ((int) f)));
        m14730a(-this.f10675i, -this.f10675i, this.f10671e.getWidth() - this.f10675i, this.f10671e.getWidth() - this.f10675i, 0, null);
    }

    /* renamed from: a */
    public void mo2446a(boolean z) {
        Runnable nmVar = new nm(this);
        this.f10673g = z;
        if (this.f10673g) {
            int i = -this.f10675i;
            int i2 = -this.f10671e.getWidth();
            int width = this.f10671e.getWidth() - this.f10675i;
            m14730a(i, i2, width, 0, Math.round(((((float) (this.f10671e.getWidth() - this.f10675i)) * 1.0f) / ((float) this.f10671e.getWidth())) * 300.0f), nmVar);
            return;
        }
        int i3 = 0;
        m14730a(-this.f10675i, i3, this.f10671e.getWidth() - this.f10675i, this.f10671e.getWidth(), Math.round(((((float) this.f10675i) * 1.0f) / ((float) this.f10671e.getWidth())) * 300.0f), nmVar);
    }

    /* renamed from: a */
    public void mo2445a(er erVar, View view, PointF pointF) {
        if (this.f10673g && pointF.x > ((float) m14738g())) {
            m14745c();
        }
    }

    /* renamed from: g */
    private int m14738g() {
        return this.f10669c.getWidth() - this.f10669c.getPaddingRight();
    }

    /* renamed from: a */
    private void m14729a(int i) {
        nq nqVar;
        int argb = Color.argb((int) ((this.f10676j[1] + (((((float) Math.abs(i)) * 1.0f) / ((float) m14738g())) * (this.f10676j[0] - this.f10676j[1]))) * 255.0f), 0, 0, 0);
        if (this.f10668b.getForeground() instanceof nq) {
            nqVar = (nq) this.f10668b.getForeground();
        } else {
            nqVar = new nq();
            this.f10668b.setForeground(nqVar);
        }
        nqVar.m14762a(i, argb);
    }

    /* renamed from: a */
    private void m14730a(int i, int i2, int i3, int i4, int i5, Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.initialize(0, 0, 0, 0);
        alphaAnimation.setDuration((long) i5);
        alphaAnimation.setAnimationListener(new no(this, runnable));
        Runnable npVar = new np(this, alphaAnimation, i, i2, i3, i4);
        if (this.f10669c.isLayoutRequested()) {
            AnimUtils.m1921a(this.f10669c, npVar);
        } else {
            npVar.run();
        }
    }
}
