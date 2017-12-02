package com.duokan.reader.domain.a;

import com.duokan.reader.common.webservices.duokan.i;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.r;

class b extends r {
    final /* synthetic */ String a;
    final /* synthetic */ g b;
    final /* synthetic */ a c;
    private com.duokan.reader.common.webservices.b d = null;
    private com.duokan.reader.common.webservices.b e = null;

    b(a aVar, String str, g gVar) {
        this.c = aVar;
        this.a = str;
        this.b = gVar;
    }

    protected void onSessionTry() {
        this.e = new o(this, null).g(this.a);
        this.d = new i(this, this.c.d.c()).f((String) this.e.a);
    }

    protected void onSessionSucceeded() {
        this.b.a(((Integer) this.d.a).intValue());
    }

    protected void onSessionFailed() {
        this.b.a(this.c.c.getString(com.duokan.b.i.general__shared__network_error));
    }
}
