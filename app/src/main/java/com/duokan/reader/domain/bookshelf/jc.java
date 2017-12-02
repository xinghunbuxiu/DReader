package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.o;

class jc implements Runnable {
    final /* synthetic */ o a;
    final /* synthetic */ boolean b;
    final /* synthetic */ jj c;
    final /* synthetic */ String d;
    final /* synthetic */ ja e;

    jc(ja jaVar, o oVar, boolean z, jj jjVar, String str) {
        this.e = jaVar;
        this.a = oVar;
        this.b = z;
        this.c = jjVar;
        this.d = str;
    }

    public void run() {
        synchronized (this.e.a) {
            if (b.a(this.a.j(), this.e.a.i)) {
                if (this.e.a.l) {
                    this.e.a.k.a = this.c.a;
                    this.e.a.k.a(this.d);
                } else if (this.b) {
                    this.e.a.k = this.c;
                    this.e.a.l = true;
                }
            }
        }
    }
}
