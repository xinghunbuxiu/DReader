package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.domain.ad.C0750g;
import org.json.JSONObject;

class kd implements as {
    /* renamed from: a */
    final /* synthetic */ String f8088a;
    /* renamed from: b */
    final /* synthetic */ ci f8089b;

    kd(ci ciVar, String str) {
        this.f8089b = ciVar;
        this.f8088a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f8088a);
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        String string = jSONObject.getString("msgid");
        String b = C0611i.m2793b(jSONObject2, "upId");
        int optInt = jSONObject2.optInt("count", 5);
        if (ReaderEnv.get().isVipDevice()) {
            this.f8089b.f7581b.web_notifyWeb(string, 0, new JSONObject());
        } else {
            C0750g.m3561a().m3586a(b, optInt, new ke(this, string));
        }
    }
}
