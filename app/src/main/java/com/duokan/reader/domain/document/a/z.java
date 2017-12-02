package com.duokan.reader.domain.document.a;

class z implements Runnable {
    final /* synthetic */ w a;

    z(w wVar) {
        this.a = wVar;
    }

    public void run() {
        if (!this.a.F()) {
            this.a.invalidateSelf();
        }
    }
}
