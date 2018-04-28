package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.bookshelf.ai;

class bz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ by f6236a;

    bz(by byVar) {
        this.f6236a = byVar;
    }

    public void run() {
        this.f6236a.f6234b.dismiss();
        Object obj = (!C0709k.m3476a().m3507c() || ai.m3980a().mo971c().m861b()) ? null : 1;
        if (obj != null) {
            new jh(this.f6236a.f6235c.f6232f.getContext()).m9862a(this.f6236a.f6235c.f6230d);
        } else {
            UThread.post(this.f6236a.f6235c.f6230d);
        }
    }
}
