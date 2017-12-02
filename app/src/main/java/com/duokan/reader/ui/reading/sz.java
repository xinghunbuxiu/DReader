package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.ui.account.cz;

class sz implements cz {
    final /* synthetic */ a a;
    final /* synthetic */ ss b;

    sz(ss ssVar, a aVar) {
        this.b = ssVar;
        this.a = aVar;
    }

    public void a(String str, String str2, boolean z) {
        if (z) {
            a aVar = (ef) this.a;
            if (!str2.equals(aVar.m())) {
                aVar.e(str2);
                this.b.a.a.G().c(aVar);
            }
        }
    }
}
