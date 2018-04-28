package com.duokan.reader.ui.bookshelf;

class fk implements Runnable {
    /* renamed from: a */
    final /* synthetic */ fj f6452a;

    fk(fj fjVar) {
        this.f6452a = fjVar;
    }

    public void run() {
        this.f6452a.requestDetach();
    }
}
