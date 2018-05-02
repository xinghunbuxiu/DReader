package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.util.DisplayMetrics;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.i;
import com.duokan.reader.ui.general.gd;
import com.duokan.reader.ui.general.gf;

public class aar extends ActivatedController {
    private final sh a;
    private final wl b;
    private final fo c;
    private final CurlPageView d;
    private final abd e = new abd();
    private PageAnimationMode f = PageAnimationMode.NONE;
    private gd g = null;
    private gf h = null;
    private Runnable i = null;
    private Runnable j = null;
    private boolean k = false;

    public aar(IFeature featrue, sh shVar, wl wlVar) {
        super(featrue);
        this.a = shVar;
        this.b = wlVar;
        this.c = this.b.getFlowPagesView();
        this.d = this.b.getCurlView();
        b();
        c(this.a.o());
        b(this.a.aK());
        this.b.a(new abi(this));
        this.a.a(new aas(this));
    }

    public void a() {
        if (g()) {
            this.d.destroy();
            this.e.d();
            c();
            e();
            c(this.a.o());
            b(4);
        }
    }

    public void a(boolean z) {
        this.d.setRtlMode(z);
    }

    public void b(boolean z) {
        float[] eyesSavingModeDensity = this.a.v().getEyesSavingModeDensity();
        this.d.setColorScale(eyesSavingModeDensity[0], eyesSavingModeDensity[1], eyesSavingModeDensity[2]);
    }

    public boolean a(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (!g()) {
            return false;
        }
        c(pointF, runnable, runnable2);
        return true;
    }

    public boolean b(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (!g()) {
            return false;
        }
        d(pointF, runnable, runnable2);
        return true;
    }

    public void a(gd gdVar) {
        this.g = gdVar;
    }

    public void a(PageAnimationMode pageAnimationMode) {
        if (this.f != pageAnimationMode) {
            this.f = pageAnimationMode;
            if (this.f == PageAnimationMode.THREE_DIMEN) {
                f().d(false);
                c();
                this.d.setVisibility(0);
            } else {
                f().d(true);
                this.e.d();
                this.d.setVisibility(4);
            }
            c(this.a.o());
        }
    }

    public void a(Bitmap bitmap) {
        if (g()) {
            this.e.a(a.b(bitmap));
        }
    }

    protected void onTrimMemory(int i) {
        if (i >= 40) {
            this.e.c();
        }
        super.onTrimMemory(i);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        this.e.d();
        super.onDetachFromStub();
    }

    private void b() {
        this.d.setPageProvider(new aat(this));
        e();
    }

    private void c(boolean z) {
        this.d.setViewMode(z ? CurlViewMode.SHOW_TOW_PAGE : CurlViewMode.SHOW_ONE_PAGE);
    }

    private void c() {
        a(((rw) this.a.S()).a());
    }

    private void d() {
        as aa = this.a.aa();
        if (aa != null) {
            CurlAnchor curlAnchor = new CurlAnchor();
            if (aa instanceof i) {
                curlAnchor.mPageDrawable = ((i) aa).b();
            } else {
                curlAnchor.mPageDrawable = aa;
            }
            this.d.setCurrentPageAnchor(curlAnchor);
        }
    }

    private void e() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int a = (((this.a.o() ? 4 : 2) * a.a(displayMetrics.widthPixels, displayMetrics.heightPixels, Config.RGB_565)) / 1024) / 1024;
        float maxMemory = (float) ((Runtime.getRuntime().maxMemory() / 1024) / 1024);
        float totalMemory = (float) ((int) ((Runtime.getRuntime().totalMemory() / 1024) / 1024));
        this.d.setAnimationQuality(Math.round((((float) Math.pow((double) (((((float) a) / maxMemory) * (((float) ((int) ((Runtime.getRuntime().freeMemory() / 1024) / 1024))) / totalMemory)) * (1.0f - (totalMemory / maxMemory))), 0.0d)) * 12.0f) + 8.0f));
    }

    private void a(int i) {
        if (this.a.Z() != null) {
            this.e.a(i);
        }
    }

    private fo f() {
        return this.c;
    }

    private void b(int i) {
        if (i == 0) {
            this.j = new aba(this);
            if (this.d.getVisibility() == 0) {
                this.i.run();
                this.i = null;
                return;
            }
            return;
        }
        f().e(true);
    }

    private boolean g() {
        return this.f == PageAnimationMode.THREE_DIMEN && this.b.getShowingPagesView() == f();
    }

    private void c(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (!this.k) {
            if (this.a.aw()) {
                j();
            } else if (i()) {
                this.i = new abb(this, pointF, runnable, runnable2);
                c(-1);
            } else if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    private void d(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (!this.k) {
            if (this.a.ax()) {
                k();
            } else if (h()) {
                this.i = new abc(this, pointF, runnable, runnable2);
                c(1);
            } else if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    private boolean h() {
        if (this.h != null) {
            return this.h.a(f(), f().getCurrentPagePresenter());
        }
        return true;
    }

    private boolean i() {
        if (this.h != null) {
            return this.h.b(f(), f().getCurrentPagePresenter());
        }
        return true;
    }

    private void j() {
        if (this.g != null) {
            this.g.a(f());
        }
    }

    private void k() {
        if (this.g != null) {
            this.g.b(f());
        }
    }

    private void l() {
        this.i = null;
        this.j = null;
        b(4);
        this.e.b();
        this.k = false;
    }

    private void c(int i) {
        this.k = true;
        d();
        this.a.a(1, 0);
        a(i);
        b(0);
    }
}
