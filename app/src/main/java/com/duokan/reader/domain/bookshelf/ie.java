package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.micloud.o;
import com.duokan.reader.domain.micloud.t;

import java.util.HashMap;

class ie implements t {
    final /* synthetic */ ic a;

    ie(ic icVar) {
        this.a = icVar;
    }

    public void a(o oVar) {
    }

    public void b(o oVar) {
    }

    public void a(o oVar, bi biVar) {
        this.a.a.u();
        HashMap v = this.a.a.v();
        iy iyVar = new iy(biVar);
        iyVar.g();
        com.duokan.core.sys.t.b(new if(this, (c) v.get(iyVar.f())));
    }

    public void b(o oVar, bi biVar) {
    }
}
