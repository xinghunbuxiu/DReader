package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.List;

class bn implements eb {
    final /* synthetic */ iq a;
    final /* synthetic */ ab b;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ int e;
    final /* synthetic */ aq f;

    bn(aq aqVar, iq iqVar, ab abVar, boolean z, boolean z2, int i) {
        this.f = aqVar;
        this.a = iqVar;
        this.b = abVar;
        this.c = z;
        this.d = z2;
        this.e = i;
    }

    public void a(List list) {
        if (this.a.isCancelled()) {
            this.f.x();
        } else {
            new bo(this, this.b, list, this.a).open();
        }
    }

    public void a(String str) {
        this.f.x();
        if (!this.a.isCancelled()) {
            this.f.i(str);
        }
    }
}
