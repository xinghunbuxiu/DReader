package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.t;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

class eq implements Runnable {
    final /* synthetic */ DkStoreFictionDetail a;
    final /* synthetic */ ep b;

    eq(ep epVar, DkStoreFictionDetail dkStoreFictionDetail) {
        this.b = epVar;
        this.a = dkStoreFictionDetail;
    }

    public void run() {
        if (this.b.d.b(this.a)) {
            t.a(this.b.a);
        } else if (this.b.b != null) {
            t.a(new er(this));
        }
    }
}
