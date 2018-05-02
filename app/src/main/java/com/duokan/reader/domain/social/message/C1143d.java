package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.C0634h;
import com.duokan.reader.common.webservices.duokan.DkCommentDetailInfo;
import com.duokan.reader.domain.account.User;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.d */
public class C1143d extends C1138l {
    /* renamed from: a */
    public C0634h f5534a;
    /* renamed from: b */
    public DkCommentDetailInfo f5535b;

    /* renamed from: a */
    public static C1143d m8549a(JSONObject jSONObject) {
        C1143d c1143d = new C1143d();
        C0634h c0634h = new C0634h();
        c0634h.f2136a.mUserId = jSONObject.getString("reply_user_id");
        c0634h.f2136a.mNickName = jSONObject.optString("reply_alias");
        c0634h.f2136a.mIconUrl = jSONObject.optString("reply_user_icon");
        c0634h.f2138c = jSONObject.getString("reply_id");
        c0634h.f2137b = jSONObject.getString("reply");
        c0634h.m2870a(jSONObject.getLong("reply_time"));
        c1143d.f5534a = c0634h;
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.j.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.k = jSONObject.getString("comment_id");
        dkCommentDetailInfo.f2073a = jSONObject.getString("book_id");
        dkCommentDetailInfo.f2074b = jSONObject.optString("book_name");
        dkCommentDetailInfo.l = jSONObject.getString(ClientCookie.COMMENT_ATTR);
        c1143d.f5535b = dkCommentDetailInfo;
        return c1143d;
    }

    /* renamed from: a */
    public User mo1515a() {
        return this.f5534a.f2136a;
    }

    /* renamed from: b */
    public String mo1516b() {
        return this.f5534a.f2137b;
    }

    /* renamed from: c */
    public long mo1518c() {
        return this.f5534a.m2869a();
    }

    /* renamed from: b */
    public void mo1517b(JSONObject jSONObject) {
        try {
            jSONObject.put("reply_alias", this.f5534a.f2136a.mNickName);
            jSONObject.put("reply_user_icon", this.f5534a.f2136a.mIconUrl);
        } catch (JSONException e) {
        }
    }
}
