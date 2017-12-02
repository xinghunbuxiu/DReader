package com.duokan.reader.ui.store;

import com.duokan.reader.domain.store.DkStoreFictionDetail;

final class ag implements aw {
    final /* synthetic */ DkStoreFictionDetail a;

    ag(DkStoreFictionDetail dkStoreFictionDetail) {
        this.a = dkStoreFictionDetail;
    }

    public String a(int i) {
        return this.a.getToc()[i].getCloudId();
    }

    public int a() {
        return this.a.getToc().length;
    }
}
