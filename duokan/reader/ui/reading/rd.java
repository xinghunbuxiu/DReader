package com.duokan.reader.ui.reading;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.gn;

class rd implements is {
    final /* synthetic */ ej a;
    final /* synthetic */ rc b;

    rd(rc rcVar, ej ejVar) {
        this.b = rcVar;
        this.a = ejVar;
    }

    public void a(c cVar) {
        a.d().b(this.a.H(), this.a.G().c);
        new re(this, cVar).open();
        if (cVar.s() == BookPackageType.EPUB_OPF) {
            cVar.b(new af(Boolean.valueOf(true)));
        }
        if (!PersonalPrefs.a().o()) {
            gn.a().a(cVar.ap());
        }
        this.b.a.run();
    }

    public void a(String str) {
        this.b.a.run();
    }
}
