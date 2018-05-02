package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.i;

class dy extends i {
    final /* synthetic */ ds a;

    dy(ds dsVar) {
        this.a = dsVar;
    }

    public /* synthetic */ void c(c cVar) {
        e((com.duokan.reader.domain.micloud.i) cVar);
    }

    public /* synthetic */ void d(c cVar) {
        b((com.duokan.reader.domain.micloud.i) cVar);
    }

    public /* synthetic */ void e(c cVar) {
        c((com.duokan.reader.domain.micloud.i) cVar);
    }

    public /* synthetic */ void g(c cVar) {
        d((com.duokan.reader.domain.micloud.i) cVar);
    }

    public void a(com.duokan.reader.domain.micloud.i iVar) {
        super.a(iVar);
        this.a.c.post(new dz(this));
    }

    public void b(com.duokan.reader.domain.micloud.i iVar) {
        this.a.c.post(new ea(this, iVar));
    }

    public void c(com.duokan.reader.domain.micloud.i iVar) {
        super.a(iVar);
        this.a.c.post(new eb(this));
    }

    public void d(com.duokan.reader.domain.micloud.i iVar) {
        this.a.c.post(new ec(this, iVar));
    }

    public void e(com.duokan.reader.domain.micloud.i iVar) {
        this.a.c.post(new ed(this, iVar));
    }

    public void f(com.duokan.reader.domain.micloud.i iVar) {
        this.a.c.post(new ee(this, iVar));
    }
}
