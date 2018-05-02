package com.duokan.reader.domain.bookshelf;

import java.util.List;

class bd implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ aq b;

    bd(aq aqVar, List list) {
        this.b = aqVar;
        this.a = list;
    }

    public void run() {
        try {
            this.b.k.a();
            for (c cVar : this.a) {
                if (cVar.ak() == null) {
                    iy b = this.b.b.b(cVar);
                    if (b != null) {
                        cVar.a(b);
                        cVar.aL();
                    }
                }
            }
        } finally {
            this.b.k.b();
        }
    }
}
