package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.account.al;

class bo implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ String f3767a;
    /* renamed from: b */
    final /* synthetic */ DkUserPurchasedBooksManager f3768b;

    bo(DkUserPurchasedBooksManager dkUserPurchasedBooksManager, String str) {
        this.f3768b = dkUserPurchasedBooksManager;
        this.f3767a = str;
    }

    /* renamed from: a */
    public void m5363a(Void voidR) {
        al e = DkUserPurchasedBooksManager.m5051h();
        DkCloudPurchasedBook a = this.f3768b.f3608h.m5395a(this.f3767a);
        if (a != null) {
            if ((a.getBookSourceType() == DkStoreBookSourceType.GIFT || a.getBookSourceType() == DkStoreBookSourceType.GIFTED) && e.m3367c()) {
                new bp(this, cg.f3811a, e).open();
            }
        }
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
    }
}
