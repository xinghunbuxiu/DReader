package com.duokan.reader.ui.store;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class ad implements u {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ an c;
    final /* synthetic */ o d;

    ad(o oVar, String str, String str2, an anVar) {
        this.d = oVar;
        this.a = str;
        this.b = str2;
        this.c = anVar;
    }

    public void onQueryAccountOk(a aVar) {
        new ae(this, aVar).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.c.a(this.a, this.b, null);
    }
}
