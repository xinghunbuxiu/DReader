package com.duokan.reader.ui.account.p050a;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.cm;
import com.mipay.sdk.Mipay;
import org.apache.http.cookie.SM;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.ui.account.a.g */
class C1242g extends ac {
    public C1242g(WebSession webSession) {
        super(webSession, (C0672a) null);
    }

    /* renamed from: a */
    public C1243h m8834a() {
        boolean z = true;
        JSONObject a = m547a(mo376a(m555a(true, C0641o.m2934i().m2990q() + "/anonymous/status", new String[0])));
        if (a.getInt(Mipay.KEY_RESULT) != 0) {
            return null;
        }
        int i = a.getInt("status");
        if (a.optInt("silence", 1) != 1) {
            z = false;
        }
        return new C1243h(i, z);
    }

    /* renamed from: b */
    public boolean m8836b() {
        if (m547a(mo376a(m555a(true, C0641o.m2934i().m2990q() + "/anonymous/migrate", new String[0]))).getInt(Mipay.KEY_RESULT) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    protected void mo1566b(C0624a c0624a) {
        cm g = C0709k.m3476a().m3512g();
        if (g != null) {
            m560a(c0624a, SM.COOKIE, m557a(g.m3450e()));
        }
    }
}
