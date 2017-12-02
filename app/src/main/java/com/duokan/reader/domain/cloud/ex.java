package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;

class ex implements h {
    final /* synthetic */ DkUserReadingNotesManager a;

    ex(DkUserReadingNotesManager dkUserReadingNotesManager) {
        this.a = dkUserReadingNotesManager;
    }

    public void a(a aVar) {
        this.a.d = new ab(aVar);
        new fn(this.a.d).recover();
    }

    public void b(a aVar) {
        this.a.c();
    }

    public void c(a aVar) {
        new ey(this, this.a.d).open();
        this.a.d = ab.g;
        this.a.e = 0;
        this.a.d();
    }

    public void d(a aVar) {
    }
}
