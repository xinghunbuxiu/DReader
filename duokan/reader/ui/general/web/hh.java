package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.store.o;
import com.mipay.sdk.Mipay;

class hh implements h {
    final /* synthetic */ hg a;

    hh(hg hgVar) {
        this.a = hgVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
        if (TextUtils.equals(this.a.c, "NORMAL")) {
            o.a().a(this.a.d, dkStoreBookDetail, new hi(this), FlowChargingTransferChoice.Default);
        } else if (TextUtils.equals(this.a.c, "TRIED")) {
            o.a(dkStoreBookDetail.getMinKernelVersion(), new hj(this, dkStoreBookDetail));
        } else if (TextUtils.equals(this.a.c, "UPDATING")) {
            ay.a(this.a.f.b.pageController.getContext(), dkStoreBookDetail.getEpubSize(), new hl(this));
        } else if (TextUtils.equals(this.a.c, "TIME")) {
            i.f().a(PersonalAccount.class, new hn(this, dkStoreBookDetail));
        }
    }

    public void onFetchBookDetailError(String str) {
        this.a.f.b.pageController.web_notifyWeb(this.a.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}
