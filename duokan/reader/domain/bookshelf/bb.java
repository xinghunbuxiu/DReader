package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;

class bb implements Runnable {
    final /* synthetic */ IAsyncWorkProgressListener a;
    final /* synthetic */ az b;

    bb(az azVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.b = azVar;
        this.a = iAsyncWorkProgressListener;
    }

    public void run() {
        iz.a().b(this.a);
        if (!this.b.a.isCancelled()) {
            this.b.f.i("");
        }
    }
}
