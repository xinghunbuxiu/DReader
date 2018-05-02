package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.eh;

class q implements eh {
    final /* synthetic */ bi a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ p c;

    q(p pVar, bi biVar, Runnable runnable) {
        this.c = pVar;
        this.a = biVar;
        this.b = runnable;
    }

    public void a(boolean z) {
        if (this.a != null) {
            this.a.a(new r(this));
        }
    }

    public void a() {
        if (this.b != null) {
            this.c.a.post(this.b);
        }
    }
}
