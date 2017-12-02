package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

import org.json.JSONObject;

class k implements u {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ p b;
    final /* synthetic */ boolean c;
    final /* synthetic */ h d;

    k(h hVar, JSONObject jSONObject, p pVar, boolean z) {
        this.d = hVar;
        this.a = jSONObject;
        this.b = pVar;
        this.c = z;
    }

    public void onQueryAccountOk(a aVar) {
        new l(this, aVar, aVar.b()).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.b.a(str);
    }
}
