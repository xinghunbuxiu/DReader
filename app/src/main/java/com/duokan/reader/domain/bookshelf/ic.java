package com.duokan.reader.domain.bookshelf;

import com.duokan.core.app.ManagedApp;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;

class ic implements Runnable {
    final /* synthetic */ hi a;

    ic(hi hiVar) {
        this.a = hiVar;
    }

    public void run() {
        this.a.n.o();
        this.a.n.a(new id(this));
        this.a.e.a(this.a);
        DkUserPurchasedBooksManager.a().a(this.a);
        DkUserPurchasedFictionsManager.a().a(this.a);
        DkUserReadingNotesManager.a().a(this.a);
        f.b().a(this.a);
        ManagedApp.get().addOnRunningStateChangedListener(this.a);
        iz.a().a(new ie(this));
        iz.a().c(new ig(this));
    }
}
