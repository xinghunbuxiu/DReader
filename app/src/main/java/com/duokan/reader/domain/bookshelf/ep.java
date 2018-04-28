package com.duokan.reader.domain.bookshelf;

class ep implements Runnable {
    /* renamed from: a */
    final /* synthetic */ en f3115a;

    ep(en enVar) {
        this.f3115a = enVar;
    }

    public void run() {
        this.f3115a.f3112a.release();
    }
}
