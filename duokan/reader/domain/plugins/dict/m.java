package com.duokan.reader.domain.plugins.dict;

class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ r b;
    final /* synthetic */ j c;

    m(j jVar, String str, r rVar) {
        this.c = jVar;
        this.a = str;
        this.b = rVar;
    }

    public void run() {
        try {
            if (this.c.d != null) {
                this.c.d.startSearchWord(this.a.trim().toLowerCase(), 2, new o(this.c, this.b));
            } else {
                this.b.a(new s());
            }
        } catch (Throwable th) {
        }
    }
}
