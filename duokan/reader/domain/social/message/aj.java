package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;

class aj implements u {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ ax c;
    final /* synthetic */ boolean d;
    final /* synthetic */ DkMessagesManager e;

    aj(DkMessagesManager dkMessagesManager, int i, int i2, ax axVar, boolean z) {
        this.e = dkMessagesManager;
        this.a = i;
        this.b = i2;
        this.c = axVar;
        this.d = z;
    }

    public void onQueryAccountOk(a aVar) {
        this.e.k = new ab(aVar);
        new ak(this, this.e.k).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.c.a(new k[0], "");
    }
}
