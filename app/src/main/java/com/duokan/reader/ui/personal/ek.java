package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.e;
import com.duokan.reader.domain.micloud.n;

class ek implements IAsyncWorkProgressListener {
    final /* synthetic */ ep a;
    final /* synthetic */ ds b;

    ek(ds dsVar, ep epVar) {
        this.b = dsVar;
        this.a = epVar;
    }

    public /* synthetic */ void a(c cVar) {
        b((n) cVar);
    }

    public /* synthetic */ void b(c cVar) {
        f((n) cVar);
    }

    public /* synthetic */ void e(c cVar) {
        a((n) cVar);
    }

    public /* synthetic */ void f(c cVar) {
        g((n) cVar);
    }

    public /* synthetic */ void g(c cVar) {
        e((n) cVar);
    }

    public void a(n nVar) {
        this.b.c.post(new el(this, nVar.y()));
    }

    public void b(n nVar) {
    }

    public void c(n nVar) {
    }

    public void d(n nVar) {
    }

    public void e(n nVar) {
        this.b.c.post(new em(this, nVar.y()));
    }

    public void f(n nVar) {
    }

    public CheckErrorResult a(n nVar, e eVar) {
        return CheckErrorResult.Ignored;
    }

    public void g(n nVar) {
        this.b.c.post(new en(this, nVar.y()));
    }
}
