package com.duokan.reader.domain.document.sbk;

class ad implements Runnable {
    final /* synthetic */ y a;

    ad(y yVar) {
        this.a = yVar;
    }

    public void run() {
        this.a.k = true;
        this.a.e();
        this.a.invalidateSelf();
    }
}
