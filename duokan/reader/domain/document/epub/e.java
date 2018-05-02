package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.b;
import com.duokan.reader.domain.document.j;

abstract class e implements j {
    public abstract b[] a(long j);

    public abstract DkeBook h();

    public abstract long i();

    e() {
    }

    public long b(long j) {
        return Math.max(0, Math.min(j, i() - 1));
    }

    public boolean c(long j) {
        return b(j) == j;
    }
}
