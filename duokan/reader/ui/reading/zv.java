package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.ak;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

class zv implements Callable {
    final /* synthetic */ zu a;

    zv(zu zuVar) {
        this.a = zuVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public List a() {
        long j = -1;
        LinkedList linkedList = new LinkedList();
        if (this.a.a.c.q) {
            return linkedList;
        }
        ak Z = this.a.a.a.Z();
        if (Z == null) {
            return linkedList;
        }
        long[] a = this.a.a.a.a(Z);
        long j2 = a.length < 1 ? -1 : a[0];
        if (j2 >= 0) {
            j = Math.min((((long) this.a.a.c.B()) + j2) + 1, this.a.a.a.a());
        }
        while (j2 < j) {
            if (!this.a.a.a.j(j2).b(Boolean.valueOf(false))) {
                linkedList.add(this.a.a.a.a(j2));
            }
            j2++;
        }
        return linkedList;
    }
}
