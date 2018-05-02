package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class bp implements u {
    final /* synthetic */ bo a;

    bp(bo boVar) {
        this.a = boVar;
    }

    public void onQueryAccountOk(a aVar) {
        this.a.c.b.j(false);
    }

    public void onQueryAccountError(a aVar, String str) {
    }
}
