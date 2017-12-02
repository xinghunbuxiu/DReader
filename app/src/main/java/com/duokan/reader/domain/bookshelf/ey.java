package com.duokan.reader.domain.bookshelf;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;

class ey implements b {
    final /* synthetic */ ex a;

    ey(ex exVar) {
        this.a = exVar;
    }

    public void a(a aVar) {
        this.a.a.f.b(this.a.a.c, this.a.a.a, this.a.a.e);
    }

    public void a(a aVar, String str) {
        com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "dkbook", "fail to get chapter links because of a login error(book=%s, name=%s)", this.a.a.b, this.a.a.f.aw());
        if (this.a.a.e != null) {
            this.a.a.e.a(this.a.a.d);
        }
    }
}
