package com.duokan.reader.domain.account;

import com.duokan.reader.ui.general.jq;

class ca implements b {
    final /* synthetic */ jq a;
    final /* synthetic */ b b;
    final /* synthetic */ PersonalAccount c;

    ca(PersonalAccount personalAccount, jq jqVar, b bVar) {
        this.c = personalAccount;
        this.a = jqVar;
        this.b = bVar;
    }

    public void a(a aVar) {
        this.a.dismiss();
        if (this.b != null) {
            this.b.a(aVar);
        }
    }

    public void a(a aVar, String str) {
        this.a.dismiss();
        this.c.h.u();
        if (this.b != null) {
            this.b.a(aVar, str);
        }
    }
}
