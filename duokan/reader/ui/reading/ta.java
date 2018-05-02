package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ef;

class ta implements r {
    final /* synthetic */ a a;
    final /* synthetic */ ss b;

    ta(ss ssVar, a aVar) {
        this.b = ssVar;
        this.a = aVar;
    }

    public void a(String str) {
        a aVar = (ef) this.a;
        if (!str.equals(aVar.m())) {
            aVar.e(str);
            this.b.a.a.G().c(aVar);
        }
        this.b.a.a.aN();
        this.b.a.a.aV();
    }

    public void a() {
        this.b.a.a.aV();
    }
}
