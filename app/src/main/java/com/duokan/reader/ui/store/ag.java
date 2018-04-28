package com.duokan.reader.ui.store;

import com.duokan.reader.domain.store.DkStoreFictionDetail;

final class ag implements aw {
    /* renamed from: a */
    final /* synthetic */ DkStoreFictionDetail f11315a;

    ag(DkStoreFictionDetail dkStoreFictionDetail) {
        this.f11315a = dkStoreFictionDetail;
    }

    /* renamed from: a */
    public String mo2526a(int i) {
        return this.f11315a.getToc()[i].getCloudId();
    }

    /* renamed from: a */
    public int mo2525a() {
        return this.f11315a.getToc().length;
    }
}
