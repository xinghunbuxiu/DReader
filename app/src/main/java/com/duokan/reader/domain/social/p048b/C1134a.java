package com.duokan.reader.domain.social.p048b;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.domain.account.C0672a;
import com.mipay.sdk.Mipay;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.b.a */
public class C1134a extends ac {
    public C1134a(WebSession webSession, C0672a c0672a) {
        super(webSession, c0672a);
    }

    /* renamed from: e */
    public C0621a<Void> m8456e(String str) {
        JSONObject a = m547a(mo376a(m555a(m8455a(), C0641o.m2934i().m2991r() + "/account/user_desc", "description", str)));
        C0621a<Void> c0621a = new C0621a();
        a = a.getJSONObject("status");
        c0621a.b = Integer.parseInt(a.getString(Mipay.KEY_CODE));
        if (c0621a.b != 0) {
            if (c0621a.b == 1) {
                c0621a.b = ICallback.CLEAR_ACCOUNT_AIDL;
            }
            c0621a.c = a.optString("msg");
        }
        return c0621a;
    }

    /* renamed from: f */
    public C0621a<C1136c> m8457f(String str) {
        C0621a<C1136c> c0621a = new C0621a();
        if (DkPublic.isXiaomiId(str)) {
            JSONObject a = m547a(mo376a(m562b(m8455a(), C0641o.m2934i().m2991r() + "/account/user_desc", new String[0])));
            c0621a.b = a.getJSONObject("status").getInt(Mipay.KEY_CODE);
            c0621a.c = "";
            if (c0621a.b == 0) {
                c0621a.f2058a = new C1136c(str, a);
            }
        } else {
            c0621a.b = 0;
            c0621a.f2058a = new C1136c(str);
        }
        return c0621a;
    }

    /* renamed from: g */
    public C0621a<String> m8458g(String str) {
        C0621a<String> c0621a = new C0621a();
        JSONObject a = m547a(mo376a(m562b(m8455a(), C0641o.m2934i().m2991r() + "/account/openid", "app", str)));
        c0621a.b = a.getJSONObject("status").getInt(Mipay.KEY_CODE);
        c0621a.c = "";
        if (c0621a.b == 0) {
            c0621a.f2058a = a.getString("open_id");
        }
        return c0621a;
    }

    /* renamed from: a */
    private boolean m8455a() {
        return true;
    }
}
