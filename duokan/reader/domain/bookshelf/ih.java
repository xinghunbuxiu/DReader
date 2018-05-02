package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.i;

class ih implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ iy b;
    final /* synthetic */ ig c;

    ih(ig igVar, i iVar, iy iyVar) {
        this.c = igVar;
        this.a = iVar;
        this.b = iyVar;
    }

    public void run() {
        if (b.a(this.a.N(), this.c.a.a.j.a)) {
            c d = ai.a().d(this.a.w());
            if (d != null) {
                d.a(this.b);
                d.aL();
                aa b = ai.a().b(d.aH());
                if (b != null) {
                    this.c.a.a.a(d, b.k());
                }
                if (d.ax() > 0) {
                    this.c.a.a.i(d);
                }
            }
        }
    }
}
