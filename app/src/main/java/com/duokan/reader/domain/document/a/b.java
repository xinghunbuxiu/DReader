package com.duokan.reader.domain.document.a;

import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.reader.domain.document.j;

public abstract class b implements j {
    public abstract DkpBook h();

    public abstract DkpBook i();

    public long j() {
        return (long) h().getPageCount();
    }
}
