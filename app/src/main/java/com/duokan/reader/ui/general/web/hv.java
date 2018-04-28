package com.duokan.reader.ui.general.web;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.ja;
import com.mipay.sdk.Mipay;

class hv implements C0666x {
    /* renamed from: a */
    final /* synthetic */ DkStoreBookDetail f7951a;
    /* renamed from: b */
    final /* synthetic */ hp f7952b;

    hv(hp hpVar, DkStoreBookDetail dkStoreBookDetail) {
        this.f7952b = hpVar;
        this.f7951a = dkStoreBookDetail;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        new hw(this, C0629b.f2117a, ja.m10831a(this.f7952b.f7944a.f7943f.f7937b.f7581b.getContext(), "", this.f7952b.f7944a.f7943f.f7937b.f7581b.getContext().getString(C0258j.bookcity_store__shared__creating_order), true)).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f7952b.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7952b.f7944a.f7939b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}
