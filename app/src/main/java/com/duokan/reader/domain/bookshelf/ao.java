package com.duokan.reader.domain.bookshelf;

class ao implements Runnable {
    /* renamed from: a */
    final /* synthetic */ an f2769a;

    ao(an anVar) {
        this.f2769a = anVar;
    }

    public void run() {
        try {
            this.f2769a.f2688D.mo1091a(this.f2769a.aH());
            this.f2769a.aO();
        } catch (Throwable th) {
            this.f2769a.f2688D.mo1097b(this.f2769a.aH());
        }
        this.f2769a.f2688D.mo1097b(this.f2769a.aH());
    }
}
