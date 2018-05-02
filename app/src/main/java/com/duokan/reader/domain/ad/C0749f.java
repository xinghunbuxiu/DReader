package com.duokan.reader.domain.ad;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.ad.f */
public class C0749f {
    /* renamed from: a */
    public final String f2540a;
    /* renamed from: b */
    public final int f2541b;

    private C0749f(String str, int i) {
        this.f2540a = str;
        this.f2541b = i;
    }

    /* renamed from: a */
    public static C0749f m3559a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new C0749f(jSONObject.getString("url"), jSONObject.getInt("materialType"));
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static List<C0749f> m3560a(JSONArray jSONArray) {
        List<C0749f> linkedList = new LinkedList();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    linkedList.add(C0749f.m3559a(jSONArray.optJSONObject(i)));
                    i++;
                } catch (Throwable th) {
                }
            }
        }
        return linkedList;
    }
}
