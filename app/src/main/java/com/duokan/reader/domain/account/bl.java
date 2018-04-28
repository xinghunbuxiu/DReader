package com.duokan.reader.domain.account;

import android.text.TextUtils;
import com.duokan.reader.domain.social.p048b.C1135b;
import com.duokan.reader.domain.social.p048b.C1136c;
import org.json.JSONException;
import org.json.JSONObject;

public class bl extends C0705g {
    /* renamed from: a */
    public bm f2424a = new bm();
    /* renamed from: b */
    public bn f2425b = new bn();
    /* renamed from: c */
    public String f2426c;
    /* renamed from: d */
    public C1136c f2427d = new C1136c("");
    /* renamed from: e */
    public final User f2428e = new User();
    /* renamed from: f */
    public final C1135b f2429f = new C1135b();

    /* renamed from: a */
    public String mo871a() {
        return this.f2424a.f2436g;
    }

    /* renamed from: b */
    public String mo872b() {
        if (this.f2427d != null) {
            return this.f2427d.f5468i;
        }
        return "";
    }

    /* renamed from: a */
    public static bl m3408a(JSONObject jSONObject, JSONObject jSONObject2) {
        bl blVar = new bl();
        try {
            JSONObject jSONObject3;
            JSONObject jSONObject4 = jSONObject.getJSONObject("weixin");
            if (TextUtils.isEmpty(jSONObject.getJSONObject("xiaomi").optString("wechatData"))) {
                jSONObject3 = null;
            } else {
                jSONObject3 = new JSONObject(jSONObject.getJSONObject("xiaomi").optString("wechatData"));
            }
            blVar.f2424a = bm.m3414a(jSONObject4, jSONObject3);
            blVar.f2425b = bn.m3415a(jSONObject.getJSONObject("xiaomi"));
            blVar.f2426c = jSONObject.optString("user_cert");
            blVar.f2428e.mIconUrl = blVar.f2424a.f2437h;
            blVar.f2428e.mNickName = blVar.f2424a.f2436g;
            blVar.f2428e.mUserId = blVar.f2425b.f2439a;
            blVar.f2428e.mIsVip = false;
            Object optString = jSONObject.optString("user_summary");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    blVar.f2427d.m8461a(new C1136c(blVar.f2425b.f2439a, new JSONObject(optString)));
                } catch (Throwable th) {
                }
            }
            if (jSONObject2 != null) {
                blVar.m3410a(jSONObject2);
            }
        } catch (JSONException e) {
        }
        return blVar;
    }

    /* renamed from: c */
    public JSONObject m3412c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wx_access_token", this.f2424a.f2431b);
            jSONObject.put("wx_refresh_token", this.f2424a.f2435f);
            jSONObject.put("mi_visitor_pass_token", this.f2425b.f2441c);
            jSONObject.put("mi_visitor_pass_token_md5", this.f2425b.f2440b);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m3410a(JSONObject jSONObject) {
        try {
            this.f2424a.f2431b = jSONObject.optString("wx_access_token");
            this.f2424a.f2435f = jSONObject.optString("wx_refresh_token");
            this.f2425b.f2441c = jSONObject.optString("mi_visitor_pass_token");
            this.f2425b.f2440b = jSONObject.optString("mi_visitor_pass_token_md5");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("weixin", new JSONObject(this.f2424a.toString()));
            jSONObject.put("xiaomi", new JSONObject(this.f2425b.toString()));
            jSONObject.put("user_cert", this.f2426c);
            if (this.f2427d != null) {
                jSONObject.put("user_summary", this.f2427d.m8460a().toString());
            }
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    /* renamed from: d */
    public User m3413d() {
        return this.f2428e;
    }
}
