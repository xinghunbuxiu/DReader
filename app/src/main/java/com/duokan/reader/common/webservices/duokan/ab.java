package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import com.mipay.sdk.Mipay;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

public class ab extends ac {
    public ab(WebSession webSession, al alVar) {
        super(webSession, alVar);
    }

    /* renamed from: a */
    public C0621a<Void> m2866a(String str, String str2) {
        JSONObject a = m548a(mo376a(m555a(true, m2865a() + "/task/v2/user/finish", "task_id", str, "book_id", str2)), HTTP.UTF_8);
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString("msg", "");
        return c0621a;
    }

    /* renamed from: a */
    private String m2865a() {
        return C0641o.m2934i().m2987n();
    }
}
