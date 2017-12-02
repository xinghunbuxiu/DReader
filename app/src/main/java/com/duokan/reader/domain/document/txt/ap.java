package com.duokan.reader.domain.document.txt;

class ap implements Runnable {
    final /* synthetic */ aj a;

    ap(aj ajVar) {
        this.a = ajVar;
    }

    public void run() {
        this.a.k = true;
        this.a.d();
        this.a.invalidateSelf();
    }
}
