package com.duokan.reader.domain.bookshelf;

class hz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0800c f3333a;
    /* renamed from: b */
    final /* synthetic */ hy f3334b;

    hz(hy hyVar, C0800c c0800c) {
        this.f3334b = hyVar;
        this.f3333a = c0800c;
    }

    public void run() {
        if (this.f3333a == null) {
            return;
        }
        if (this.f3333a.m4233i() != BookState.NORMAL) {
            ai.m3980a().m3886a(this.f3333a, true);
            return;
        }
        this.f3333a.an();
        this.f3333a.aN();
    }
}
