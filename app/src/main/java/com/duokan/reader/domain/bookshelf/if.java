package com.duokan.reader.domain.bookshelf;

class if implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ ie b;

    if(ie ieVar, c cVar) {
        this.b = ieVar;
        this.a = cVar;
    }

    public void run() {
        if (this.a == null) {
            return;
        }
        if (this.a.i() != BookState.NORMAL) {
            ai.a().a(this.a, true);
            return;
        }
        this.a.al();
        this.a.aL();
    }
}
