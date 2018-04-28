package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.mipay.sdk.Mipay;

class iu implements ag<DkStoreFictionDetail> {
    /* renamed from: a */
    final /* synthetic */ String f8015a;
    /* renamed from: b */
    final /* synthetic */ it f8016b;

    iu(it itVar, String str) {
        this.f8016b = itVar;
        this.f8015a = str;
    }

    public /* synthetic */ void run(Object obj) {
        m11206a((DkStoreFictionDetail) obj);
    }

    /* renamed from: a */
    public void m11206a(DkStoreFictionDetail dkStoreFictionDetail) {
        this.f8016b.f8014b.f7581b.web_notifyWeb(this.f8015a, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }
}
