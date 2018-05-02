package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.DkCommentDetailInfo;
import com.duokan.reader.common.webservices.duokan.h;
import com.duokan.reader.domain.account.User;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends l {
    public h a;
    public DkCommentDetailInfo b;

    public static d a(JSONObject jSONObject) {
        d dVar = new d();
        h hVar = new h();
        hVar.a.mUserId = jSONObject.getString("reply_user_id");
        hVar.a.mNickName = jSONObject.optString("reply_alias");
        hVar.a.mIconUrl = jSONObject.optString("reply_user_icon");
        hVar.c = jSONObject.getString("reply_id");
        hVar.b = jSONObject.getString("reply");
        hVar.a(jSONObject.getLong("reply_time"));
        dVar.a = hVar;
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.j.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.k = jSONObject.getString("comment_id");
        dkCommentDetailInfo.a = jSONObject.getString("book_id");
        dkCommentDetailInfo.b = jSONObject.optString("book_name");
        dkCommentDetailInfo.l = jSONObject.getString(ClientCookie.COMMENT_ATTR);
        dVar.b = dkCommentDetailInfo;
        return dVar;
    }

    public User a() {
        return this.a.a;
    }

    public String b() {
        return this.a.b;
    }

    public long c() {
        return this.a.a();
    }

    public void b(JSONObject jSONObject) {
        try {
            jSONObject.put("reply_alias", this.a.a.mNickName);
            jSONObject.put("reply_user_icon", this.a.a.mIconUrl);
        } catch (JSONException e) {
        }
    }
}
