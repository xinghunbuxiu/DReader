package com.duokan.reader.domain.account.a;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.a.d;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.a;
import com.mipay.sdk.Mipay;

import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

public class b extends ad {
    static final /* synthetic */ boolean a = (!b.class.desiredAssertionStatus());

    public b(WebSession webSession) {
        super(webSession, (a) null);
    }

    public com.duokan.reader.common.webservices.b a(String str, String str2) {
        if (!a && str == null) {
            throw new AssertionError();
        } else if (a || str2 != null) {
            JSONObject a = a(a(a(true, p.i().u(), "auth", str2)), HTTP.UTF_8);
            JSONObject jSONObject = a.getJSONObject("status");
            com.duokan.reader.common.webservices.b bVar = new com.duokan.reader.common.webservices.b();
            bVar.a = new a();
            bVar.b = jSONObject.getInt(Mipay.KEY_CODE);
            bVar.c = jSONObject.optString("msg", "");
            if (bVar.b != 0) {
                return bVar;
            }
            ((a) bVar.a).a = a.getString("token");
            return bVar;
        } else {
            throw new AssertionError();
        }
    }

    public d a(com.duokan.reader.common.webservices.duokan.a.a aVar) {
        aVar.a("accept", "application/json");
        return super.a(aVar);
    }
}
