package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.common.cache.C0572d;
import com.duokan.reader.common.cache.C0576i;
import com.duokan.reader.domain.account.al;

abstract class dv extends C0572d<DkUserPurchasedFictionsInfo, DkCloudPurchasedFiction, String> {
    /* renamed from: a */
    protected final al f3885a;

    public /* synthetic */ Object queryInfo() {
        return m5450b();
    }

    protected dv(al alVar, String str) {
        super(str + "_" + alVar.f2360a, C0576i.f1884a, new dl(), 0);
        this.f3885a = alVar;
    }

    /* renamed from: b */
    public DkUserPurchasedFictionsInfo m5450b() {
        DkUserPurchasedFictionsInfo dkUserPurchasedFictionsInfo = (DkUserPurchasedFictionsInfo) super.queryInfo();
        if (TextUtils.isEmpty(dkUserPurchasedFictionsInfo.mAccountUuid)) {
            dkUserPurchasedFictionsInfo.mAccountUuid = this.f3885a.f2360a;
            dkUserPurchasedFictionsInfo.mAccountName = this.f3885a.f2362c;
            updateInfo(dkUserPurchasedFictionsInfo);
        }
        return dkUserPurchasedFictionsInfo;
    }
}
