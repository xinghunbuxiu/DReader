package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.C0798a;
import java.util.Comparator;

class nv implements Comparator<C0798a> {
    /* renamed from: a */
    final /* synthetic */ nu f10722a;

    nv(nu nuVar) {
        this.f10722a = nuVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m14793a((C0798a) obj, (C0798a) obj2);
    }

    /* renamed from: a */
    public int m14793a(C0798a c0798a, C0798a c0798a2) {
        if (c0798a.m3726d().mo1190c(c0798a2.m3726d())) {
            return 1;
        }
        if (c0798a.m3726d().mo1188a(c0798a2.m3726d())) {
            return -1;
        }
        return 0;
    }
}
