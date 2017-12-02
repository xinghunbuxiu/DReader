package com.duokan.reader.ui.bookshelf;

import com.duokan.c.j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.store.a;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.general.be;

class bx extends r {
    b a = new b();
    final /* synthetic */ String b;
    final /* synthetic */ ReaderFeature c;
    final /* synthetic */ bk d;

    bx(bk bkVar, String str, ReaderFeature readerFeature) {
        this.d = bkVar;
        this.b = str;
        this.c = readerFeature;
    }

    protected void onSessionTry() {
        this.a = new o(this, null).e(this.b);
    }

    protected void onSessionSucceeded() {
        int parseInt = Integer.parseInt(((String[]) this.a.a)[0]);
        String str = ((String[]) this.a.a)[1];
        h byVar = new by(this);
        if (parseInt == 1 || parseInt == 3) {
            a.a().a(str, false, byVar);
        } else if (parseInt == 2) {
            a.a().b(str, true, byVar);
        }
    }

    protected void onSessionFailed() {
        be.a(this.d.getContext(), j.reading__shared__fail_to_open_book, 0).show();
    }
}
