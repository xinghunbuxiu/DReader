package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;

class bh implements u {
    final /* synthetic */ boolean a;
    final /* synthetic */ a b;
    final /* synthetic */ boolean c;
    final /* synthetic */ bd d;

    bh(bd bdVar, boolean z, a aVar, boolean z2) {
        this.d = bdVar;
        this.a = z;
        this.b = aVar;
        this.c = z2;
    }

    public void onQueryAccountOk(com.duokan.reader.domain.account.a aVar) {
        this.d.f = new ab(aVar);
        new bi(this, aVar, this.d.f).open();
    }

    public void onQueryAccountError(com.duokan.reader.domain.account.a aVar, String str) {
        if (this.b != null) {
            this.b.a(-1, str);
        }
    }
}
