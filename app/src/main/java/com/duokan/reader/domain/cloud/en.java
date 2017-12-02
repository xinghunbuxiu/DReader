package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;

class en implements u {
    final /* synthetic */ ew a;
    final /* synthetic */ String b;
    final /* synthetic */ DkUserReadBookManager c;

    en(DkUserReadBookManager dkUserReadBookManager, ew ewVar, String str) {
        this.c = dkUserReadBookManager;
        this.a = ewVar;
        this.b = str;
    }

    public void onQueryAccountOk(a aVar) {
        this.c.f = new ab(aVar);
        new eo(this, this.c.f).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.a.a(str);
    }
}
