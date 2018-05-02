package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.it;

/* renamed from: com.duokan.reader.ui.personal.do */
class C1395do implements Runnable {
    /* renamed from: a */
    final /* synthetic */ dn f8462a;

    C1395do(dn dnVar) {
        this.f8462a = dnVar;
    }

    public void run() {
        if (this.f8462a.f8461a.f8457b != null) {
            this.f8462a.f8461a.f8457b.setSpaceQuota(it.m4692a().m4725b());
        }
    }
}
