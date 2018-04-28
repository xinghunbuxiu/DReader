package com.duokan.reader.domain.account;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.domain.social.p047a.C1132b;
import com.duokan.reader.domain.social.p048b.C1135b;
import com.duokan.reader.domain.social.p048b.C1136c;
import org.json.JSONObject;

public class bd extends C0705g {
    /* renamed from: a */
    public String f2401a = "";
    /* renamed from: b */
    public String f2402b = "";
    /* renamed from: c */
    public String f2403c;
    /* renamed from: d */
    public String f2404d;
    /* renamed from: e */
    public C1135b f2405e = new C1135b();
    /* renamed from: f */
    public C1132b f2406f;
    /* renamed from: g */
    public boolean f2407g;
    /* renamed from: h */
    public boolean f2408h;
    /* renamed from: i */
    public int f2409i;
    /* renamed from: j */
    public String[] f2410j;
    /* renamed from: k */
    public boolean f2411k;
    /* renamed from: l */
    public String f2412l;

    public bd(String str) {
        this.f2405e.f5458a.mUserId = str;
        this.f2405e.f5459b = new C1136c(this.f2405e.f5458a);
        this.f2406f = new C1132b();
        this.f2407g = false;
        this.f2408h = true;
        this.f2409i = -1;
        this.f2410j = new String[0];
        this.f2411k = false;
        this.f2412l = "";
    }

    /* renamed from: a */
    public String mo871a() {
        if (TextUtils.isEmpty(this.f2405e.f5458a.mNickName)) {
            return this.f2405e.f5458a.mUserId;
        }
        return this.f2405e.f5458a.mNickName;
    }

    /* renamed from: b */
    public String mo872b() {
        if (TextUtils.isEmpty(this.f2405e.f5459b.f5468i)) {
            return "";
        }
        return this.f2405e.f5459b.f5468i;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f2405e.f5458a.mUserId);
            jSONObject.put("miliaoNick", this.f2405e.f5458a.mNickName);
            jSONObject.put("miliaoIcon", this.f2405e.f5458a.mIconUrl);
            if (this.f2405e.f5459b != null) {
                jSONObject.put("user_summary", this.f2405e.f5459b.m8460a());
            }
            if (this.f2406f != null) {
                jSONObject.put("user_feeds_summary", this.f2406f.m8454a());
            }
            jSONObject.put("email_address", this.f2403c);
            jSONObject.put("mobile_phone_address", this.f2404d);
            jSONObject.put("followings_auto_recommended", this.f2407g);
            jSONObject.put("is_newbie", this.f2408h);
            jSONObject.put("gender", this.f2409i);
            jSONObject.put("interest_category", C0611i.m2789a(this.f2410j));
            jSONObject.put("newbie_info_pending_commit", this.f2411k);
            jSONObject.put("user_cert", this.f2412l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public static bd m3400a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        bd bdVar = new bd("");
        try {
            bdVar.f2405e = new C1135b();
            bdVar.f2405e.f5458a = new User();
            bdVar.f2405e.f5458a.mUserId = str;
            bdVar.f2405e.f5458a.mNickName = jSONObject.optString("miliaoNick");
            bdVar.f2405e.f5458a.mIconUrl = jSONObject.optString("miliaoIcon");
            if (!TextUtils.isEmpty(bdVar.f2405e.f5458a.mIconUrl)) {
                bdVar.f2405e.f5458a.mIconUrl = bdVar.f2405e.f5458a.mIconUrl.trim();
            }
            bdVar.f2401a = jSONObject.optString("miPassToken");
            bdVar.f2402b = jSONObject.optString("dushuServiceToken");
            if (jSONObject2 != null) {
                bdVar.f2401a = jSONObject2.optString("miPassToken");
                bdVar.f2402b = jSONObject2.optString("dushuServiceToken");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("user_summary");
            if (optJSONObject == null) {
                bdVar.f2405e.f5459b = new C1136c(bdVar.f2405e.f5458a.mUserId);
            } else {
                bdVar.f2405e.f5459b = new C1136c(bdVar.f2405e.f5458a.mUserId, optJSONObject);
            }
            bdVar.f2405e.f5458a.mIsVip = bdVar.f2405e.f5459b.f5461b;
            optJSONObject = jSONObject.optJSONObject("user_feeds_summary");
            if (optJSONObject == null) {
                bdVar.f2406f = new C1132b();
            } else {
                bdVar.f2406f = new C1132b(optJSONObject);
            }
            bdVar.f2403c = jSONObject.optString("email_address");
            bdVar.f2404d = jSONObject.optString("mobile_phone_address");
            bdVar.f2407g = jSONObject.optBoolean("followings_auto_recommended");
            bdVar.f2408h = jSONObject.optBoolean("is_newbie", true);
            bdVar.f2411k = jSONObject.optBoolean("newbie_info_pending_commit", false);
            bdVar.f2409i = jSONObject.optInt("gender", -1);
            bdVar.f2410j = C0611i.m2794c(jSONObject, "interest_category");
            bdVar.f2412l = C0611i.m2786a(jSONObject, "user_cert", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bdVar;
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    public static String m3401a(String str, int i) {
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
