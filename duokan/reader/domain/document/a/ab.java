package com.duokan.reader.domain.document.a;

class ab implements Runnable {
    final /* synthetic */ w a;

    ab(w wVar) {
        this.a = wVar;
    }

    public void run() {
        this.a.k = true;
        this.a.d();
        this.a.invalidateSelf();
    }
}
