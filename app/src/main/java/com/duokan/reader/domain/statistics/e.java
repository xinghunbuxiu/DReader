package com.duokan.reader.domain.statistics;

class e implements Runnable {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (this.a.e.e()) {
            new f(this).open();
        }
    }
}
