package com.duokan.reader.domain.bookshelf;

class gl implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ fv b;

    gl(fv fvVar, Runnable runnable) {
        this.b = fvVar;
        this.a = runnable;
    }

    public void run() {
        this.b.aT().f().a(this.b.H(), new gm(this));
    }
}
