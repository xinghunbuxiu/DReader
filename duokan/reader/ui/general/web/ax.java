package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jq;
import com.mipay.sdk.Mipay;

class ax implements is {
    final /* synthetic */ jq a;
    final /* synthetic */ String b;
    final /* synthetic */ DkStoreBookDetail c;
    final /* synthetic */ StorePageController d;

    ax(StorePageController storePageController, jq jqVar, String str, DkStoreBookDetail dkStoreBookDetail) {
        this.d = storePageController;
        this.a = jqVar;
        this.b = str;
        this.c = dkStoreBookDetail;
    }

    public void a(c cVar) {
        DkCloudStorage.a().a(cVar.H(), new ay(this, cVar));
    }

    public void a(String str) {
        this.a.dismiss();
        this.d.web_notifyWeb(this.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
        if (!TextUtils.isEmpty(str)) {
            be.a(this.d.getContext(), (CharSequence) str, 1).show();
        }
    }
}
