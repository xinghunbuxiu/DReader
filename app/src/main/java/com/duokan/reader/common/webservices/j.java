package com.duokan.reader.common.webservices;

import com.mipay.sdk.Mipay;

import org.json.JSONObject;

public class j {
    public static final l d = new l();
    public static final k e = new k();
    public int a;
    public String b;
    public Object c;

    public boolean a() {
        return this.a == 0;
    }

    public static j a(JSONObject jSONObject, m mVar) {
        Object obj = null;
        j jVar = new j();
        if (jSONObject.has(Mipay.KEY_CODE)) {
            jVar.a = jSONObject.getInt(Mipay.KEY_CODE);
            jVar.b = jSONObject.optString("description");
            if (mVar == null || !jSONObject.has("data")) {
                if (mVar.a()) {
                    obj = mVar.b(jSONObject, jVar.a, null);
                }
                jVar.c = obj;
            } else {
                jVar.c = mVar.b(jSONObject, jVar.a, jSONObject.getJSONObject("data"));
            }
        } else if (jSONObject.getString("S").equals("Ok")) {
            jVar.a = 0;
            jVar.b = "";
            if (mVar == null || !jSONObject.has("R")) {
                jVar.c = mVar.b(jSONObject, jVar.a, null);
            } else {
                jVar.c = mVar.b(jSONObject, jVar.a, jSONObject.getJSONObject("R"));
            }
        } else {
            jVar.a = Integer.parseInt(jSONObject.getString("R"));
            jVar.b = jSONObject.optString("Desc");
            jVar.c = null;
        }
        return jVar;
    }
}
