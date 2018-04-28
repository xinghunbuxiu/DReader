package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ah;
import java.util.concurrent.FutureTask;

class hj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FutureTask f3305a;
    /* renamed from: b */
    final /* synthetic */ ij f3306b;
    /* renamed from: c */
    final /* synthetic */ hc f3307c;

    hj(hc hcVar, FutureTask futureTask, ij ijVar) {
        this.f3307c = hcVar;
        this.f3305a = futureTask;
        this.f3306b = ijVar;
    }

    public void run() {
        try {
            this.f3305a.run();
        } finally {
            ah.m866a(new hk(this), hc.f2728c);
        }
    }
}
