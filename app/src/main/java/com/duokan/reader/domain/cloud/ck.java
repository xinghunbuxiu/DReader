package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.common.cache.C0572d;
import com.duokan.reader.common.cache.C0576i;
import com.duokan.reader.domain.account.al;

abstract class ck extends C0572d<DkUserPurchasedBooksInfo, DkCloudPurchasedBook, String> {
    /* renamed from: a */
    private final al f3816a;

    public /* synthetic */ Object queryInfo() {
        return m5405b();
    }

    protected ck(al alVar, String str) {
        super(str + "_" + alVar.f2360a, C0576i.f1884a, new ce(), 0);
        this.f3816a = alVar;
    }

    /* renamed from: b */
    public DkUserPurchasedBooksInfo m5405b() {
        DkUserPurchasedBooksInfo dkUserPurchasedBooksInfo = (DkUserPurchasedBooksInfo) super.queryInfo();
        if (TextUtils.isEmpty(dkUserPurchasedBooksInfo.mAccountUuid)) {
            dkUserPurchasedBooksInfo.mAccountUuid = this.f3816a.f2360a;
            dkUserPurchasedBooksInfo.mAccountName = this.f3816a.f2362c;
            updateInfo(dkUserPurchasedBooksInfo);
        }
        return dkUserPurchasedBooksInfo;
    }
}
