package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.reader.common.cache.d;
import com.duokan.reader.common.cache.i;
import com.duokan.reader.domain.account.ab;

abstract class ek extends d {
    protected final ab a;

    public /* synthetic */ Object queryInfo() {
        return b();
    }

    protected ek(ab abVar, String str) {
        super(str + "_" + abVar.a, i.a, new ea(), 0);
        this.a = abVar;
    }

    public DkUserPurchasedFictionsInfo b() {
        DkUserPurchasedFictionsInfo dkUserPurchasedFictionsInfo = (DkUserPurchasedFictionsInfo) super.queryInfo();
        if (TextUtils.isEmpty(dkUserPurchasedFictionsInfo.mAccountUuid)) {
            dkUserPurchasedFictionsInfo.mAccountUuid = this.a.a;
            dkUserPurchasedFictionsInfo.mAccountName = this.a.c;
            updateInfo(dkUserPurchasedFictionsInfo);
        }
        return dkUserPurchasedFictionsInfo;
    }
}
