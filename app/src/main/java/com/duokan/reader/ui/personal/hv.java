package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.gs;

public class hv extends gs implements com.duokan.reader.ui.bookshelf.hv {
    /* renamed from: a */
    private final hy f8673a = new hy(getContext(), this.f8674b, this);
    /* renamed from: b */
    private final nc f8674b = new fo();

    public hv(IFeature mFeature) {
        super(mFeature);
        setContentView(this.f8673a);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8673a.mo1924a(0, 30);
        }
    }

    protected boolean onBack() {
        if (this.f8673a == null || !this.f8673a.m11529j()) {
            return super.onBack();
        }
        return true;
    }

    /* renamed from: a */
    public void mo1878a(int i, int i2) {
        this.f8673a.mo2231c(i, i2);
    }

    /* renamed from: b */
    public void mo1880b() {
        this.f8673a.mo2232q();
    }

    /* renamed from: c */
    public void mo1882c() {
        this.f8673a.m11532m();
    }

    /* renamed from: d */
    public void mo1883d() {
        this.f8673a.m11533n();
    }

    /* renamed from: a */
    public void mo1879a(Runnable runnable) {
        if (getPopupCount() <= 0) {
            ap apVar = new ap(getContext());
            apVar.setPrompt(C0258j.personal__statistics_view__delete);
            apVar.setCancelLabel(C0258j.general__shared__cancel);
            apVar.setOkLabelResid(C0258j.general__shared__remove);
            apVar.setCancelOnBack(true);
            apVar.setCancelOnTouchOutside(false);
            apVar.open(new hw(this, runnable));
        }
    }

    /* renamed from: e */
    public int mo1884e() {
        return this.f8673a.getSelectedCount();
    }

    /* renamed from: f */
    public void mo1885f() {
        this.f8673a.mo1891a();
    }

    /* renamed from: g */
    public boolean mo1886g() {
        return this.f8673a.mo1939c();
    }

    /* renamed from: h */
    public void mo1887h() {
        this.f8673a.mo1892b();
    }

    /* renamed from: b */
    public void mo1881b(int i, int i2) {
    }

    /* renamed from: i */
    public String mo1888i() {
        return null;
    }

    /* renamed from: j */
    public String mo1889j() {
        return null;
    }

    /* renamed from: k */
    public String mo1890k() {
        return null;
    }
}
