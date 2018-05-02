package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.TaskHandler;
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
            TaskHandler.postTask(this.b.a);
        } else if (this.b.b != null) {
            TaskHandler.postTask(new er(this));
        }
    }
}
