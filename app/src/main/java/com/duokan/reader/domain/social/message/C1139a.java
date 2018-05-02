package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.C0631d;
import com.duokan.reader.domain.account.User;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.a */
public class C1139a extends C1138l {
    /* renamed from: a */
    public C0631d f5483a;

    /* renamed from: a */
    public static C1139a m8498a(JSONObject jSONObject) {
        C1139a c1139a = new C1139a();
        C0631d c0631d = new C0631d();
        c0631d.f2120a.mUserId = "800383";
        c0631d.f2120a.mNickName = jSONObject.getString("user_nick");
        c0631d.f2120a.mIconUrl = jSONObject.getString("user_icon");
        c0631d.f2123d = jSONObject.getString("object_id");
        c0631d.f2122c = jSONObject.getString("title");
        c0631d.f2121b = jSONObject.getString("content");
        c0631d.f2124e = jSONObject.getLong("time");
        c1139a.f5483a = c0631d;
        return c1139a;
    }

    /* renamed from: a */
    public User mo1515a() {
        return this.f5483a.f2120a;
    }

    /* renamed from: b */
    public String mo1516b() {
        return this.f5483a.f2121b;
    }

    /* renamed from: c */
    public long mo1518c() {
        return this.f5483a.f2124e;
    }

    /* renamed from: b */
    public void mo1517b(JSONObject jSONObject) {
    }
}
