package com.duokan.reader.domain.bookshelf;

class jg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ it f3386a;

    jg(it itVar) {
        this.f3386a = itVar;
    }

    public void run() {
        if (this.f3386a.f3365i != null) {
            this.f3386a.f3365i.m4746a();
            this.f3386a.f3365i = null;
        }
    }
}
