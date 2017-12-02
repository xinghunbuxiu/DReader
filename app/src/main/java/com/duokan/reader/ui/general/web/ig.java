package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.mipay.sdk.Mipay;

import org.json.JSONObject;

class ig implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    ig(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        c b = ai.a().b(String.valueOf(jSONObject.getJSONObject("params").get("bookUuid")));
        if (b instanceof ej) {
            ((ej) b).a(true, new ih(this, string), new ii(this, string));
            return;
        }
        this.b.b.web_notifyWeb(string, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }
}
