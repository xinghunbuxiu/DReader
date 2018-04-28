package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;

class az implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IAsyncWorkProgressListener f2798a;
    /* renamed from: b */
    final /* synthetic */ aw f2799b;

    az(aw awVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.f2799b = awVar;
        this.f2798a = iAsyncWorkProgressListener;
    }

    public void run() {
        it.m4692a().m4727b(this.f2798a);
        if (!this.f2799b.f2788a.isCancelled()) {
            this.f2799b.f2793f.m3933i("");
        }
    }
}
