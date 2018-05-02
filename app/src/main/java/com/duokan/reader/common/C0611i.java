package com.duokan.reader.common;

import com.duokan.core.io.FileUtil;
import com.duokan.core.io.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.i */
public class C0611i {
    /* renamed from: a */
    public static JSONArray m2787a(JSONObject jSONObject, String str) {
        Object obj = jSONObject.get(str);
        return obj != JSONObject.NULL ? (JSONArray) obj : new JSONArray();
    }

    /* renamed from: a */
    public static JSONArray m2788a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            jSONArray = C0611i.m2787a(jSONObject, str);
        } catch (JSONException e) {
        }
        return jSONArray;
    }

    /* renamed from: b */
    public static String m2793b(JSONObject jSONObject, String str) {
        return C0611i.m2786a(jSONObject, str, "");
    }

    /* renamed from: a */
    public static String m2786a(JSONObject jSONObject, String str, String str2) {
        try {
            Object obj = jSONObject.get(str);
            if (obj != JSONObject.NULL) {
                str2 = String.valueOf(obj);
            }
        } catch (Exception e) {
        }
        return str2;
    }

    /* renamed from: a */
    public static JSONObject m2790a(File file, JSONObject jSONObject) {
        if (file == null || !file.exists()) {
            return jSONObject;
        }
        Closeable c = FileUtil.openInputStream(file);
        if (c == null) {
            return jSONObject;
        }
        jSONObject = C0611i.m2792a((InputStream) c, jSONObject);
        IOUtils.close(c);
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m2792a(InputStream inputStream, JSONObject jSONObject) {
        return C0611i.m2791a(inputStream, HTTP.UTF_8, jSONObject);
    }

    /* renamed from: a */
    public static JSONObject m2791a(InputStream inputStream, String str, JSONObject jSONObject) {
        try {
            return new JSONObject(new String(IOUtils.toBytes(inputStream), str));
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    /* renamed from: c */
    public static String[] m2794c(JSONObject jSONObject, String str) {
        int i = 0;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return new String[0];
        }
        String[] strArr = new String[optJSONArray.length()];
        while (i < optJSONArray.length()) {
            strArr[i] = optJSONArray.optString(i, "");
            i++;
        }
        return strArr;
    }

    /* renamed from: a */
    public static JSONArray m2789a(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            for (Object put : strArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }
}
