package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

class hy implements ag {
    final /* synthetic */ Runnable a;
    final /* synthetic */ hi b;

    hy(hi hiVar, Runnable runnable) {
        this.b = hiVar;
        this.a = runnable;
    }

    public void a(DkStoreFictionDetail dkStoreFictionDetail) {
        TaskHandler.postTask(this.a);
    }
}
