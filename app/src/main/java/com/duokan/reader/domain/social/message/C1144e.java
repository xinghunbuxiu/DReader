package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.C0634h;
import com.duokan.reader.common.webservices.duokan.DkCommentDetailInfo;
import com.duokan.reader.domain.account.User;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.e */
public class C1144e extends C1138l {
    /* renamed from: a */
    public C0634h f5536a;
    /* renamed from: b */
    public DkCommentDetailInfo f5537b;
    /* renamed from: c */
    public C0634h f5538c;

    /* renamed from: a */
    public static C1144e m8554a(JSONObject jSONObject) {
        C1144e c1144e = new C1144e();
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.j.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.k = jSONObject.getString("comment_id");
        dkCommentDetailInfo.f2073a = jSONObject.getString("book_id");
        dkCommentDetailInfo.f2074b = jSONObject.optString("book_name");
        dkCommentDetailInfo.l = jSONObject.getString(ClientCookie.COMMENT_ATTR);
        c1144e.f5537b = dkCommentDetailInfo;
        C0634h c0634h = new C0634h();
        c0634h.f2136a.mUserId = jSONObject.getString("reply_user_id");
        c0634h.f2136a.mNickName = jSONObject.optString("reply_alias");
        c0634h.f2136a.mIconUrl = jSONObject.optString("reply_user_icon");
        c0634h.f2138c = jSONObject.getString("reply_id");
        c0634h.f2137b = jSONObject.getString("reply");
        c0634h.m2870a(jSONObject.getLong("reply_time"));
        c1144e.f5536a = c0634h;
        c0634h = new C0634h();
        c0634h.f2136a.mUserId = jSONObject.getString("re_reply_user_id");
        c0634h.f2136a.mNickName = jSONObject.optString("re_reply_alias");
        c0634h.f2136a.mIconUrl = jSONObject.optString("re_reply_user_icon");
        c0634h.f2138c = jSONObject.getString("re_reply_id");
        c0634h.f2137b = jSONObject.getString("re_reply");
        c0634h.m2870a(jSONObject.getLong("re_reply_time"));
        c1144e.f5538c = c0634h;
        return c1144e;
    }

    /* renamed from: a */
    public User mo1515a() {
        return this.f5538c.f2136a;
    }

    /* renamed from: b */
    public String mo1516b() {
        return this.f5538c.f2137b;
    }

    /* renamed from: c */
    public long mo1518c() {
        return this.f5538c.m2869a();
    }

    /* renamed from: b */
    public void mo1517b(JSONObject jSONObject) {
        try {
            jSONObject.put("reply_alias", this.f5536a.f2136a.mNickName);
            jSONObject.put("reply_user_icon", this.f5536a.f2136a.mIconUrl);
            jSONObject.put("re_reply_alias", this.f5538c.f2136a.mNickName);
            jSONObject.put("re_reply_user_icon", this.f5538c.f2136a.mIconUrl);
        } catch (JSONException e) {
        }
    }
}
