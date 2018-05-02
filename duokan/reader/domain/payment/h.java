package com.duokan.reader.domain.payment;

import com.duokan.b.i;
import com.duokan.reader.DkApp;

class h implements i {
    final /* synthetic */ r a;
    final /* synthetic */ s b;
    final /* synthetic */ g c;

    h(g gVar, r rVar, s sVar) {
        this.c = gVar;
        this.a = rVar;
        this.b = sVar;
    }

    public void a(String str) {
        this.a.a(this.c, this.b, str);
    }

    public void a(int i, String str) {
        this.a.b(this.c, this.b, str);
    }

    public void a() {
        this.a.b(this.c, this.b, DkApp.get().getString(i.bookcity_store__shared__fail_to_pay));
    }
}
