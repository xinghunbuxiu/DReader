package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;

class az implements u {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ boolean c;
    final /* synthetic */ aw d;

    az(aw awVar, int i, int i2, boolean z) {
        this.d = awVar;
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public void onQueryAccountOk(a aVar) {
        this.d.f = new ab(aVar);
        new ba(this, this.d.f).open();
    }

    public void onQueryAccountError(a aVar, String str) {
    }
}
