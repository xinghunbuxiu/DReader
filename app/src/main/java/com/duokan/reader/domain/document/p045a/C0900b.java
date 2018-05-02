package com.duokan.reader.domain.document.p045a;

import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.reader.domain.document.C0899j;

/* renamed from: com.duokan.reader.domain.document.a.b */
public abstract class C0900b implements C0899j {
    /* renamed from: h */
    public abstract DkpBook mo1262h();

    /* renamed from: i */
    public abstract DkpBook mo1263i();

    /* renamed from: j */
    public long m5863j() {
        return (long) mo1262h().getPageCount();
    }
}
