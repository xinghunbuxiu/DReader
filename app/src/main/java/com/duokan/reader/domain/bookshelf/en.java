package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.t;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

class en implements Runnable {
    final /* synthetic */ DkStoreFictionDetail a;
    final /* synthetic */ em b;

    en(em emVar, DkStoreFictionDetail dkStoreFictionDetail) {
        this.b = emVar;
        this.a = dkStoreFictionDetail;
    }

    public void run() {
        this.b.a.c.c(this.a);
        this.b.a.c.aL();
        if (this.b.a.a != null) {
            t.a(new eo(this));
        }
    }
}
