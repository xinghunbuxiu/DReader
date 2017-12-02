package com.duokan.reader.domain.bookshelf;

class jw implements Runnable {
    final /* synthetic */ fe a;
    final /* synthetic */ jv b;

    jw(jv jvVar, fe feVar) {
        this.b = jvVar;
        this.a = feVar;
    }

    public void run() {
        if (this.a.c != null) {
            this.a.c.a(this.a.b);
        }
    }
}
