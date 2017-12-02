package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.fv;

class jc implements as {
    final /* synthetic */ Runnable a;
    final /* synthetic */ iv b;

    jc(iv ivVar, Runnable runnable) {
        this.b = ivVar;
        this.a = runnable;
    }

    public void a() {
        ReaderFeature readerFeature = (ReaderFeature) this.b.b.b.getContext().queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            c readingBook = readerFeature.getReadingBook();
            if ((readingBook instanceof fv) && !readingBook.k()) {
                ((fv) readingBook).a(new jd(this));
                return;
            }
        }
        this.a.run();
    }
}
