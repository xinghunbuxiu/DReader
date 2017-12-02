package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.a.a;

class bk implements a {
    final /* synthetic */ bj a;

    bk(bj bjVar) {
        this.a = bjVar;
    }

    public void a(Object obj) {
        if (!this.a.a.isCancelled()) {
            this.a.f.d(this.a.b, this.a.c, this.a.d, this.a.e, this.a.a);
        }
    }

    public void a(int i, String str) {
        if (!this.a.a.isCancelled()) {
            this.a.f.i(str);
        }
    }
}
