package com.duokan.reader.ui.bookshelf;

import java.util.concurrent.Callable;

class m implements Callable {
    final /* synthetic */ g a;

    m(g gVar) {
        this.a = gVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        if (this.a.m != this) {
            return Boolean.valueOf(true);
        }
        this.a.m = null;
        if (this.a.getWindowToken() == null) {
            return Boolean.valueOf(true);
        }
        this.a.e.b(this.a.b.d());
        if (this.a.h != null) {
            this.a.h.a(false);
        }
        return Boolean.valueOf(false);
    }
}
