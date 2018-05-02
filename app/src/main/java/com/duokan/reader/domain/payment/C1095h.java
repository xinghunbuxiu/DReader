package com.duokan.reader.domain.payment;

import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;

/* renamed from: com.duokan.reader.domain.payment.h */
class C1095h implements C1094i {
    /* renamed from: a */
    final /* synthetic */ C1097r f5344a;
    /* renamed from: b */
    final /* synthetic */ C1089s f5345b;
    /* renamed from: c */
    final /* synthetic */ C1093g f5346c;

    C1095h(C1093g c1093g, C1097r c1097r, C1089s c1089s) {
        this.f5346c = c1093g;
        this.f5344a = c1097r;
        this.f5345b = c1089s;
    }

    /* renamed from: a */
    public void mo1507a(String str) {
        this.f5344a.mo1508a(this.f5346c, this.f5345b, str);
    }

    /* renamed from: a */
    public void mo1506a(int i, String str) {
        this.f5344a.mo1509b(this.f5346c, this.f5345b, str);
    }

    /* renamed from: a */
    public void mo1505a() {
        this.f5344a.mo1509b(this.f5346c, this.f5345b, DkApp.get().getString(C0247i.bookcity_store__shared__fail_to_pay));
    }
}
