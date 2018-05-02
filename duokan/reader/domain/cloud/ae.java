package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class ae implements u {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ ap d;
    final /* synthetic */ DkCloudStorage e;

    ae(DkCloudStorage dkCloudStorage, String str, boolean z, String str2, ap apVar) {
        this.e = dkCloudStorage;
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = apVar;
    }

    public void onQueryAccountOk(a aVar) {
        new af(this, aVar, aVar.b()).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.d.a(str);
    }
}
