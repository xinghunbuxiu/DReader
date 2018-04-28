package com.duokan.reader.ui.store;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

class ak implements C0517a<DkCloudPurchasedFiction> {
    /* renamed from: a */
    final /* synthetic */ DkStoreFictionDetail f11321a;
    /* renamed from: b */
    final /* synthetic */ aj f11322b;

    ak(aj ajVar, DkStoreFictionDetail dkStoreFictionDetail) {
        this.f11322b = ajVar;
        this.f11321a = dkStoreFictionDetail;
    }

    /* renamed from: a */
    public void m15251a(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        this.f11322b.m15248a(this.f11321a);
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f11322b.m15248a(this.f11321a);
    }
}
