package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.i;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.micloud.bl;

class az extends i {
    final /* synthetic */ iq a;
    final /* synthetic */ boolean b;
    final /* synthetic */ boolean c;
    final /* synthetic */ int d;
    final /* synthetic */ ab e;
    final /* synthetic */ aq f;

    az(aq aqVar, iq iqVar, boolean z, boolean z2, int i, ab abVar) {
        this.f = aqVar;
        this.a = iqVar;
        this.b = z;
        this.c = z2;
        this.d = i;
        this.e = abVar;
    }

    public /* synthetic */ void e(c cVar) {
        a((bl) cVar);
    }

    public /* synthetic */ void f(c cVar) {
        b((bl) cVar);
    }

    public /* synthetic */ void g(c cVar) {
        c((bl) cVar);
    }

    public void a(bl blVar) {
        TaskHandler.PostTask(new ba(this, this));
    }

    public void b(bl blVar) {
        TaskHandler.PostTask(new bb(this, this));
    }

    public void c(bl blVar) {
        TaskHandler.PostTask(new bc(this, this));
    }
}
