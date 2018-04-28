package com.duokan.reader.ui.bookshelf;

class dx implements Runnable {
    /* renamed from: a */
    final /* synthetic */ dw f6362a;

    dx(dw dwVar) {
        this.f6362a = dwVar;
    }

    public void run() {
        this.f6362a.f6361a.f6348a.pushPageSmoothly(new ie(this.f6362a.f6361a.getContext()), null);
    }
}
