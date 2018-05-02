package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.o;

class jb implements Runnable {
    final /* synthetic */ o a;
    final /* synthetic */ boolean b;
    final /* synthetic */ jj c;
    final /* synthetic */ String d;
    final /* synthetic */ iy e;
    final /* synthetic */ ja f;

    jb(ja jaVar, o oVar, boolean z, jj jjVar, String str, iy iyVar) {
        this.f = jaVar;
        this.a = oVar;
        this.b = z;
        this.c = jjVar;
        this.d = str;
        this.e = iyVar;
    }

    public void run() {
        synchronized (this.f.a) {
            if (b.a(this.a.j(), this.f.a.i)) {
                if (this.f.a.l) {
                    this.f.a.k.a = this.c.a;
                    this.f.a.k.a(this.d);
                    this.f.a.k.a(this.e);
                } else if (this.b) {
                    this.f.a.k = this.c;
                    this.f.a.l = true;
                }
            }
        }
    }
}
