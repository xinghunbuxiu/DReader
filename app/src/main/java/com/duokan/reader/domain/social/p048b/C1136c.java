package com.duokan.reader.domain.social.p048b;

import android.text.TextUtils;
import com.duokan.reader.domain.account.User;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.b.c */
public class C1136c {
    /* renamed from: a */
    public String f5460a;
    /* renamed from: b */
    public boolean f5461b;
    /* renamed from: c */
    public int f5462c;
    /* renamed from: d */
    public int f5463d;
    /* renamed from: e */
    public int f5464e;
    /* renamed from: f */
    public int f5465f;
    /* renamed from: g */
    public int f5466g;
    /* renamed from: h */
    public float f5467h;
    /* renamed from: i */
    public String f5468i;
    /* renamed from: j */
    public String f5469j;

    public C1136c(String str) {
        this.f5460a = str;
        this.f5461b = false;
        this.f5462c = 0;
        this.f5468i = "";
        this.f5463d = 0;
        this.f5464e = 0;
        this.f5465f = 0;
        this.f5466g = 0;
        this.f5467h = 0.0f;
        this.f5469j = "";
    }

    public C1136c(User user) {
        this.f5460a = user.mUserId;
        this.f5461b = user.mIsVip;
        this.f5462c = 0;
        this.f5468i = "";
        this.f5463d = 0;
        this.f5464e = 0;
        this.f5465f = 0;
        this.f5466g = 0;
        this.f5467h = 0.0f;
        this.f5469j = "";
    }

    public C1136c(String str, JSONObject jSONObject) {
        boolean z = true;
        this.f5460a = str;
        if (jSONObject.optInt("is_vip", 0) != 1) {
            z = false;
        }
        this.f5461b = z;
        this.f5468i = jSONObject.optString("description");
        if (TextUtils.isEmpty(this.f5468i)) {
            this.f5468i = jSONObject.optString("intro");
        }
        this.f5463d = jSONObject.optInt("following_count", 0);
        this.f5464e = jSONObject.optInt("follower_count", 0);
        this.f5465f = jSONObject.optInt("note_count", 0);
        this.f5466g = jSONObject.optInt("favourite_count", 0);
        this.f5467h = (float) jSONObject.optDouble("ranking", 0.0d);
        this.f5469j = jSONObject.optString("auth_info");
    }

    /* renamed from: a */
    public JSONObject m8460a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_vip", this.f5461b ? 1 : 0);
            jSONObject.put("following_count", this.f5463d);
            jSONObject.put("follower_count", this.f5464e);
            jSONObject.put("note_count", this.f5465f);
            jSONObject.put("favourite_count", this.f5466g);
            jSONObject.put("ranking", (double) this.f5467h);
            jSONObject.put("description", this.f5468i);
            jSONObject.put("auth_info", this.f5469j);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m8461a(C1136c c1136c) {
        this.f5460a = c1136c.f5460a;
        this.f5461b = c1136c.f5461b;
        this.f5462c = c1136c.f5462c;
        this.f5468i = c1136c.f5468i;
        this.f5463d = c1136c.f5463d;
        this.f5464e = c1136c.f5464e;
        this.f5465f = c1136c.f5465f;
        this.f5466g = c1136c.f5466g;
        this.f5467h = c1136c.f5467h;
        this.f5469j = c1136c.f5469j;
    }
}
