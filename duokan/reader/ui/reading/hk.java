package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.store.aq;

class hk implements u {
    final /* synthetic */ long a;
    final /* synthetic */ hj b;

    hk(hj hjVar, long j) {
        this.b = hjVar;
        this.a = j;
    }

    public void onQueryAccountOk(a aVar) {
        if (this.b.a.f.aj()) {
            aq.a(this.b.a.getContext(), (ho) this.b.a.c, this.a);
        }
    }

    public void onQueryAccountError(a aVar, String str) {
    }
}
