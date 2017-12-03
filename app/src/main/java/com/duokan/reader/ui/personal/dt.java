package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.e;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.micloud.bl;

class dt implements IAsyncWorkProgressListener {
    final /* synthetic */ ds a;

    dt(ds dsVar) {
        this.a = dsVar;
    }

    public /* synthetic */ void d(c cVar) {
        g((bl) cVar);
    }

    public /* synthetic */ void e(c cVar) {
        d((bl) cVar);
    }

    public /* synthetic */ void g(c cVar) {
        e((bl) cVar);
    }

    public void a(bl blVar) {
    }

    public void b(bl blVar) {
    }

    public void c(bl blVar) {
        iz.a();
        if (iz.a(blVar)) {
            this.a.c.post(new du(this));
        }
    }

    public void d(bl blVar) {
        iz.a();
        if (iz.a(blVar)) {
            this.a.l();
        }
    }

    public CheckErrorResult a(bl blVar, e eVar) {
        return CheckErrorResult.Ignored;
    }

    public void e(bl blVar) {
        iz.a();
        if (iz.a(blVar)) {
            this.a.l();
        }
    }

    public void f(bl blVar) {
        iz.a();
        if (iz.a(blVar)) {
            this.a.c.post(new dv(this));
        }
    }

    public void g(bl blVar) {
        iz.a();
        if (iz.a(blVar)) {
            this.a.c.post(new dw(this));
        }
    }
}
