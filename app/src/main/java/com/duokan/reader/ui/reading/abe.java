package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.fx;
import com.duokan.reader.ui.general.fz;
import fi.harism.curl.CurlAnchor;
import fi.harism.curl.CurlPageView;
import fi.harism.curl.CurlViewMode;

public class abe extends ActivatedController {
    /* renamed from: a */
    private final su f9379a;
    /* renamed from: b */
    private final wy f9380b;
    /* renamed from: c */
    private final fs f9381c;
    /* renamed from: d */
    private final CurlPageView f9382d;
    /* renamed from: e */
    private final abq f9383e = new abq();
    /* renamed from: f */
    private PageAnimationMode f9384f = PageAnimationMode.NONE;
    /* renamed from: g */
    private fx f9385g = null;
    /* renamed from: h */
    private fz f9386h = null;
    /* renamed from: i */
    private Runnable f9387i = null;
    /* renamed from: j */
    private Runnable f9388j = null;
    /* renamed from: k */
    private boolean f9389k = false;

    public abe(IFeature mFeature, su suVar, wy wyVar) {
        super(mFeature);
        this.f9379a = suVar;
        this.f9380b = wyVar;
        this.f9381c = this.f9380b.getFlowPagesView();
        this.f9382d = this.f9380b.getCurlView();
        m13208b();
        m13214c(this.f9379a.mo2167o());
        m13239b(this.f9379a.aK());
        this.f9380b.m13649a(new abv(this));
        this.f9379a.mo2033a(new abf(this));
    }

    /* renamed from: a */
    public void m13233a() {
        if (m13223g()) {
            this.f9382d.destroy();
            this.f9383e.m13260d();
            m13211c();
            m13219e();
            m13214c(this.f9379a.mo2167o());
            m13209b(4);
        }
    }

    /* renamed from: a */
    public void m13237a(boolean z) {
        this.f9382d.setRtlMode(z);
    }

    /* renamed from: b */
    public void m13239b(boolean z) {
        float[] eyesSavingModeDensity = this.f9379a.mo2180v().getEyesSavingModeDensity();
        this.f9382d.setColorScale(eyesSavingModeDensity[0], eyesSavingModeDensity[1], eyesSavingModeDensity[2]);
    }

    /* renamed from: a */
    public boolean m13238a(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (!m13223g()) {
            return false;
        }
        m13213c(pointF, runnable, runnable2);
        return true;
    }

    /* renamed from: b */
    public boolean m13240b(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (!m13223g()) {
            return false;
        }
        m13216d(pointF, runnable, runnable2);
        return true;
    }

    /* renamed from: a */
    public void m13235a(fx fxVar) {
        this.f9385g = fxVar;
    }

    /* renamed from: a */
    public void m13236a(PageAnimationMode pageAnimationMode) {
        if (this.f9384f != pageAnimationMode) {
            this.f9384f = pageAnimationMode;
            if (this.f9384f == PageAnimationMode.THREE_DIMEN) {
                m13220f().m10016d(false);
                m13211c();
                this.f9382d.setVisibility(0);
            } else {
                m13220f().m10016d(true);
                this.f9383e.m13260d();
                this.f9382d.setVisibility(4);
            }
            m13214c(this.f9379a.mo2167o());
        }
    }

    /* renamed from: a */
    public void m13234a(Bitmap bitmap) {
        if (m13223g()) {
            this.f9383e.m13257a(C0544a.m2446b(bitmap));
        }
    }

    protected void onTrimMemory(int i) {
        if (i >= 40) {
            this.f9383e.m13259c();
        }
        super.onTrimMemory(i);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        this.f9383e.m13260d();
        super.onDetachFromStub();
    }

    /* renamed from: b */
    private void m13208b() {
        this.f9382d.setPageProvider(new abg(this));
        m13219e();
    }

    /* renamed from: c */
    private void m13214c(boolean z) {
        this.f9382d.setViewMode(z ? CurlViewMode.SHOW_TOW_PAGE : CurlViewMode.SHOW_ONE_PAGE);
    }

