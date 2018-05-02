package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class j implements u {
    final /* synthetic */ boolean a;
    final /* synthetic */ p b;
    final /* synthetic */ h c;

    j(h hVar, boolean z, p pVar) {
        this.c = hVar;
        this.a = z;
        this.b = pVar;
    }

    public void onQueryAccountOk(a aVar) {
        try {
            this.c.a(this.a, this.c.e(aVar), this.b);
        } catch (Exception e) {
            this.b.a("" + e.getMessage());
        }
    }

    public void onQueryAccountError(a aVar, String str) {
        this.b.a(str);
    }
}
