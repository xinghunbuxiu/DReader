package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.ee;
import com.mipay.sdk.Mipay;
import org.json.JSONObject;

class it implements as {
    /* renamed from: a */
    final /* synthetic */ String f8013a;
    /* renamed from: b */
    final /* synthetic */ ci f8014b;

    it(ci ciVar, String str) {
        this.f8014b = ciVar;
        this.f8013a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f8013a);
        String string = jSONObject.getString("msgid");
        C0800c b = ai.m3980a().m3906b(String.valueOf(jSONObject.getJSONObject("params").get("bookUuid")));
        if (b instanceof ee) {
            ((ee) b).m4410a(true, new iu(this, string), new iv(this, string));
            return;
        }
        this.f8014b.f7581b.web_notifyWeb(string, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }
}
