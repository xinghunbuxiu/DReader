package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.ab;
import com.mipay.sdk.Mipay;

import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

public class ac extends ad {
    public ac(WebSession webSession, ab abVar) {
        super(webSession, abVar);
    }

    public b a(String str, String str2) {
        JSONObject a = a(a(a(true, a() + "/task/v2/user/finish", "task_id", str, "book_id", str2)), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString("msg", "");
        return bVar;
    }

    private String a() {
        return p.i().n();
    }
}
