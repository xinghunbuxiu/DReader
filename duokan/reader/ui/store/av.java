package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.is;

class av implements is {
    final /* synthetic */ Runnable a;
    final /* synthetic */ as b;

    av(as asVar, Runnable runnable) {
        this.b = asVar;
        this.a = runnable;
    }

    public void a(c cVar) {
        this.a.run();
    }

    public void a(String str) {
        this.b.a.dismiss();
        o.d(str);
    }
}
