package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.ui.general.ib;

class nb implements ib {
    final /* synthetic */ ef a;
    final /* synthetic */ mz b;

    nb(mz mzVar, ef efVar) {
        this.b = mzVar;
        this.a = efVar;
    }

    public void a(int i) {
        if (i == 0) {
            this.b.a.a.a(this.a.d());
            this.b.a.c();
            return;
        }
        this.b.a.a.G().b(this.a);
        this.b.a.d();
    }
}
