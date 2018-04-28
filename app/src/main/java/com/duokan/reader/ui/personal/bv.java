package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.bookshelf.hv;

public class bv extends ActivatedController implements hv {
    /* renamed from: a */
    private final bw f8366a = new bw(getContext(), this);

    public bv(IFeature mFeature) {
        super(mFeature);
        setContentView(this.f8366a);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8366a.m11523b(true);
        }
    }

    protected boolean onBack() {
        if (this.f8366a == null || !this.f8366a.m11529j()) {
            return super.onBack();
        }
        return true;
    }

    /* renamed from: a */
    public void mo1878a(int i, int i2) {
        this.f8366a.mo2231c(i, i2);
    }

    /* renamed from: b */
    public void mo1880b() {
        this.f8366a.mo2232q();
    }

    /* renamed from: c */
    public void mo1882c() {
        this.f8366a.m11532m();
    }

    /* renamed from: d */
    public void mo1883d() {
        this.f8366a.m11533n();
    }

    /* renamed from: a */
    public void mo1879a(Runnable runnable) {
        this.f8366a.m11542a(runnable);
    }

    /* renamed from: e */
    public int mo1884e() {
        return this.f8366a.getSelectedCount();
    }

    /* renamed from: f */
    public void mo1885f() {
        this.f8366a.mo1891a();
    }

    /* renamed from: g */
    public boolean mo1886g() {
        return this.f8366a.mo1939c();
    }

    /* renamed from: h */
    public void mo1887h() {
        this.f8366a.mo1892b();
    }

    /* renamed from: b */
    public void mo1881b(int i, int i2) {
        this.f8366a.m11522b(i, i2);
    }

    /* renamed from: i */
    public String mo1888i() {
        return getString(C0258j.personal__message_center_view__edit_title);
    }

    /* renamed from: j */
    public String mo1889j() {
        return getString(C0258j.personal__message_center_view__edit_selected);
    }

    /* renamed from: k */
    public String mo1890k() {
        return null;
    }
}
