package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;

class ga implements u {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ gc c;
    final /* synthetic */ fp d;

    ga(fp fpVar, int i, int i2, gc gcVar) {
        this.d = fpVar;
        this.a = i;
        this.b = i2;
        this.c = gcVar;
    }

    public void onQueryAccountOk(a aVar) {
        new gb(this, new ab(aVar)).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.c.a(str);
    }
}
