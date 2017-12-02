package com.duokan.reader.ui.a;

import com.duokan.core.ui.dv;
import com.duokan.reader.domain.store.DkStoreAbsBook;

class h implements u {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void a(DkStoreAbsBook dkStoreAbsBook) {
        this.a.a.f.add(dkStoreAbsBook);
        this.a.a.g.add("");
        this.a.a.c();
        this.a.a.b();
        dv.a(this.a.a.c, new i(this));
    }

    public void a() {
        this.a.a.c();
    }
}
