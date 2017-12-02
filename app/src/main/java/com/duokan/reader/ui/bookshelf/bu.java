package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.t;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.ai;

class bu implements Runnable {
    final /* synthetic */ bt a;

    bu(bt btVar) {
        this.a = btVar;
    }

    public void run() {
        this.a.b.dismiss();
        Object obj = (!i.f().b() || ai.a().c().b()) ? null : 1;
        if (obj != null) {
            new ij(this.a.c.f.getContext()).a(this.a.c.d);
        } else {
            t.b(this.a.c.d);
        }
    }
}
