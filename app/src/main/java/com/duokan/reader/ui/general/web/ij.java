package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.account.ak;
import com.duokan.reader.ui.general.be;

class ij implements C0466h {
    /* renamed from: a */
    final /* synthetic */ ii f7994a;

    ij(ii iiVar) {
        this.f7994a = iiVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        DkStoreBookDetail dkStoreBookDetail = (DkStoreBookDetail) dkStoreItem;
        if (this.f7994a.f7993a.f7992b.f7581b.mShareEntranceContext == null) {
            this.f7994a.f7993a.f7992b.f7581b.mShareEntranceContext = new ak(this.f7994a.f7993a.f7992b.f7581b);
        }
        this.f7994a.f7993a.f7992b.f7581b.mShareEntranceContext.m8872a(this.f7994a.f7993a.f7992b.f7581b.getContext(), dkStoreBookDetail.getWebUrl(), dkStoreBookDetail.getBook(), dkStoreBookDetail.getSummary(), null);
    }

    public void onFetchBookDetailError(String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f7994a.f7993a.f7992b.f7581b.getContext(), (CharSequence) str, 1).show();
        }
    }
}
