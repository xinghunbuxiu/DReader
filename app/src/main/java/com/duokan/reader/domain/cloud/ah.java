package com.duokan.reader.domain.cloud;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.j;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.document.epub.c;

class ah extends WebSession {
    b a;
    final /* synthetic */ ab b;
    final /* synthetic */ c c;
    final /* synthetic */ com.duokan.reader.domain.bookshelf.c d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ boolean h;
    final /* synthetic */ aq i;
    final /* synthetic */ DkCloudStorage j;

    ah(DkCloudStorage dkCloudStorage, ab abVar, c cVar, com.duokan.reader.domain.bookshelf.c cVar2, String str, String str2, String str3, boolean z, aq aqVar) {
        this.j = dkCloudStorage;
        this.b = abVar;
        this.c = cVar;
        this.d = cVar2;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = z;
        this.i = aqVar;
    }

    protected void onSessionTry() {
        this.a = new j(this, this.b).a(this.j.c.getString(i.app__shared__build_name) + " " + ReaderEnv.get().getVersionName(), this.d.H(), this.d.aw(), this.d.o() == BookType.SERIAL ? "LianZai" : this.d.I(), String.format("(%getScaledTouchSlop, %getScaledTouchSlop, %getScaledTouchSlop)", new Object[]{Long.valueOf(this.c.g()), Long.valueOf(this.c.h()), Long.valueOf(this.c.i())}), this.e, this.f, this.g, this.h, this.b.c);
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0) {
            this.i.a();
        } else {
            this.i.a(this.a.c);
        }
    }

    protected void onSessionFailed() {
        this.i.a(this.j.c.getString(i.general__shared__network_error));
    }
}
