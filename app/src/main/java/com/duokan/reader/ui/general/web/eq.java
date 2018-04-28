package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.as;
import com.duokan.reader.common.C0611i;
import org.json.JSONObject;

class eq implements as {
    /* renamed from: a */
    final /* synthetic */ String f7792a;
    /* renamed from: b */
    final /* synthetic */ ci f7793b;

    eq(ci ciVar, String str) {
        this.f7793b = ciVar;
        this.f7792a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7792a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        String b = C0611i.m2793b(jSONObject, "hint");
        String b2 = C0611i.m2793b(jSONObject, "confirm");
        String b3 = C0611i.m2793b(jSONObject, "inputted");
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("multi", true));
        C1352a erVar = new er(this, string);
        if (valueOf.booleanValue()) {
            UThread.runOnThread(new es(this, b2, b3, b, erVar));
        } else {
            UThread.runOnThread(new ew(this, b, b3, b2, erVar));
        }
    }
}
