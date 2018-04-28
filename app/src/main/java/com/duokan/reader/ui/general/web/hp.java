package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.bookshelf.be;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.store.C1502o;
import com.mipay.sdk.Mipay;

class hp implements C0466h {
    /* renamed from: a */
    final /* synthetic */ ho f7944a;

    hp(ho hoVar) {
        this.f7944a = hoVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
        if (TextUtils.equals(this.f7944a.f7940c, "NORMAL")) {
            C1502o.m15410a().m15431a(this.f7944a.f7941d, dkStoreBookDetail, new hq(this), FlowChargingTransferChoice.Default);
        } else if (TextUtils.equals(this.f7944a.f7940c, "TRIED")) {
            C1502o.m15417a(dkStoreBookDetail.getMinKernelVersion(), new hr(this, dkStoreBookDetail));
        } else if (TextUtils.equals(this.f7944a.f7940c, "UPDATING")) {
            be.m9188a(this.f7944a.f7943f.f7937b.f7581b.getContext(), dkStoreBookDetail.getEpubSize(), new ht(this));
        } else if (TextUtils.equals(this.f7944a.f7940c, "TIME")) {
            C0709k.m3476a().m3497a(PersonalAccount.class, new hv(this, dkStoreBookDetail));
        }
    }

    public void onFetchBookDetailError(String str) {
        this.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7944a.f7939b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}
