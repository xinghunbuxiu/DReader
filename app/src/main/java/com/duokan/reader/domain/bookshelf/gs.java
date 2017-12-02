package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class gs implements u {
    final /* synthetic */ gr a;

    gs(gr grVar) {
        this.a = grVar;
    }

    public void onQueryAccountOk(a aVar) {
        new gt(this).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.a.a.b.release();
    }
}
