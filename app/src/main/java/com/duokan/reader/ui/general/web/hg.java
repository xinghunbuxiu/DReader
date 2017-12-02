package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.store.DkStoreBookDetail;

import org.json.JSONObject;

class hg implements as {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ hf f;

    hg(hf hfVar, JSONObject jSONObject, String str, String str2, String str3, String str4) {
        this.f = hfVar;
        this.a = jSONObject;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public void a() {
        DkStoreBookDetail dkStoreBookDetail;
        if (this.a.has("detail")) {
            dkStoreBookDetail = new DkStoreBookDetail(this.a.getJSONObject("detail"));
        } else {
            dkStoreBookDetail = null;
        }
        if (dkStoreBookDetail != null) {
            this.f.b.b.downloadLinearBook(this.b, this.c, this.d, dkStoreBookDetail, this.e);
        } else {
            this.f.b.b.queryBookDetail(this.d, new hh(this), true);
        }
    }
}
