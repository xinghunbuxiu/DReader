package com.duokan.reader.domain.store;

import com.duokan.b.i;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkStoreAbsBookInfo;
import com.duokan.reader.common.webservices.duokan.c;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.PersonalAccount;

class d extends c {
    DkStoreAbsBook[] a;
    boolean b = false;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ i f;
    final /* synthetic */ a g;

    d(a aVar, String str, int i, int i2, i iVar) {
        this.g = aVar;
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = iVar;
    }

    protected void onSessionTry() {
        b a = new v(this, this.g.b.b(PersonalAccount.class)).a(this.c, this.d, this.e);
        if (a.b == 0) {
            this.b = Boolean.valueOf(a.c).booleanValue();
            this.a = new DkStoreAbsBook[((DkStoreAbsBookInfo[]) a.a).length];
            for (int i = 0; i < this.a.length; i++) {
                this.a[i] = new DkStoreAbsBook(((DkStoreAbsBookInfo[]) a.a)[i]);
            }
        }
    }

    protected void onSessionSucceeded() {
        this.f.a(this.a, this.b);
    }

    protected void onSessionFailed() {
        this.f.a(this.g.a.getString(i.general__shared__network_error));
    }
}
