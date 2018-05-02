package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.ui.personal.c */
public class C1393c extends ActivatedController implements hv {
    /* renamed from: a */
    private final C1396e f8388a = new C1396e(getContext(), this);

    public C1393c(IFeature mFeature) {
        super(mFeature);
        setContentView(this.f8388a);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8388a.f_();
        }
    }

    protected boolean onBack() {
        if (this.f8388a == null || !this.f8388a.m11529j()) {
            return super.onBack();
        }
        return true;
    }

    /* renamed from: a */
    public void mo1878a(int i, int i2) {
        this.f8388a.mo2231c(i, i2);
    }

    /* renamed from: b */
    public void mo1880b() {
        this.f8388a.mo2232q();
    }

    /* renamed from: c */
    public void mo1882c() {
        this.f8388a.m11532m();
    }

    /* renamed from: d */
    public void mo1883d() {
        this.f8388a.m11533n();
    }

    /* renamed from: a */
    public void mo1879a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(C0258j.personal__auto_buy_view__delete_multiple);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__ok);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new C1394d(this, runnable));
    }

    /* renamed from: e */
    public int mo1884e() {
        return this.f8388a.getSelectedCount();
    }

    /* renamed from: f */
    public void mo1885f() {
        this.f8388a.mo1891a();
    }

    /* renamed from: g */
    public boolean mo1886g() {
        return this.f8388a.mo1939c();
    }

    /* renamed from: h */
    public void mo1887h() {
        this.f8388a.mo1892b();
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
        return getString(C0258j.personal__auto_buy_view__delete_text);
    }
}
