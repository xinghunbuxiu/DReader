package com.duokan.reader.domain.document.sbk;

class ab implements Runnable {
    final /* synthetic */ y a;

    ab(y yVar) {
        this.a = yVar;
    }

    public void run() {
        if (!this.a.F()) {
            this.a.invalidateSelf();
        }
    }
}
