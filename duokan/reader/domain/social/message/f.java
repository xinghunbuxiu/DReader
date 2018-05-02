package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.DkCommentDetailInfo;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.social.a;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

public class f extends l {
    public a a;
    public DkCommentDetailInfo b;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        a aVar = new a();
        aVar.a.mUserId = jSONObject.getString("reply_user_id");
        aVar.a.mNickName = jSONObject.getString("reply_alias");
        aVar.b = jSONObject.getLong("reply_time");
        fVar.a = aVar;
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.j.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.k = jSONObject.getString("comment_id");
        dkCommentDetailInfo.a = jSONObject.getString("book_id");
        dkCommentDetailInfo.l = jSONObject.getString(ClientCookie.COMMENT_ATTR);
        fVar.b = dkCommentDetailInfo;
        return fVar;
    }

    public User a() {
        return this.a.a;
    }

    public String b() {
        return "";
    }

    public long c() {
        return this.a.b;
    }

    public void b(JSONObject jSONObject) {
    }
}
