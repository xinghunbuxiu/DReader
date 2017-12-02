package com.duokan.reader.domain.ad;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class f {
    public final String a;
    public final int b;

    private f(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static f a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new f(jSONObject.getString("url"), jSONObject.getInt("materialType"));
        } catch (JSONException e) {
            return null;
        }
    }

    public static List a(JSONArray jSONArray) {
        List linkedList = new LinkedList();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    linkedList.add(a(jSONArray.optJSONObject(i)));
                    i++;
                } catch (Throwable th) {
                }
            }
        }
        return linkedList;
    }
}
