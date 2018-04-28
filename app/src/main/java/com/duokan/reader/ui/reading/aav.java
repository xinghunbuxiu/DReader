package com.duokan.reader.ui.reading;

class aav implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f9354a;
    /* renamed from: b */
    final /* synthetic */ aab f9355b;

    aav(aab aab, Runnable runnable) {
        this.f9355b = aab;
        this.f9354a = runnable;
    }

    public void run() {
        this.f9355b.f9307N.mo975a(Boolean.valueOf(true));
        this.f9354a.run();
    }
}
