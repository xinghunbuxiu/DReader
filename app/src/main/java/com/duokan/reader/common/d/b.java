package com.duokan.reader.common.d;

class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        Object obj = 1;
        this.a.j = null;
        synchronized (this.a) {
            if (this.a.i) {
                obj = null;
            } else {
                this.a.i = true;
            }
        }
        if (obj != null) {
            this.a.b.a(this.a);
        }
    }
}
