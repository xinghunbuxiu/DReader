package com.duokan.reader.domain.cloud;

import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.jq;
import com.duokan.reader.ui.store.bi;

class fv implements u {
    final /* synthetic */ jq a;
    final /* synthetic */ DkStoreBookDetail b;
    final /* synthetic */ gd c;
    final /* synthetic */ fp d;

    fv(fp fpVar, jq jqVar, DkStoreBookDetail dkStoreBookDetail, gd gdVar) {
        this.d = fpVar;
        this.a = jqVar;
        this.b = dkStoreBookDetail;
        this.c = gdVar;
    }

    public void onQueryAccountOk(a aVar) {
        this.a.show();
        String b = aVar.b();
        DkStoreBookPrice dkStoreBookPrice = new DkStoreBookPrice();
        dkStoreBookPrice.mBookUuid = this.b.getBook().getBookUuid();
        dkStoreBookPrice.mBookTitle = this.b.getBook().getTitle();
        dkStoreBookPrice.mNewPrice = this.b.getBook().getNewPrice();
        dkStoreBookPrice.mPrice = this.b.getBook().getPrice();
        new bi(this.d.c, null, dkStoreBookPrice).a(DkApp.get().getTopActivity(), new fw(this, aVar, dkStoreBookPrice, b));
    }

    public void onQueryAccountError(a aVar, String str) {
        this.c.a(str);
    }
}
