package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.ui.store.ao;

class jv implements C0517a<DkCloudPurchasedFiction> {
    /* renamed from: a */
    final /* synthetic */ jr f8073a;

    jv(jr jrVar) {
        this.f8073a = jrVar;
    }

    /* renamed from: a */
    public void m11242a(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        ((ao) this.f8073a.f8069e.f8048b.f7581b.getContext().queryFeature(ao.class)).mo1832a(null);
        this.f8073a.f8067c.release();
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f8073a.f8067c.release();
    }
}
