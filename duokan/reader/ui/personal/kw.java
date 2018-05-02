package com.duokan.reader.ui.personal;

class kw implements fk {
    final /* synthetic */ ko a;

    kw(ko koVar) {
        this.a = koVar;
    }

    public void a(int i) {
        if (i != a()) {
            this.a.a(i, false);
        }
    }

    public int a() {
        PurchasedSortType a = this.a.a.a();
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
