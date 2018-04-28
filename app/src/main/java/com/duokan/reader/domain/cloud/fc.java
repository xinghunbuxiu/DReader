package com.duokan.reader.domain.cloud;

import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.store.bi;

class fc implements C0666x {
    /* renamed from: a */
    final /* synthetic */ ja f3981a;
    /* renamed from: b */
    final /* synthetic */ DkStoreBookDetail f3982b;
    /* renamed from: c */
    final /* synthetic */ fj f3983c;
    /* renamed from: d */
    final /* synthetic */ ex f3984d;

    fc(ex exVar, ja jaVar, DkStoreBookDetail dkStoreBookDetail, fj fjVar) {
        this.f3984d = exVar;
        this.f3981a = jaVar;
        this.f3982b = dkStoreBookDetail;
        this.f3983c = fjVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3981a.show();
        String b = c0672a.mo832b();
        DkStoreBookPrice dkStoreBookPrice = new DkStoreBookPrice();
        dkStoreBookPrice.mBookUuid = this.f3982b.getBook().getBookUuid();
        dkStoreBookPrice.mBookTitle = this.f3982b.getBook().getTitle();
        dkStoreBookPrice.mNewPrice = this.f3982b.getBook().getNewPrice();
        dkStoreBookPrice.mPrice = this.f3982b.getBook().getPrice();
        new bi(this.f3984d.f3957c, null, dkStoreBookPrice).m15323a(DkApp.get().getTopActivity(), new fd(this, b, c0672a, dkStoreBookPrice));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3983c.mo1161a(str);
    }
}
