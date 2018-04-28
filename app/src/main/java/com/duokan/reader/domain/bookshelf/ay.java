package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;

class ay implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IAsyncWorkProgressListener f2796a;
    /* renamed from: b */
    final /* synthetic */ aw f2797b;

    ay(aw awVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.f2797b = awVar;
        this.f2796a = iAsyncWorkProgressListener;
    }

    public void run() {
        it.m4692a().m4727b(this.f2796a);
        if (!this.f2797b.f2788a.isCancelled()) {
            this.f2797b.f2793f.m3933i("");
        }
    }
}
