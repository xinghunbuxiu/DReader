package com.duokan.reader.domain.cloud.push;

class ac implements Runnable {
    final /* synthetic */ ab a;

    ac(ab abVar) {
        this.a = abVar;
    }

    public void run() {
        if (this.a.d.j != null) {
            this.a.d.j.a(this.a.a, this.a.b, this.a.c);
        }
    }
}
