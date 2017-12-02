package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.t;
import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.i;

class ig extends i {
    final /* synthetic */ ic a;

    ig(ic icVar) {
        this.a = icVar;
    }

    public /* synthetic */ void e(c cVar) {
        a((com.duokan.reader.domain.micloud.i) cVar);
    }

    public void a(com.duokan.reader.domain.micloud.i iVar) {
        super.e(iVar);
        this.a.a.u();
        t.b(new ih(this, iVar, new iy(iVar.H())));
    }
}
