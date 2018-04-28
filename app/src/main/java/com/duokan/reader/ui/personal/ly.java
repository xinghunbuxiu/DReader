package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.ip;
import com.duokan.reader.domain.bookshelf.iq;
import com.duokan.reader.domain.cloud.C0840a;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.gs;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ly extends gs implements ip, iq, hv {
    /* renamed from: a */
    private mc f8915a;
    /* renamed from: b */
    private final String[] f8916b;
    /* renamed from: c */
    private lb f8917c;

    public ly(IFeature mFeature, C0840a c0840a, String[] strArr) {
        super(mFeature);
        this.f8916b = strArr;
        for (String a : this.f8916b) {
            c0840a = c0840a.m5257a(a);
        }
        this.f8917c = (lb) mFeature.queryFeature(lb.class);
        this.f8915a = new mc(getContext(), c0840a, this, new ks(getContext()));
        setContentView(this.f8915a);
        this.f8915a.getHeaderView().setOnBackListener(new lz(this));
    }

    /* renamed from: b */
    private void m12223b(List<DkCloudStoreBook> list) {
        if (this.f8915a.getAdapter() instanceof ne) {
            ((ne) this.f8915a.getAdapter()).m12169a((List) list);
        }
    }

    /* renamed from: a */
    public void m12226a(List<DkCloudStoreBook> list) {
        Collator instance = Collator.getInstance(Locale.CHINESE);
        C0840a a = C0840a.m5251a((List) list);
        a.m5259a(instance);
        a.m5263b(instance);
        for (String str : this.f8916b) {
            if (a == null) {
                break;
            }
            a = a.m5257a(str);
        }
        this.f8915a.setData(a);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ai.m3980a().m3890a((iq) this);
        ai.m3980a().m3889a((ip) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ai.m3980a().m3913b((iq) this);
        ai.m3980a().m3912b((ip) this);
    }

    protected void onDeactive() {
        super.onDeactive();
        this.f8915a.m11535p();
    }

    protected boolean onBack() {
        if (this.f8915a != null && this.f8915a.m11529j()) {
            return true;
        }
        if (!this.f8915a.m11530k()) {
            return super.onBack();
        }
        this.f8915a.m11531l();
        return true;
    }

    public void onItemsChanged() {
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof C0800c) && (i & 72) != 0) {
            this.f8915a.mo1903d();
        }
    }

    /* renamed from: a */
    public void mo1878a(int i, int i2) {
        this.f8915a.mo2231c(i, i2);
    }

    /* renamed from: b */
    public void mo1880b() {
        this.f8915a.mo2232q();
    }

    /* renamed from: c */
    public void mo1882c() {
        this.f8915a.m11532m();
    }

    /* renamed from: d */
    public void mo1883d() {
        this.f8915a.m11533n();
    }

    /* renamed from: a */
    public void mo1879a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(C0258j.bookshelf__remove_books_in_purchased_dlg__title);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__remove);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new ma(this, runnable));
    }

    /* renamed from: g */
    public boolean mo1886g() {
        return this.f8915a.mo1939c();
    }

    /* renamed from: e */
    public int mo1884e() {
        return this.f8915a.getSelectedCount();
    }

    /* renamed from: f */
    public void mo1885f() {
        this.f8915a.mo1891a();
    }

    /* renamed from: h */
    public void mo1887h() {
        this.f8915a.mo1892b();
    }

    /* renamed from: b */
    public void mo1881b(int i, int i2) {
        this.f8915a.m11522b(i, i2);
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
