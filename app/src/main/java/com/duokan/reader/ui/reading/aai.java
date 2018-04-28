package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.ak;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

class aai implements Callable<List<String>> {
    /* renamed from: a */
    final /* synthetic */ aah f9330a;

    aai(aah aah) {
        this.f9330a = aah;
    }

    public /* synthetic */ Object call() {
        return m12902a();
    }

    /* renamed from: a */
    public List<String> m12902a() {
        long j = -1;
        LinkedList linkedList = new LinkedList();
        if (this.f9330a.f9329a.f9328c.q) {
            return linkedList;
        }
        ak Z = this.f9330a.f9329a.f9326a.mo2009Z();
        if (Z == null) {
            return linkedList;
        }
        long[] a = this.f9330a.f9329a.f9326a.mo2358a(Z);
        long j2 = a.length < 1 ? -1 : a[0];
        if (j2 >= 0) {
            j = Math.min((((long) this.f9330a.f9329a.f9328c.mo1978B()) + j2) + 1, this.f9330a.f9329a.f9326a.mo2354a());
        }
        while (j2 < j) {
            if (!this.f9330a.f9329a.f9326a.mo2197j(j2).m862b(Boolean.valueOf(false))) {
                linkedList.add(this.f9330a.f9329a.f9326a.mo2356a(j2));
            }
            j2++;
        }
        return linkedList;
    }
}
