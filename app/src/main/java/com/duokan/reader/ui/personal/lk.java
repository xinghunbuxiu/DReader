package com.duokan.reader.ui.personal;

class lk implements fy {
    /* renamed from: a */
    final /* synthetic */ lc f8887a;

    lk(lc lcVar) {
        this.f8887a = lcVar;
    }

    /* renamed from: a */
    public void mo1943a(int i) {
        if (i != mo1942a()) {
            this.f8887a.m12139a(i, false);
        }
    }

    /* renamed from: a */
    public int mo1942a() {
        PurchasedSortType a = this.f8887a.f8857a.mo1932a();
        if (a == PurchasedSortType.TIME) {
            return 0;
        }
        if (a == PurchasedSortType.NAME) {
            return 1;
        }
        if (a == PurchasedSortType.GROUP) {
            return 2;
        }
        return 0;
    }
}
