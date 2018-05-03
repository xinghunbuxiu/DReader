package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.ge;
import com.duokan.reader.domain.document.aj;

public class nf extends gd implements mx {
    /* renamed from: c */
    static final /* synthetic */ boolean f10660c = (!nf.class.desiredAssertionStatus());
    /* renamed from: b */
    private boolean f10661b = false;
    /* renamed from: d */
    private ge f10662d;
    /* renamed from: e */
    private mo f10663e;
    /* renamed from: f */
    private na f10664f;

    public nf(Context context, aj ajVar) {
        super(context);
        this.f10663e = new mo(context, ajVar, this);
        m14203a(this.f10663e, null);
        super.setOnZoomListener(new ng(this));
    }

    public void setTopLayerAssistant(na naVar) {
        this.f10664f = naVar;
    }

    public void setOnZoomListener(ge geVar) {
        this.f10662d = geVar;
    }

    /* renamed from: a */
    public void mo2411a(Runnable runnable) {
        super.mo2411a(runnable);
        this.f10663e.m14668a();
        if (f10660c || this.f10664f != null) {
            this.f10664f.mo2432a(-1);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: j */
    public void mo2443j() {
        this.f10663e.m14669a(-1);
    }

    /* renamed from: d */
    public void mo2334d() {
        super.mo2334d();
        if (f10660c || this.f10664f != null) {
            this.f10661b = true;
            this.f10664f.mo2434c();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: e */
    public void mo2335e() {
        super.mo2335e();
        this.f10663e.setShowClearImage(true);
    }

    /* renamed from: f */
    public void mo2412f() {
        super.mo2412f();
        this.f10663e.setShowClearImage(false);
    }

    /* renamed from: h */
    public void mo2414h() {
        super.mo2414h();
        if (f10660c || this.f10664f != null) {
            this.f10661b = false;
            this.f10664f.mo2431a();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: g */
    public void mo2413g() {
        super.mo2413g();
        if (f10660c || this.f10664f != null) {
            this.f10661b = false;
            this.f10664f.mo2431a();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo2410a(int i, boolean z) {
        this.f10663e.m14668a();
        super.mo2410a(i, z);
    }

    /* renamed from: a */
    protected boolean mo2441a(PointF pointF) {
        if (this.f10663e.m14670a(AnimUtils.m1900a(new PointF(pointF.x + ((float) getScrollX()), pointF.y + ((float) getScrollY())), (View) this, this.f10663e))) {
            return true;
        }
        return super.mo2441a(pointF);
    }

    /* renamed from: a */
    public void mo2438a() {
        this.f10663e.m14672c();
    }

    /* renamed from: b */
    public void mo2442b() {
        this.f10663e.m14671b();
    }

    /* renamed from: a */
    public void mo2439a(int i) {
        this.f10663e.m14669a(i);
    }

    /* renamed from: a */
    public PointF mo2437a(View view, int i) {
        return this.f10663e.m14667a(view, i);
    }

    /* renamed from: a */
    public void mo2440a(int i, float f, float f2, float f3) {
        if (f10660c || this.f10664f != null) {
            this.f10664f.mo2432a(i);
            m1360b(f2, f3, f * mo2421i(), null, null);
            return;
        }
        throw new AssertionError();
    }
}
