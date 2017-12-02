package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.reader.common.cache.d;
import com.duokan.reader.common.cache.i;
import com.duokan.reader.domain.account.ab;

abstract class cw extends d {
    private final ab a;

    public /* synthetic */ Object queryInfo() {
        return b();
    }

    protected cw(ab abVar, String str) {
        super(str + "_" + abVar.a, i.a, new cq(), 0);
        this.a = abVar;
    }

    public DkUserPurchasedBooksInfo b() {
        DkUserPurchasedBooksInfo dkUserPurchasedBooksInfo = (DkUserPurchasedBooksInfo) super.queryInfo();
        if (TextUtils.isEmpty(dkUserPurchasedBooksInfo.mAccountUuid)) {
            dkUserPurchasedBooksInfo.mAccountUuid = this.a.a;
            dkUserPurchasedBooksInfo.mAccountName = this.a.c;
            updateInfo(dkUserPurchasedBooksInfo);
        }
        return dkUserPurchasedBooksInfo;
    }
}
