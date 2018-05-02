package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.document.epub.an;
import com.duokan.reader.domain.document.epub.b;

import java.util.ArrayList;

class gy implements an {
    final /* synthetic */ fv a;
    private final String[] b;
    private final String[] c;
    private final ArrayList d = new ArrayList();

    public gy(fv fvVar) {
        this.a = fvVar;
        fvVar.aT().a(fvVar.aF());
        try {
            this.b = fvVar.bk();
            this.c = fvVar.bm();
            if (fvVar.k() && fvVar.aj()) {
                this.d.ensureCapacity(this.b.length / 2);
            } else {
                this.d.ensureCapacity(this.b.length / 2);
            }
            for (int i = 0; i < this.b.length; i += 2) {
                int i2 = i / 2;
                this.d.add(new go(fvVar, this.b[i], this.b[i + 1], i2 < this.c.length ? this.c[i2] : ""));
            }
        } finally {
            fvVar.aT().b(fvVar.aF());
        }
    }

    public int a() {
        return this.d.size();
    }

    public b a(int i) {
        return (b) this.d.get(i);
    }

    public int a(an anVar) {
        if (this == anVar) {
            return 0;
        }
        gy gyVar = (gy) anVar;
        if (this.b != gyVar.b || this.c != gyVar.c) {
            return 2;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (((go) this.d.get(i)).d() != ((go) gyVar.d.get(i)).d()) {
                return 1;
            }
        }
        return 0;
    }
}
