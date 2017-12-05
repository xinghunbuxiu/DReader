package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.ui.store.ao;

class jh implements a {
    final /* synthetic */ je a;

    jh(je jeVar) {
        this.a = jeVar;
    }

    public void a(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        ((ao) this.a.e.b.pageController.getContext().queryFeature(ao.class)).a(null);
        this.a.c.release();
    }

    public void a(int i, String str) {
        this.a.c.release();
    }
}
