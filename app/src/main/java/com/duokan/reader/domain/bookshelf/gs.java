package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.document.epub.C0809b;
import com.duokan.reader.domain.document.epub.an;
import java.util.ArrayList;

class gs implements an {
    /* renamed from: a */
    final /* synthetic */ fp f3253a;
    /* renamed from: b */
    private final String[] f3254b;
    /* renamed from: c */
    private final String[] f3255c;
    /* renamed from: d */
    private final ArrayList<gi> f3256d = new ArrayList();

    public gs(fp fpVar) {
        this.f3253a = fpVar;
        fpVar.aV().mo1091a(fpVar.aH());
        try {
            this.f3254b = fpVar.bm();
            this.f3255c = fpVar.bo();
            if (fpVar.mo1038k() && fpVar.al()) {
                this.f3256d.ensureCapacity(this.f3254b.length / 2);
            } else {
                this.f3256d.ensureCapacity(this.f3254b.length / 2);
            }
            for (int i = 0; i < this.f3254b.length; i += 2) {
                int i2 = i / 2;
                this.f3256d.add(new gi(fpVar, this.f3254b[i], this.f3254b[i + 1], i2 < this.f3255c.length ? this.f3255c[i2] : ""));
            }
        } finally {
            fpVar.aV().mo1097b(fpVar.aH());
        }
    }

    /* renamed from: a */
    public int mo1067a() {
        return this.f3256d.size();
    }

    /* renamed from: a */
    public C0809b mo1069a(int i) {
        return (C0809b) this.f3256d.get(i);
    }

    /* renamed from: a */
    public int mo1068a(an anVar) {
        if (this == anVar) {
            return 0;
        }
        gs gsVar = (gs) anVar;
        if (this.f3254b != gsVar.f3254b || this.f3255c != gsVar.f3255c) {
            return 2;
        }
        for (int i = 0; i < this.f3256d.size(); i++) {
            if (((gi) this.f3256d.get(i)).m4534d() != ((gi) gsVar.f3256d.get(i)).m4534d()) {
                return 1;
            }
        }
        return 0;
    }
}
