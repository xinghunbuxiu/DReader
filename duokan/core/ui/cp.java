package com.duokan.core.ui;

class cp implements Runnable {
    final /* synthetic */ co a;

    cp(co coVar) {
        this.a = coVar;
    }

    public void run() {
        if (this.a.c.j != null) {
            this.a.c.j.b(this.a.c.c, this.a.c.b, this.a.b);
        }
    }
}
