package com.duokan.reader.ui.bookshelf;

class du implements Runnable {
    /* renamed from: a */
    final /* synthetic */ dt f6359a;

    du(dt dtVar) {
        this.f6359a = dtVar;
    }

    public void run() {
        this.f6359a.f6358a.f6348a.pushPageSmoothly(new fj(this.f6359a.f6358a.getContext()), null);
    }
}
