package com.duokan.reader.domain.ad;

import android.os.Build;
import android.text.TextUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.domain.account.C0709k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import miuipub.os.SystemProperties;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.ad.q */
public class C0760q {
    /* renamed from: a */
    private String f2578a;
    /* renamed from: b */
    private String f2579b;
    /* renamed from: c */
    private String f2580c;
    /* renamed from: d */
    private int f2581d = 1;
    /* renamed from: e */
    private Map<String, String> f2582e;

    /* renamed from: a */
    public C0760q m3602a(String str) {
        this.f2578a = str;
        return this;
    }

    /* renamed from: b */
    public C0760q m3604b(String str) {
        this.f2579b = str;
        return this;
    }

    /* renamed from: c */
    public C0760q m3605c(String str) {
        this.f2580c = str;
        return this;
    }

    /* renamed from: a */
    public C0760q m3601a(int i) {
        this.f2581d = i;
        return this;
    }

    /* renamed from: a */
    public C0760q m3603a(Map<String, String> map) {
        this.f2582e = map;
        return this;
    }

    /* renamed from: a */
    public C0624a m3600a() {
        C0624a c0624a = null;
        if (!(TextUtils.isEmpty(this.f2578a) || TextUtils.isEmpty(this.f2579b) || TextUtils.isEmpty(this.f2580c))) {
            try {
                JSONObject a = m3599a(this.f2581d, this.f2582e);
                C0626c c0626c = new C0626c();
                c0626c.m2856b(this.f2578a);
                c0626c.m2853a(HttpPost.METHOD_NAME);
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("upId", this.f2579b));
                arrayList.add(new BasicNameValuePair("v", this.f2580c));
                arrayList.add(new BasicNameValuePair("clientInfo", a.toString()));
                c0626c.m2854a(arrayList);
                c0626c.m2851a().m2835a("Content-Type", "application/x-www-form-urlencoded; UTF-8");
                c0624a = c0626c.m2851a();
            } catch (Throwable th) {
            }
        }
        return c0624a;
    }

    /* renamed from: a */
    private JSONObject m3599a(int i, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("os", "android");
            jSONObject2.put("make", Build.MANUFACTURER);
            jSONObject2.put("model", SystemProperties.get("ro.product.model"));
            try {
                if (ReaderEnv.get().onMiui()) {
                    jSONObject2.put("miuiVersion", SystemProperties.get("ro.build.version.incremental"));
                }
            } catch (Throwable th) {
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("imei", C0709k.m3476a().m3514i());
            jSONObject3.put("ip", DkPublic.getLocalIpAddress());
            jSONObject3.put("connectionType", C0559f.m2476b().m2485d() ? "wifi" : "4g");
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("packageName", DkApp.get().getPackageName());
            jSONObject4.put(ClientCookie.VERSION_ATTR, ReaderEnv.get().getVersionCode());
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("adsCount", i);
            jSONArray.put(jSONObject5);
            jSONObject.put("deviceInfo", jSONObject2);
            jSONObject.put("userInfo", jSONObject3);
            jSONObject.put("appInfo", jSONObject4);
            jSONObject.put("impRequests", jSONArray);
            if (!(map == null || map.isEmpty())) {
                jSONObject2 = new JSONObject();
                for (String str : map.keySet()) {
                    jSONObject2.put(str, map.get(str));
                }
                jSONObject.put("context", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
