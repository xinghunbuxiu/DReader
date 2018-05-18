package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.im;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ja;
import com.mipay.sdk.Mipay;

class aw implements im {
    /* renamed from: a */
    final /* synthetic */ ja f7604a;
    /* renamed from: b */
    final /* synthetic */ String f7605b;
    /* renamed from: c */
    final /* synthetic */ DkStoreBookDetail f7606c;
    /* renamed from: d */
    final /* synthetic */ StorePageController f7607d;

    aw(StorePageController storePageController, ja jaVar, String str, DkStoreBookDetail dkStoreBookDetail) {
        this.f7607d = storePageController;
        this.f7604a = jaVar;
        this.f7605b = str;
        this.f7606c = dkStoreBookDetail;
    }

    /* renamed from: a */
    public void mo1021a(C0800c c0800c) {
        DkCloudStorage.m4994a().m5014a(c0800c.getId(), new ax(this, c0800c));
    }

    /* renamed from: a */
    public void mo1022a(String str) {
        this.f7604a.dismiss();
        this.f7607d.web_notifyWeb(this.f7605b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f7607d.getContext(), (CharSequence) str, 1).show();
        }
    }
}
