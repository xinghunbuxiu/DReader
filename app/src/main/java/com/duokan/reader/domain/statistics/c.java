package com.duokan.reader.domain.statistics;

class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (this.a.e.e()) {
            new d(this).open();
        }
    }
}
