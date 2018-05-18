package com.duokan.reader.domain.bookshelf;

class gf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f3224a;
    /* renamed from: b */
    final /* synthetic */ fp f3225b;

    gf(fp fpVar, Runnable runnable) {
        this.f3225b = fpVar;
        this.f3224a = runnable;
    }

    public void run() {
        this.f3225b.aV().mo1103f().m5014a(this.f3225b.getId(), new gg(this));
    }
}
