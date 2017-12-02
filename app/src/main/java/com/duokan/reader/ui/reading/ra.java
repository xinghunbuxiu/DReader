package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.core.sys.t;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

class ra implements ag {
    final /* synthetic */ Runnable a;
    final /* synthetic */ qh b;

    ra(qh qhVar, Runnable runnable) {
        this.b = qhVar;
        this.a = runnable;
    }

    public void a(DkStoreFictionDetail dkStoreFictionDetail) {
        if (!this.b.q) {
            this.b.a(dkStoreFictionDetail);
            t.b(this.a);
        }
    }
}
