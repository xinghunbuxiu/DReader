package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.push.C0856a;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.cloud.push.C0876u;
import com.duokan.reader.ui.bookshelf.hv;
import java.util.ArrayList;

public class ck extends ActivatedController implements C0856a, hv {
    /* renamed from: a */
    private final cm f8401a = new cm(this, getContext(), this);
    /* renamed from: b */
    private final ArrayList<C0876u> f8402b = new ArrayList();

    public ck(IFeature mFeature) {
        super(mFeature);
        setContentView(this.f8401a);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8401a.m11523b(true);
            m11584l();
            C0857b.m5649a().m5681a((C0856a) this);
        } else {
            this.f8401a.m11523b(true);
            m11584l();
            C0857b.m5649a().m5681a((C0856a) this);
        }
    }

    protected void onDeactive() {
        C0857b.m5649a().m5687b((C0856a) this);
        super.onDeactive();
    }

    /* renamed from: a */
    public void mo1594a() {
        if (C0857b.m5649a().m5689c() > 0) {
            this.f8401a.m11602a(0, 0);
            m11584l();
        }
    }

    /* renamed from: l */
    private void m11584l() {
        getContentView().postDelayed(new cl(this), 3000);
    }

    /* renamed from: a */
    public void mo1878a(int i, int i2) {
        this.f8401a.mo2231c(i, i2);
    }

    /* renamed from: b */
    public void mo1880b() {
        this.f8401a.mo2232q();
    }

    /* renamed from: c */
    public void mo1882c() {
        this.f8401a.m11532m();
    }

    /* renamed from: d */
    public void mo1883d() {
        this.f8401a.m11533n();
    }

    /* renamed from: a */
    public void mo1879a(Runnable runnable) {
        this.f8401a.m11605a(runnable);
    }

    /* renamed from: e */
    public int mo1884e() {
        return this.f8401a.getSelectedCount();
    }

    /* renamed from: f */
    public void mo1885f() {
        this.f8401a.mo1891a();
    }

    /* renamed from: g */
    public boolean mo1886g() {
        return this.f8401a.mo1939c();
    }

    /* renamed from: h */
    public void mo1887h() {
        this.f8401a.mo1892b();
    }

    /* renamed from: b */
    public void mo1881b(int i, int i2) {
        this.f8401a.m11522b(i, i2);
    }

    /* renamed from: i */
    public String mo1888i() {
        return getString(C0258j.personal__message_push_view__edit_title);
    }

    /* renamed from: j */
    public String mo1889j() {
        return getString(C0258j.personal__message_push_view__edit_selected);
    }

    /* renamed from: k */
    public String mo1890k() {
        return null;
    }
}
