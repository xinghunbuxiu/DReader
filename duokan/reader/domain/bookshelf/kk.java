package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.document.sbk.a;
import com.duokan.reader.domain.document.sbk.q;

import java.util.ArrayList;

class kk implements q {
    final /* synthetic */ jv a;
    private final String[] b;
    private final String[] c;
    private final ArrayList d;

    public kk(jv jvVar) {
        this.a = jvVar;
        jvVar.aT().a(jvVar.aF());
        try {
            this.b = jvVar.bk();
            this.c = jvVar.bm();
            jvVar.bp();
            try {
                this.d = new ArrayList(this.b.length / 2);
                for (int i = 0; i < this.b.length; i += 2) {
                    this.d.add(new kj(jvVar, this.b[i], this.b[i + 1], this.c[i / 2]));
                }
            } finally {
                jvVar.bq();
            }
        } finally {
            jvVar.aT().b(jvVar.aF());
        }
    }

    public int a() {
        return this.d.size();
    }

    public a a(int i) {
        if (i < 0 || i >= this.d.size()) {
            return null;
        }
        return (a) this.d.get(i);
    }

    public int a(q qVar) {
        if (this == qVar) {
            return 0;
        }
        kk kkVar = (kk) qVar;
        if (this.b != kkVar.b || this.c != kkVar.c) {
            return 2;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (((a) this.d.get(i)).a() != ((a) kkVar.d.get(i)).a()) {
                return 1;
            }
        }
        return 0;
    }
}
