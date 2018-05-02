package com.duokan.reader.common.webservices;

import com.mipay.sdk.Mipay;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.l */
public class C0660l<T> {
    /* renamed from: d */
    public static final C0663n f2212d = new C0663n();
    /* renamed from: e */
    public static final C0662m f2213e = new C0662m();
    /* renamed from: a */
    public int f2214a;
    /* renamed from: b */
    public String f2215b;
    /* renamed from: c */
    public T f2216c;

    /* renamed from: a */
    public boolean m3100a() {
        return this.f2214a == 0;
    }

    /* renamed from: a */
    public static <T> C0660l<T> m3099a(JSONObject jSONObject, C0661o<T> c0661o) {
        Object obj = null;
        C0660l<T> c0660l = new C0660l();
        if (jSONObject.has(Mipay.KEY_CODE)) {
            c0660l.f2214a = jSONObject.getInt(Mipay.KEY_CODE);
            c0660l.f2215b = jSONObject.optString("description");
            if (c0661o == null || !jSONObject.has("data")) {
                if (c0661o.m3101a()) {
                    obj = c0661o.mo819b(jSONObject, c0660l.f2214a, null);
                }
                c0660l.f2216c = obj;
            } else {
                c0660l.f2216c = c0661o.mo819b(jSONObject, c0660l.f2214a, jSONObject.getJSONObject("data"));
            }
        } else if (jSONObject.getString("S").equals("Ok")) {
            c0660l.f2214a = 0;
            c0660l.f2215b = "";
            if (c0661o == null || !jSONObject.has("R")) {
                c0660l.f2216c = c0661o.mo819b(jSONObject, c0660l.f2214a, null);
            } else {
                c0660l.f2216c = c0661o.mo819b(jSONObject, c0660l.f2214a, jSONObject.getJSONObject("R"));
            }
        } else {
            c0660l.f2214a = Integer.parseInt(jSONObject.getString("R"));
            c0660l.f2215b = jSONObject.optString("Desc");
            c0660l.f2216c = null;
        }
        return c0660l;
    }
}
