package com.duokan.reader.common;

import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

public class i {
    public static JSONArray a(JSONObject jSONObject, String str) {
        Object obj = jSONObject.get(str);
        return obj != JSONObject.NULL ? (JSONArray) obj : new JSONArray();
    }

    public static JSONArray a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            jSONArray = a(jSONObject, str);
        } catch (JSONException e) {
        }
        return jSONArray;
    }

    public static String b(JSONObject jSONObject, String str) {
        return a(jSONObject, str, "");
    }

    public static String a(JSONObject jSONObject, String str, String str2) {
        try {
            Object obj = jSONObject.get(str);
            if (obj != JSONObject.NULL) {
                str2 = String.valueOf(obj);
            }
        } catch (Exception e) {
        }
        return str2;
    }

    public static JSONObject a(File file, JSONObject jSONObject) {
        if (file == null || !file.exists()) {
            return jSONObject;
        }
        Closeable a = a.a(file);
        if (a == null) {
            return jSONObject;
        }
        jSONObject = a((InputStream) a, jSONObject);
        FileUtil1.a(a);
        return jSONObject;
    }

    public static JSONObject a(InputStream inputStream, JSONObject jSONObject) {
        return a(inputStream, HTTP.UTF_8, jSONObject);
    }

    public static JSONObject a(InputStream inputStream, String str, JSONObject jSONObject) {
        try {
            return new JSONObject(new String(FileUtil1.toBytes(inputStream), str));
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    public static String[] c(JSONObject jSONObject, String str) {
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

    public static JSONArray a(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            for (Object put : strArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }
}
