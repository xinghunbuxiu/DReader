package com.duokan.reader.domain.ad;

import android.os.Build;
import android.text.TextUtils;

import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.webservices.duokan.a.a;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.duokan.reader.domain.account.i;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import miuipub.os.SystemProperties;

public class q {
    private String a;
    private String b;
    private String c;
    private int d = 1;
    private Map e;

    public q a(String str) {
        this.a = str;
        return this;
    }

    public q b(String str) {
        this.b = str;
        return this;
    }

    public q c(String str) {
        this.c = str;
        return this;
    }

    public q a(int i) {
        this.d = i;
        return this;
    }

    public q a(Map map) {
        this.e = map;
        return this;
    }

    public a a() {
        a aVar = null;
        if (!(TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c))) {
            try {
                JSONObject a = a(this.d, this.e);
                c cVar = new c();
                cVar.b(this.a);
                cVar.a(HttpPost.METHOD_NAME);
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("upId", this.b));
                arrayList.add(new BasicNameValuePair("v", this.c));
                arrayList.add(new BasicNameValuePair("clientInfo", a.toString()));
                cVar.a(arrayList);
                cVar.a().a("Content-Type", "application/x-www-form-urlencoded; UTF-8");
                aVar = cVar.a();
            } catch (Throwable th) {
            }
        }
        return aVar;
    }

    private JSONObject a(int i, Map map) {
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
            jSONObject3.put("imei", i.f().i());
            jSONObject3.put("ip", DkPublic.getLocalIpAddress());
            jSONObject3.put("connectionType", f.b().d() ? "wifi" : "4g");
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
