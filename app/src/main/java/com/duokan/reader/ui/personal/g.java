package com.duokan.reader.ui.personal;

import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.core.sys.af;
import com.duokan.core.ui.j;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jq;

class g implements ac {
    final /* synthetic */ c a;
    final /* synthetic */ f b;

    g(f fVar, c cVar) {
        this.b = fVar;
        this.a = cVar;
    }

    public void a(ab abVar) {
        j a = jq.a(this.b.a.getContext(), "", this.b.a.getResources().getString(com.duokan.c.j.personal__auto_buy_view__deleting), true, true);
        this.a.a(new af(Boolean.valueOf(false)));
        this.a.aL();
        if (this.a.a(true)) {
            be.a(this.b.a.getContext(), com.duokan.c.j.personal__auto_buy_view__delete_fail, 0).show();
        } else {
            this.b.a.k.remove(this.a);
            this.b.a.a(false);
            be.a(this.b.a.getContext(), com.duokan.c.j.personal__auto_buy_view__delete_succeed, 0).show();
        }
        a.dismiss();
    }

    public void b(ab abVar) {
    }
}
