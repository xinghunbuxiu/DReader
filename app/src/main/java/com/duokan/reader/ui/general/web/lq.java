package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.util.Log;
import com.mipay.sdk.Mipay;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class lq {
    /* renamed from: a */
    private static final String f8166a = lq.class.getName();
    /* renamed from: b */
    private static Map<Integer, String> f8167b = new HashMap();

    static {
        f8167b.put(Integer.valueOf(0), "OK");
        f8167b.put(Integer.valueOf(1), "Client parameter error");
        f8167b.put(Integer.valueOf(2), "Common error");
    }

    /* renamed from: a */
    public static String m11291a(String str, String str2, int i, Object obj) {
        return m11292a(str, str2, i, obj, (String) f8167b.get(Integer.valueOf(i)));
    }

    /* renamed from: a */
    public static String m11292a(String str, String str2, int i, Object obj, String str3) {
        Log.d(f8166a, "buildCallbackResult");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("window['com.duokan.fiction.handleMessage']");
        stringBuilder.append("(");
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj2;
            jSONObject.put(Mipay.KEY_CODE, i);
            String str4 = Mipay.KEY_MESSAGE;
            if (TextUtils.isEmpty(str3)) {
                obj2 = (String) f8167b.get(Integer.valueOf(i));
            } else {
                String obj22 = str3;
            }
            jSONObject.put(str4, obj22);
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

    /* renamed from: a */
    public static String m11293a(String str, String str2, int i, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("window['com.duokan.fiction.handleMessage']");
        stringBuilder.append("(");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Mipay.KEY_CODE, i);
            jSONObject.put(Mipay.KEY_MESSAGE, f8167b.get(Integer.valueOf(i)));
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
