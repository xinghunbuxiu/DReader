package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;

class er implements u {
    final /* synthetic */ long a;
    final /* synthetic */ int b;
    final /* synthetic */ ev c;
    final /* synthetic */ boolean d;
    final /* synthetic */ DkUserReadBookManager e;

    er(DkUserReadBookManager dkUserReadBookManager, long j, int i, ev evVar, boolean z) {
        this.e = dkUserReadBookManager;
        this.a = j;
        this.b = i;
        this.c = evVar;
        this.d = z;
    }

    public void onQueryAccountOk(a aVar) {
        this.e.f = new ab(aVar);
        new es(this, this.e.f).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.c.a(str);
    }
}
