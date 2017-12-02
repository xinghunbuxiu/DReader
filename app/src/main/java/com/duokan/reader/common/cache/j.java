package com.duokan.reader.common.cache;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class j implements q {
    public static final j a = new j();

    public /* synthetic */ String a(Object obj) {
        return b((JSONObject) obj);
    }

    public /* synthetic */ boolean b(Object obj) {
        return a((JSONObject) obj);
    }

    public /* synthetic */ Object d(String str) {
        return a(str);
    }

    public final boolean a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public final String b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        return jSONObject.toString();
    }

    public final JSONObject a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }
}