    /* renamed from: c */
    private void m13211c() {
        m13234a(((sh) this.f9379a.mo2002S()).m14968a());
    }

    /* renamed from: d */
    private void m13215d() {
        as aa = this.f9379a.aa();
        if (aa != null) {
            CurlAnchor curlAnchor = new CurlAnchor();
            if (aa instanceof C0941i) {
                curlAnchor.mPageDrawable = ((C0941i) aa).mo1305b();
            } else {
                curlAnchor.mPageDrawable = aa;
            }
            this.f9382d.setCurrentPageAnchor(curlAnchor);
        }
    }

    /* renamed from: e */
    private void m13219e() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int a = (((this.f9379a.mo2167o() ? 4 : 2) * C0544a.m2425a(displayMetrics.widthPixels, displayMetrics.heightPixels, Config.RGB_565)) / 1024) / 1024;
        float maxMemory = (float) ((Runtime.getRuntime().maxMemory() / 1024) / 1024);
        float totalMemory = (float) ((int) ((Runtime.getRuntime().totalMemory() / 1024) / 1024));
        this.f9382d.setAnimationQuality(Math.round((((float) Math.pow((double) (((((float) a) / maxMemory) * (((float) ((int) ((Runtime.getRuntime().freeMemory() / 1024) / 1024))) / totalMemory)) * (1.0f - (totalMemory / maxMemory))), 0.0d)) * 12.0f) + 8.0f));
    }

    /* renamed from: a */
    private void m13204a(int i) {
        if (this.f9379a.mo2009Z() != null) {
            this.f9383e.m13256a(i);
        }
    }

    /* renamed from: f */
    private fs m13220f() {
        return this.f9381c;
    }

    /* renamed from: b */
    private void m13209b(int i) {
        if (i == 0) {
            this.f9388j = new abn(this);
            if (this.f9382d.getVisibility() == 0) {
                this.f9387i.run();
                this.f9387i = null;
                return;
            }
            return;
        }
        m13220f().m14139e(true);
    }

    /* renamed from: g */
    private boolean m13223g() {
        return this.f9384f == PageAnimationMode.THREE_DIMEN && this.f9380b.getShowingPagesView() == m13220f();
    }

    /* renamed from: c */
    private void m13213c(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (!this.f9389k) {
            if (this.f9379a.aw()) {
                m13228j();
            } else if (m13226i()) {
                this.f9387i = new abo(this, pointF, runnable, runnable2);
                m13212c(-1);
            } else if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    /* renamed from: d */
    private void m13216d(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (!this.f9389k) {
            if (this.f9379a.ax()) {
                m13230k();
            } else if (m13224h()) {
                this.f9387i = new abp(this, pointF, runnable, runnable2);
                m13212c(1);
            } else if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    /* renamed from: h */
    private boolean m13224h() {
        if (this.f9386h != null) {
            return this.f9386h.m10679a(m13220f(), m13220f().getCurrentPagePresenter());
        }
        return true;
    }

    /* renamed from: i */
    private boolean m13226i() {
        if (this.f9386h != null) {
            return this.f9386h.m10680b(m13220f(), m13220f().getCurrentPagePresenter());
        }
        return true;
    }

    /* renamed from: j */
    private void m13228j() {
        if (this.f9385g != null) {
            this.f9385g.mo2478a(m13220f());
        }
    }

    /* renamed from: k */
    private void m13230k() {
        if (this.f9385g != null) {
            this.f9385g.mo2480b(m13220f());
        }
    }

    /* renamed from: l */
    private void m13232l() {
        this.f9387i = null;
        this.f9388j = null;
        m13209b(4);
        this.f9383e.m13258b();
        this.f9389k = false;
    }

    /* renamed from: c */
    private void m13212c(int i) {
        this.f9389k = true;
        m13215d();
        this.f9379a.mo2040a(1, 0);
        m13204a(i);
        m13209b(0);
    }
}
