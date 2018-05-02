package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.C0899j;
import com.duokan.reader.domain.document.C0930b;

/* renamed from: com.duokan.reader.domain.document.epub.e */
abstract class C0934e implements C0899j {
    /* renamed from: a */
    public abstract C0930b[] mo1364a(long j);

    /* renamed from: h */
    public abstract DkeBook mo1365h();

    /* renamed from: i */
    public abstract long mo1366i();

    C0934e() {
    }

    /* renamed from: b */
    public long m6463b(long j) {
        return Math.max(0, Math.min(j, mo1366i() - 1));
    }

    /* renamed from: c */
    public boolean m6464c(long j) {
        return m6463b(j) == j;
    }
}
