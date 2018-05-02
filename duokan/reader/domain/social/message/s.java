package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;

class s implements u {
    final /* synthetic */ ab a;
    final /* synthetic */ boolean b;
    final /* synthetic */ o c;

    s(o oVar, ab abVar, boolean z) {
        this.c = oVar;
        this.a = abVar;
        this.b = z;
    }

    public void onQueryAccountOk(a aVar) {
        this.c.f = new ab(aVar);
        new t(this, this.c.f).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.a.a(false, false);
    }
}
