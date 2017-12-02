package com.duokan.reader.ui.personal;

import com.duokan.core.app.x;
import com.duokan.core.ui.j;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.store.bv;

class hu extends r {
    final /* synthetic */ j a;
    final /* synthetic */ ht b;
    private b c = null;

    hu(ht htVar, j jVar) {
        this.b = htVar;
        this.a = jVar;
    }

    protected void onSessionTry() {
        this.c = new o(this, null).e(this.b.c.getBookUuid());
    }

    protected void onSessionSucceeded() {
        this.a.dismiss();
        this.b.d.a.r.pushPageSmoothly(bv.a(x.a(this.b.d.a.getContext()), "0", Integer.parseInt(((String[]) this.c.a)[0]), ((String[]) this.c.a)[1], null), null);
    }

    protected void onSessionFailed() {
        this.a.dismiss();
        be.a(this.b.d.a.getContext(), this.b.d.a.a.getString(com.duokan.c.j.general__shared__network_error), 1).show();
    }
}
