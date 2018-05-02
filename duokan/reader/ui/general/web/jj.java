package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.fv;

import java.util.concurrent.Semaphore;

class jj implements as {
    final /* synthetic */ Semaphore a;
    final /* synthetic */ iv b;

    jj(iv ivVar, Semaphore semaphore) {
        this.b = ivVar;
        this.a = semaphore;
    }

    public void a() {
        ReaderFeature readerFeature = (ReaderFeature) this.b.b.pageController.getContext().queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            c readingBook = readerFeature.getReadingBook();
            if (readingBook instanceof fv) {
                ((fv) readingBook).a(new jk(this));
                return;
            }
        }
        this.a.release();
    }
}
