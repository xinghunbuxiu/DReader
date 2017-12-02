package com.duokan.reader.ui.reading;

class rm implements Runnable {
    final /* synthetic */ rl a;

    rm(rl rlVar) {
        this.a = rlVar;
    }

    public void run() {
        if (this.a.b.isMenuShowing()) {
            this.a.b.c.b((Runnable) this);
        } else if (this.a.b.J != null && this.a.b.J.m()) {
            this.a.b.c.b((Runnable) this);
        } else if (this.a.b.M != null && this.a.b.M.f()) {
            this.a.b.c.b((Runnable) this);
        } else if (this.a.a != null) {
            this.a.a.run();
        }
    }
}
