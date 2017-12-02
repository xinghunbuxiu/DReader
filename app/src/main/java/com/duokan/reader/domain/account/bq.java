package com.duokan.reader.domain.account;

import android.text.TextUtils;

import com.duokan.reader.domain.social.b.b;
import com.duokan.reader.domain.social.b.c;

import org.json.JSONException;
import org.json.JSONObject;

public class bq extends g {
    public br a = new br();
    public bs b = new bs();
    public String c;
    public c d = new c("");
    public final User e = new User();
    public final b f = new b();

    public String a() {
        return this.a.g;
    }

    public String b() {
        if (this.d != null) {
            return this.d.i;
        }
        return "";
    }

    public static bq a(JSONObject jSONObject, JSONObject jSONObject2) {
        bq bqVar = new bq();
        try {
            JSONObject jSONObject3;
            JSONObject jSONObject4 = jSONObject.getJSONObject("weixin");
            if (TextUtils.isEmpty(jSONObject.getJSONObject("xiaomi").optString("wechatData"))) {
                jSONObject3 = null;
            } else {
                jSONObject3 = new JSONObject(jSONObject.getJSONObject("xiaomi").optString("wechatData"));
            }
            bqVar.a = br.a(jSONObject4, jSONObject3);
            bqVar.b = bs.a(jSONObject.getJSONObject("xiaomi"));
            bqVar.c = jSONObject.optString("user_cert");
            bqVar.e.mIconUrl = bqVar.a.h;
            bqVar.e.mNickName = bqVar.a.g;
            bqVar.e.mUserId = bqVar.b.a;
            bqVar.e.mIsVip = false;
            Object optString = jSONObject.optString("user_summary");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    bqVar.d.a(new c(bqVar.b.a, new JSONObject(optString)));
                } catch (Throwable th) {
                }
            }
            if (jSONObject2 != null) {
                bqVar.a(jSONObject2);
            }
        } catch (JSONException e) {
        }
        return bqVar;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wx_access_token", this.a.b);
            jSONObject.put("wx_refresh_token", this.a.f);
            jSONObject.put("mi_device_id", this.b.d);
            jSONObject.put("mi_visitor_pass_token", this.b.f);
            jSONObject.put("mi_visitor_pass_token_md5", this.b.b);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a.b = jSONObject.getString("wx_access_token");
            this.a.f = jSONObject.getString("wx_refresh_token");
            this.b.d = jSONObject.getString("mi_device_id");
            this.b.f = jSONObject.getString("mi_visitor_pass_token");
            this.b.b = jSONObject.getString("mi_visitor_pass_token_md5");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("weixin", new JSONObject(this.a.toString()));
            jSONObject.put("xiaomi", new JSONObject(this.b.toString()));
            jSONObject.put("user_cert", this.c);
            if (this.d != null) {
                jSONObject.put("user_summary", this.d.a().toString());
            }
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public User d() {
        return this.e;
    }
}
