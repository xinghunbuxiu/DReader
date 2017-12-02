package com.duokan.reader.domain.document.txt;

class an implements Runnable {
    final /* synthetic */ aj a;

    an(aj ajVar) {
        this.a = ajVar;
    }

    public void run() {
        if (!this.a.F()) {
            this.a.invalidateSelf();
        }
    }
}
