package com.duokan.reader.domain.account.p043b;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.account.b.b */
public class C0702b extends ac {
    /* renamed from: a */
    static final /* synthetic */ boolean f2399a = (!C0702b.class.desiredAssertionStatus());

    public C0702b(WebSession webSession) {
        super(webSession, (C0672a) null);
    }

    /* renamed from: a */
    public C0621a<C0701a> m3388a(String str, String str2) {
        if (!f2399a && str == null) {
            throw new AssertionError();
        } else if (f2399a || str2 != null) {
            JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2994u(), "auth", str2)), HTTP.UTF_8);
            JSONObject jSONObject = a.getJSONObject("status");
            C0621a<C0701a> c0621a = new C0621a();
            c0621a.f2058a = new C0701a();
            c0621a.b = jSONObject.getInt(Mipay.KEY_CODE);
            c0621a.c = jSONObject.optString("msg", "");
            if (c0621a.b != 0) {
                return c0621a;
            }
            ((C0701a) c0621a.f2058a).f2398a = a.getString("token");
            return c0621a;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public C0627d mo376a(C0624a c0624a) {
        c0624a.m2835a("accept", "application/json");
        return super.mo376a(c0624a);
    }
}
