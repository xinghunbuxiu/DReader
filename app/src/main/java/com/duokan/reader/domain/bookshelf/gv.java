package com.duokan.reader.domain.bookshelf;

class gv implements jo {
    final /* synthetic */ Runnable a;
    final /* synthetic */ gq b;

    gv(gq gqVar, Runnable runnable) {
        this.b = gqVar;
        this.a = runnable;
    }

    public void a(jn jnVar) {
        this.a.run();
    }

    public void b(jn jnVar) {
        this.b.b.release();
    }
}
