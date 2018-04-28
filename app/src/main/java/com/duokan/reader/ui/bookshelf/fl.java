package com.duokan.reader.ui.bookshelf;

class fl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ fj f6453a;

    fl(fj fjVar) {
        this.f6453a = fjVar;
    }

    public void run() {
        this.f6453a.requestDetach();
    }
}
