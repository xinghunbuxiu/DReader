package com.duokan.reader.common.cache;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.cache.j */
public class C0577j implements C0575q<JSONObject> {
    /* renamed from: a */
    public static final C0577j f1885a = new C0577j();

    /* renamed from: a */
    public /* synthetic */ String mo776a(Object obj) {
        return m2587b((JSONObject) obj);
    }

    /* renamed from: b */
    public /* synthetic */ boolean mo777b(Object obj) {
        return m2586a((JSONObject) obj);
    }

    /* renamed from: d */
    public /* synthetic */ Object mo778d(String str) {
        return m2585a(str);
    }

    /* renamed from: a */
    public final boolean m2586a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    /* renamed from: b */
    public final String m2587b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public final JSONObject m2585a(String str) {
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
