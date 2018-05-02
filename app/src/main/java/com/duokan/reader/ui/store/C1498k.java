package com.duokan.reader.ui.store;

import com.duokan.reader.common.webservices.duokan.C0646t;
import com.duokan.reader.domain.store.C1182g;

/* renamed from: com.duokan.reader.ui.store.k */
class C1498k implements C1182g {
    /* renamed from: a */
    final /* synthetic */ C1497j f11449a;

    C1498k(C1497j c1497j) {
        this.f11449a = c1497j;
    }

    /* renamed from: a */
    public void mo2538a(C0646t[] c0646tArr, int i, boolean z) {
        for (Object add : c0646tArr) {
            this.f11449a.f11447b.add(add);
        }
        this.f11449a.f11448c.getAdapter().m8785a(z);
    }

    /* renamed from: a */
    public void mo2537a(String str) {
        this.f11449a.f11448c.getAdapter().m8790m();
    }
}
