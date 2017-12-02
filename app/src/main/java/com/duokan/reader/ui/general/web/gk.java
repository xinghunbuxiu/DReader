package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ah;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;

class gk implements h {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ gj c;

    gk(gj gjVar, String str, String str2) {
        this.c = gjVar;
        this.a = str;
        this.b = str2;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ah.b(new gl(this, (DkStoreFictionDetail) dkStoreItem));
    }

    public void onFetchBookDetailError(String str) {
        this.c.b.b.web_notifyWeb(this.b, 2, new Object[0]);
    }
}
