package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.i;
import com.duokan.reader.domain.ad.g;

import org.json.JSONObject;

class jo implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    jo(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        JSONObject jSONObject2 = jSONObject.getJSONObject("params");
        String string = jSONObject.getString("msgid");
        String b = i.b(jSONObject2, "upId");
        int optInt = jSONObject2.optInt("count", 5);
        if (ReaderEnv.get().isVipDevice()) {
            this.b.pageController.web_notifyWeb(string, 0, new JSONObject());
        } else {
            g.a().a(b, optInt, new jp(this, string));
        }
    }
}
