package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.common.k;

class bf implements a {
    final /* synthetic */ k a;
    final /* synthetic */ boolean b;
    final /* synthetic */ boolean c;
    final /* synthetic */ aq d;

    bf(aq aqVar, k kVar, boolean z, boolean z2) {
        this.d = aqVar;
        this.a = kVar;
        this.b = z;
        this.c = z2;
    }

    public void a(Void voidR) {
        this.a.a(Integer.valueOf(((Integer) this.a.a()).intValue() + 1));
        if (((Integer) this.a.a()).intValue() == 3) {
            this.d.x();
            try {
                this.d.k.a();
                this.d.a(this.b, this.c, 0);
            } finally {
                this.d.k.b();
            }
        }
    }

    public void a(int i, String str) {
    }
}
