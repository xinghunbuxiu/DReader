package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;

import java.util.List;

class an implements u {
    final /* synthetic */ List a;
    final /* synthetic */ aw b;
    final /* synthetic */ DkMessagesManager c;

    an(DkMessagesManager dkMessagesManager, List list, aw awVar) {
        this.c = dkMessagesManager;
        this.a = list;
        this.b = awVar;
    }

    public void onQueryAccountOk(a aVar) {
        this.c.k = new ab(aVar);
        new ao(this, this.c.k).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.b.a("");
    }
}
