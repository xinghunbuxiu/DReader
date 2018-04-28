package com.duokan.reader.domain.bookshelf;

import com.duokan.core.app.ManagedApp;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;

class hw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ hc f3330a;

    hw(hc hcVar) {
        this.f3330a = hcVar;
    }

    public void run() {
        this.f3330a.f2749n.m7900q();
        this.f3330a.f2749n.m7872a(new hx(this));
        this.f3330a.f2741e.m3494a(this.f3330a);
        DkUserPurchasedBooksManager.m5029a().m5056a(this.f3330a);
        DkUserPurchasedFictionsManager.m5072a().m5096a(this.f3330a);
        DkUserReadingNotesManager.m5136a().m5152a(this.f3330a);
        C0559f.m2476b().m2480a(this.f3330a);
        ManagedApp.get().addOnRunningStateChangedListener(this.f3330a);
        it.m4692a().m4719a(new hy(this));
        it.m4692a().m4731c(new ia(this));
    }
}
