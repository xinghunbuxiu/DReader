package com.duokan.reader.ui.store;

import com.duokan.reader.common.webservices.duokan.u;
import com.duokan.reader.domain.store.g;

class k implements g {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void a(u[] uVarArr, int i, boolean z) {
        for (Object add : uVarArr) {
            this.a.b.add(add);
        }
        this.a.c.getAdapter().a(z);
    }

    public void a(String str) {
        this.a.c.getAdapter().m();
    }
}
