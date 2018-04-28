package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;

class ax implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IAsyncWorkProgressListener f2794a;
    /* renamed from: b */
    final /* synthetic */ aw f2795b;

    ax(aw awVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.f2795b = awVar;
        this.f2794a = iAsyncWorkProgressListener;
    }

    public void run() {
        it.m4692a().m4727b(this.f2794a);
        if (!this.f2795b.f2788a.isCancelled()) {
            this.f2795b.f2793f.m3965b(this.f2795b.f2789b, this.f2795b.f2790c, this.f2795b.f2791d, this.f2795b.f2792e, this.f2795b.f2788a);
        }
    }
}
