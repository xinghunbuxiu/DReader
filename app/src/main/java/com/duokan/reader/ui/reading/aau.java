package com.duokan.reader.ui.reading;

class aau implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f9352a;
    /* renamed from: b */
    final /* synthetic */ aab f9353b;

    aau(aab aab, Runnable runnable) {
        this.f9353b = aab;
        this.f9352a = runnable;
    }

    public void run() {
        this.f9353b.f9307N.mo975a(Boolean.valueOf(false));
        this.f9352a.run();
    }
}
