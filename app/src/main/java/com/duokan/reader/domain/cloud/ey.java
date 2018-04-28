package com.duokan.reader.domain.cloud;

import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.store.C1502o;

class ey implements fj {
    /* renamed from: a */
    final /* synthetic */ ja f3960a;
    /* renamed from: b */
    final /* synthetic */ fj f3961b;
    /* renamed from: c */
    final /* synthetic */ ex f3962c;

    ey(ex exVar, ja jaVar, fj fjVar) {
        this.f3962c = exVar;
        this.f3960a = jaVar;
        this.f3961b = fjVar;
    }

    /* renamed from: a */
    public void mo1160a(DkCloudRedeemFund dkCloudRedeemFund) {
        this.f3960a.dismiss();
        this.f3961b.mo1160a(dkCloudRedeemFund);
    }

    /* renamed from: a */
    public void mo1161a(String str) {
        this.f3960a.dismiss();
        this.f3961b.mo1161a(str);
        C1502o.m15426d(str);
    }
}
