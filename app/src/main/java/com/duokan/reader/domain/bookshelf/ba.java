package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;

class ba implements Runnable {
    final /* synthetic */ IAsyncWorkProgressListener a;
    final /* synthetic */ az b;

    ba(az azVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.b = azVar;
        this.a = iAsyncWorkProgressListener;
    }

    public void run() {
        iz.a().b(this.a);
        if (!this.b.a.isCancelled()) {
            this.b.f.b(this.b.b, this.b.c, this.b.d, this.b.e, this.b.a);
        }
    }
}
