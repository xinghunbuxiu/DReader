package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.DkCommentDetailInfo;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.social.C1133a;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.f */
public class C1145f extends C1138l {
    /* renamed from: a */
    public C1133a f5539a;
    /* renamed from: b */
    public DkCommentDetailInfo f5540b;

    /* renamed from: a */
    public static C1145f m8559a(JSONObject jSONObject) {
        C1145f c1145f = new C1145f();
        C1133a c1133a = new C1133a();
        c1133a.f5456a.mUserId = jSONObject.getString("reply_user_id");
        c1133a.f5456a.mNickName = jSONObject.getString("reply_alias");
        c1133a.f5457b = jSONObject.getLong("reply_time");
        c1145f.f5539a = c1133a;
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.j.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.k = jSONObject.getString("comment_id");
        dkCommentDetailInfo.f2073a = jSONObject.getString("book_id");
        dkCommentDetailInfo.l = jSONObject.getString(ClientCookie.COMMENT_ATTR);
        c1145f.f5540b = dkCommentDetailInfo;
        return c1145f;
    }

    /* renamed from: a */
    public User mo1515a() {
        return this.f5539a.f5456a;
    }

    /* renamed from: b */
    public String mo1516b() {
        return "";
    }

    /* renamed from: c */
    public long mo1518c() {
        return this.f5539a.f5457b;
    }

    /* renamed from: b */
    public void mo1517b(JSONObject jSONObject) {
    }
}
