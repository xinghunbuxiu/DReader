package com.duokan.reader.domain.account;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import com.duokan.reader.domain.social.b.b;
import com.duokan.reader.domain.social.b.c;

import org.json.JSONObject;

public class bh extends g {
    public String a = "";
    public String b = "";
    public String c;
    public String d;
    public b e = new b();
    public com.duokan.reader.domain.social.a.b f;
    public boolean g;
    public boolean h;
    public int i;
    public String[] j;
    public boolean k;
    public String l;

    public bh(String str) {
        this.e.a.mUserId = str;
        this.e.b = new c(this.e.a);
        this.f = new com.duokan.reader.domain.social.a.b();
        this.g = false;
        this.h = true;
        this.i = -1;
        this.j = new String[0];
        this.k = false;
        this.l = "";
    }

    public String a() {
        if (TextUtils.isEmpty(this.e.a.mNickName)) {
            return this.e.a.mUserId;
        }
        return this.e.a.mNickName;
    }

    public String b() {
        if (TextUtils.isEmpty(this.e.b.i)) {
            return "";
        }
        return this.e.b.i;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.e.a.mUserId);
            jSONObject.put("miliaoNick", this.e.a.mNickName);
            jSONObject.put("miliaoIcon", this.e.a.mIconUrl);
            if (this.e.b != null) {
                jSONObject.put("user_summary", this.e.b.a());
            }
            if (this.f != null) {
                jSONObject.put("user_feeds_summary", this.f.a());
            }
            jSONObject.put("email_address", this.c);
            jSONObject.put("mobile_phone_address", this.d);
            jSONObject.put("followings_auto_recommended", this.g);
            jSONObject.put("is_newbie", this.h);
            jSONObject.put("gender", this.i);
            jSONObject.put("interest_category", i.a(this.j));
            jSONObject.put("newbie_info_pending_commit", this.k);
            jSONObject.put("user_cert", this.l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static bh a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        bh bhVar = new bh("");
        try {
            bhVar.e = new b();
            bhVar.e.a = new User();
            bhVar.e.a.mUserId = str;
            bhVar.e.a.mNickName = jSONObject.optString("miliaoNick");
            bhVar.e.a.mIconUrl = jSONObject.optString("miliaoIcon");
            if (!TextUtils.isEmpty(bhVar.e.a.mIconUrl)) {
                bhVar.e.a.mIconUrl = bhVar.e.a.mIconUrl.trim();
            }
            bhVar.a = jSONObject.optString("miPassToken");
            bhVar.b = jSONObject.optString("dushuServiceToken");
            if (jSONObject2 != null) {
                bhVar.a = jSONObject2.optString("miPassToken");
                bhVar.b = jSONObject2.optString("dushuServiceToken");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("user_summary");
            if (optJSONObject == null) {
                bhVar.e.b = new c(bhVar.e.a.mUserId);
            } else {
                bhVar.e.b = new c(bhVar.e.a.mUserId, optJSONObject);
            }
            bhVar.e.a.mIsVip = bhVar.e.b.b;
            optJSONObject = jSONObject.optJSONObject("user_feeds_summary");
            if (optJSONObject == null) {
                bhVar.f = new com.duokan.reader.domain.social.a.b();
            } else {
                bhVar.f = new com.duokan.reader.domain.social.a.b(optJSONObject);
            }
            bhVar.c = jSONObject.optString("email_address");
            bhVar.d = jSONObject.optString("mobile_phone_address");
            bhVar.g = jSONObject.optBoolean("followings_auto_recommended");
            bhVar.h = jSONObject.optBoolean("is_newbie", true);
            bhVar.k = jSONObject.optBoolean("newbie_info_pending_commit", false);
            bhVar.i = jSONObject.optInt("gender", -1);
            bhVar.j = i.c(jSONObject, "interest_category");
            bhVar.l = i.a(jSONObject, "user_cert", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bhVar;
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String toLowerCase = str.toLowerCase();
        if (!toLowerCase.startsWith("http://") && !toLowerCase.startsWith("https://")) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        return str.substring(0, lastIndexOf) + "_" + i + str.substring(lastIndexOf, str.length());
    }
}
