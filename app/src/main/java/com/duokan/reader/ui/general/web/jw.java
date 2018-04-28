package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.fp;
import java.util.concurrent.Semaphore;

class jw implements as {
    /* renamed from: a */
    final /* synthetic */ Semaphore f8074a;
    /* renamed from: b */
    final /* synthetic */ ji f8075b;

    jw(ji jiVar, Semaphore semaphore) {
        this.f8075b = jiVar;
        this.f8074a = semaphore;
    }

    /* renamed from: a */
    public void mo1831a() {
        ReaderFeature readerFeature = (ReaderFeature) this.f8075b.f8048b.f7581b.getContext().queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            C0800c readingBook = readerFeature.getReadingBook();
            if (readingBook instanceof fp) {
                ((fp) readingBook).m4483a(new jx(this));
                return;
            }
        }
        this.f8074a.release();
    }
}
