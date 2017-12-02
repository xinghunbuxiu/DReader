package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.af;
import com.duokan.core.app.ag;
import com.duokan.core.sys.t;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.ap;

import java.util.List;

class bq implements ag {
    final /* synthetic */ int a;
    final /* synthetic */ ap b;
    final /* synthetic */ List c;
    final /* synthetic */ Runnable d;
    final /* synthetic */ Runnable e;
    final /* synthetic */ bk f;

    bq(bk bkVar, int i, ap apVar, List list, Runnable runnable, Runnable runnable2) {
        this.f = bkVar;
        this.a = i;
        this.b = apVar;
        this.c = list;
        this.d = runnable;
        this.e = runnable2;
    }

    public void a(af afVar) {
        ai.a().b(this.c, this.a >= 0 ? this.b.isChecked(this.a) : false);
        t.a(this.d);
    }

    public void b(af afVar) {
        t.a(this.e);
    }

    public void c(af afVar) {
        t.a(this.e);
    }
}
