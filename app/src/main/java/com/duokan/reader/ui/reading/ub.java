package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.af;
import com.duokan.p023b.C0244f;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.ui.general.gs;

abstract class ub extends gs implements SystemUiConditioner {
    /* renamed from: a */
    private Runnable f9673a = null;
    /* renamed from: e */
    protected final ReaderFeature f9674e = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    /* renamed from: f */
    protected final su f9675f = ((su) getContext().queryFeature(su.class));
    /* renamed from: g */
    protected final View f9676g;
    /* renamed from: h */
    protected boolean f9677h = false;

    /* renamed from: a */
    protected abstract View mo2256a();

    /* renamed from: a */
    protected abstract void mo2248a(ActivatedController c0303e);

    /* renamed from: b */
    protected abstract void mo2253b();

    /* renamed from: l */
    protected abstract boolean mo2251l();

    public ub(IFeature mFeature) {
        super(mFeature);
        setContentView(mo2256a());
        getContentView().setLayoutParams(new LayoutParams(-1, -1));
        this.f9676g = findViewById(C0244f.reading__reading_menu_bottom_view__night_mode);
        int headerPaddingTop = ((ReaderFeature) AppContext.getAppContext(getContext()).queryFeature(ReaderFeature.class)).getTheme().getHeaderPaddingTop();
        View findViewById = findViewById(C0244f.reading__reading_menu_view__top);
        findViewById.setPadding(findViewById.getPaddingLeft(), headerPaddingTop, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        getContentView().setOnClickListener(new uc(this));
        findViewById(C0244f.reading__reading_menu_view__back).setOnClickListener(new ud(this));
        findViewById(C0244f.reading__reading_menu_bottom_view__navigation).setOnClickListener(new uf(this));
        this.f9676g.setOnClickListener(new uh(this));
        findViewById(C0244f.reading__reading_menu_bottom_view__more).setOnClickListener(new ui(this));
    }

    protected void onActive(boolean z) {
        mo2249c();
        this.f9674e.updateSystemUi(true);
        super.onActive(z);
    }

    protected void onDeactive() {
        super.onDeactive();
        this.f9674e.updateSystemUi(true);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f9674e.addSystemUiConditioner(this);
        this.f9675f.aS();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.f9674e.removeSystemUiConditioner(this);
        if (this.f9673a != null) {
            this.f9673a.run();
            this.f9673a = null;
        }
    }

    protected boolean onBack() {
        if (mo2251l() || ReaderEnv.get().hasPhysicalBackKey() || this.f9675f.an()) {
            requestDetach();
        } else {
            m13598a(new uj(this));
        }
        return true;
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        if (isActive()) {
            afVar.mo975a(Boolean.valueOf(false));
        }
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
        if (isActive()) {
            afVar.mo975a(SystemUiMode.VISIBLE);
        }
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
        afVar.mo975a(Integer.valueOf(-16777216));
    }

    /* renamed from: a */
    protected void m13598a(Runnable runnable) {
        this.f9673a = runnable;
        requestDetach();
    }

    /* renamed from: c */
    protected void mo2249c() {
        this.f9676g.setSelected(this.f9675f.aH());
    }
}
