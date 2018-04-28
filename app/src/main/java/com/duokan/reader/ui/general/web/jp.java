package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.fp;

class jp implements as {
    /* renamed from: a */
    final /* synthetic */ Runnable f8062a;
    /* renamed from: b */
    final /* synthetic */ ji f8063b;

    jp(ji jiVar, Runnable runnable) {
        this.f8063b = jiVar;
        this.f8062a = runnable;
    }

    /* renamed from: a */
    public void mo1831a() {
        ReaderFeature readerFeature = (ReaderFeature) this.f8063b.f8048b.f7581b.getContext().queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            C0800c readingBook = readerFeature.getReadingBook();
            if ((readingBook instanceof fp) && !readingBook.mo1038k()) {
                ((fp) readingBook).m4483a(new jq(this));
                return;
            }
        }
        this.f8062a.run();
    }
}
