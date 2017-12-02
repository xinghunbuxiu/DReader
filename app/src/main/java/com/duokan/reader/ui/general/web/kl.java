package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.util.Log;

import com.mipay.sdk.Mipay;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class kl {
    private static final String a = kl.class.getName();
    private static Map b = new HashMap();

    static {
        b.put(Integer.valueOf(0), "OK");
        b.put(Integer.valueOf(1), "Client parameter error");
        b.put(Integer.valueOf(2), "Common error");
    }

    public static String a(String str, String str2, int i, Object obj) {
        return a(str, str2, i, obj, (String) b.get(Integer.valueOf(i)));
    }

    public static String a(String str, String str2, int i, Object obj, String str3) {
        Log.d(a, "buildCallbackResult");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("window['com.duokan.fiction.handleMessage']");
        stringBuilder.append("(");
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj2;
            jSONObject.put(Mipay.KEY_CODE, i);
            String str4 = Mipay.KEY_MESSAGE;
            if (TextUtils.isEmpty(str3)) {
                obj2 = (String) b.get(Integer.valueOf(i));
            } else {
                String str5 = str3;
            }
            jSONObject.put(str4, obj2);
            jSONObject.put("data", obj);
            jSONObject.put("type", str2);
            jSONObject.put("msgid", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        stringBuilder.append(jSONObject.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String a(String str, String str2, int i, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("window['com.duokan.fiction.handleMessage']");
        stringBuilder.append("(");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Mipay.KEY_CODE, i);
            jSONObject.put(Mipay.KEY_MESSAGE, b.get(Integer.valueOf(i)));
            jSONObject.put("parcelId", str3);
            jSONObject.put("type", str2);
            jSONObject.put("msgid", str);
        } catch (Throwable th) {
        }
        stringBuilder.append(jSONObject.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
