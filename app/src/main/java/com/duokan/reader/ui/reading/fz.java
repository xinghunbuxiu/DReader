package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.ge;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.document.au;

public abstract class fz extends FrameLayout {
    /* renamed from: a */
    private final gs f10197a;
    /* renamed from: b */
    private final au f10198b;
    /* renamed from: c */
    private boolean f10199c = false;
    /* renamed from: d */
    private boolean f10200d = true;
    /* renamed from: e */
    private final Rect f10201e;
    /* renamed from: f */
    private gc f10202f;
    /* renamed from: g */
    private final Drawable f10203g;
    /* renamed from: h */
    private final gd f10204h;
    /* renamed from: i */
    private lk f10205i;

    /* renamed from: a */
    public abstract gd mo2403a(au auVar);

    public fz(Context context, gs gsVar, Rect rect, au auVar) {
        super(context);
        this.f10197a = gsVar;
        this.f10198b = auVar;
        setWillNotDraw(false);
        this.f10201e = rect;
        this.f10204h = mo2403a(auVar);
        addView(this.f10204h, new LayoutParams(-1, -1));
        this.f10203g = getResources().getDrawable(C0243e.reading__shared__pic_shadow_normal);
        this.f10204h.setEnabled(false);
        this.f10204h.setQuitRunnable(new ga(this));
    }

    public final gs getPagePresenter() {
        return this.f10197a;
    }

    public final au getImage() {
        return this.f10198b;
    }

    /* renamed from: a */
    public boolean mo2467a() {
        return true;
    }

    /* renamed from: b */
    public boolean mo2468b() {
        return true;
    }

    /* renamed from: c */
    public boolean mo2469c() {
        return true;
    }

    public final Rect getOriginBounds() {
        return this.f10201e;
    }

    public float getZoomFactor() {
        return this.f10204h.getZoomFactor();
    }

    public float getZoomAngle() {
        return this.f10204h.getZoomAngle();
    }

    public gd getWatchingView() {
        return this.f10204h;
    }

    public final void setImageBrowser(lk lkVar) {
        this.f10205i = lkVar;
    }

    public void setZoomListener(ge geVar) {
        this.f10204h.setOnZoomListener(geVar);
    }

    /* renamed from: d */
    public void mo2470d() {
        mo2407l();
    }

    /* renamed from: e */
    public void mo2471e() {
        mo2406k();
    }

    /* renamed from: f */
    public final void m14173f() {
        this.f10204h.mo2334d();
    }

    /* renamed from: g */
    public final void m14174g() {
        this.f10204h.mo2335e();
    }

    /* renamed from: h */
    public final void m14175h() {
        mo2408m();
        this.f10204h.mo2412f();
    }

    /* renamed from: i */
    public final void m14176i() {
        mo2471e();
        this.f10199c = true;
        this.f10204h.mo2413g();
        this.f10204h.setEnabled(true);
    }

    /* renamed from: j */
    public final void m14177j() {
        this.f10199c = false;
        this.f10204h.mo2414h();
        this.f10204h.setEnabled(false);
    }

    /* renamed from: a */
    public void mo2435a(int i, boolean z) {
        this.f10204h.mo2410a(i, z);
        if (this.f10202f != null) {
            this.f10202f.setVisibility(4);
            dv.m1921a(this.f10202f, new gb(this));
        }
    }

    /* renamed from: k */
    public void mo2406k() {
        if (this.f10202f != null) {
            this.f10202f.m10198a();
        }
    }

    /* renamed from: l */
    public void mo2407l() {
        if (this.f10202f != null) {
            this.f10202f.m10199b();
        }
    }

    /* renamed from: m */
    public void mo2408m() {
        if (this.f10202f != null) {
            this.f10202f.m10200c();
        }
    }

    /* renamed from: n */
    public void mo2409n() {
        if (this.f10202f != null) {
            this.f10202f.m10201d();
        }
    }

    /* renamed from: o */
    protected final boolean m14182o() {
        return this.f10199c;
    }

    /* renamed from: a */
    protected void mo2436a(Runnable runnable) {
        this.f10204h.mo2411a(runnable);
    }

    /* renamed from: p */
    protected final void m14183p() {
        if (this.f10205i != null) {
            this.f10205i.mo2337d(this);
        }
    }

    /* renamed from: q */
    protected final void m14184q() {
        if (this.f10205i != null) {
            this.f10205i.mo2336c(this);
        }
    }

    protected final void setDrawBorder(boolean z) {
        this.f10200d = z;
    }

    /* renamed from: a */
    protected final void m14166a(View view, LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2;
        if (this.f10202f == null) {
            this.f10202f = new gc(this, getContext());
            addView(this.f10202f, new LayoutParams(-1, -2, 80));
        }
        this.f10202f.removeAllViews();
        gc gcVar = this.f10202f;
        if (layoutParams2 == null) {
            layoutParams2 = new LayoutParams(-1, -2);
        }
        gcVar.addView(view, layoutParams2);
        this.f10202f.m10200c();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f10199c && this.f10200d) {
            Rect rect = new Rect(0, 0, getWidth(), getHeight());
            rect.inset(-21, -21);
            this.f10203g.setBounds(rect);
            this.f10203g.draw(canvas);
        }
    }
}
