package com.duokan.reader.ui.general.web;

import com.duokan.c.j;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.jq;
import com.mipay.sdk.Mipay;

class hn implements u {
    final /* synthetic */ DkStoreBookDetail a;
    final /* synthetic */ hh b;

    hn(hh hhVar, DkStoreBookDetail dkStoreBookDetail) {
        this.b = hhVar;
        this.a = dkStoreBookDetail;
    }

    public void onQueryAccountOk(a aVar) {
        new ho(this, jq.a(this.b.a.f.b.pageController.getContext(), "", this.b.a.f.b.pageController.getContext().getString(j.bookcity_store__shared__creating_order), true)).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.b.a.f.b.pageController.web_notifyWeb(this.b.a.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}
