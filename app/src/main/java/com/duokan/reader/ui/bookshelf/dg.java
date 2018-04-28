package com.duokan.reader.ui.bookshelf;

class dg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ de f6330a;

    dg(de deVar) {
        this.f6330a = deVar;
    }

    public void run() {
        this.f6330a.f6071t = true;
        this.f6330a.invalidate();
    }
}
