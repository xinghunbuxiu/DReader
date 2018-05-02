package com.duokan.reader.domain.bookshelf;

class ge implements Runnable {
    final /* synthetic */ fe a;
    final /* synthetic */ fv b;

    ge(fv fvVar, fe feVar) {
        this.b = fvVar;
        this.a = feVar;
    }

    public void run() {
        if (this.a.c != null) {
            this.a.c.a(this.a.b);
        }
    }
}
