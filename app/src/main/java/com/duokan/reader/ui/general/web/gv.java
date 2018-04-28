package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ah;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;

class gv implements C0466h {
    /* renamed from: a */
    final /* synthetic */ String f7906a;
    /* renamed from: b */
    final /* synthetic */ String f7907b;
    /* renamed from: c */
    final /* synthetic */ gu f7908c;

    gv(gu guVar, String str, String str2) {
        this.f7908c = guVar;
        this.f7906a = str;
        this.f7907b = str2;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        ah.m871b(new gw(this, (DkStoreFictionDetail) dkStoreItem));
    }

    public void onFetchBookDetailError(String str) {
        this.f7908c.f7905b.f7581b.web_notifyWeb(this.f7907b, 2, new Object[0]);
    }
}
