package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.document.sbk.C0822a;
import com.duokan.reader.domain.document.sbk.C0823q;
import java.util.ArrayList;

class kw implements C0823q {
    /* renamed from: a */
    final /* synthetic */ kh f3490a;
    /* renamed from: b */
    private final String[] f3491b;
    /* renamed from: c */
    private final String[] f3492c;
    /* renamed from: d */
    private final ArrayList<C0822a> f3493d;

    public kw(kh khVar) {
        this.f3490a = khVar;
        khVar.aV().mo1091a(khVar.aH());
        try {
            this.f3491b = khVar.bm();
            this.f3492c = khVar.bo();
            khVar.br();
            try {
                this.f3493d = new ArrayList(this.f3491b.length / 2);
                for (int i = 0; i < this.f3491b.length; i += 2) {
                    this.f3493d.add(new kv(khVar, this.f3491b[i], this.f3491b[i + 1], this.f3492c[i / 2]));
                }
            } finally {
                khVar.bs();
            }
        } finally {
            khVar.aV().mo1097b(khVar.aH());
        }
    }

    /* renamed from: a */
    public int mo1127a() {
        return this.f3493d.size();
    }

    /* renamed from: a */
    public C0822a mo1129a(int i) {
        if (i < 0 || i >= this.f3493d.size()) {
            return null;
        }
        return (C0822a) this.f3493d.get(i);
    }

    /* renamed from: a */
    public int mo1128a(C0823q c0823q) {
        if (this == c0823q) {
            return 0;
        }
        kw kwVar = (kw) c0823q;
        if (this.f3491b != kwVar.f3491b || this.f3492c != kwVar.f3492c) {
            return 2;
        }
        for (int i = 0; i < this.f3493d.size(); i++) {
            if (((C0822a) this.f3493d.get(i)).mo1122a() != ((C0822a) kwVar.f3493d.get(i)).mo1122a()) {
                return 1;
            }
        }
        return 0;
    }
}
