package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.bookshelf.ai;

class jy implements Runnable {
    /* renamed from: a */
    final /* synthetic */ jt f6696a;

    jy(jt jtVar) {
        this.f6696a = jtVar;
    }

    public void run() {
        Object obj = (!C0709k.m3476a().m3507c() || ai.m3980a().mo971c().m861b()) ? null : 1;
        if (obj != null) {
            new jh(this.f6696a.getContext()).m9862a(null);
        }
    }
}
