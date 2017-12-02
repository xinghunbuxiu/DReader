package com.duokan.reader.domain.social.b;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.common.webservices.duokan.p;
import com.mipay.sdk.Mipay;

import org.json.JSONObject;

public class a extends ad {
    public a(WebSession webSession, com.duokan.reader.domain.account.a aVar) {
        super(webSession, aVar);
    }

    public b e(String str) {
        JSONObject a = a(a(a(a(), p.i().r() + "/account/user_desc", "description", str)));
        b bVar = new b();
        a = a.getJSONObject("status");
        bVar.b = Integer.parseInt(a.getString(Mipay.KEY_CODE));
        if (bVar.b != 0) {
            if (bVar.b == 1) {
                bVar.b = 1003;
            }
            bVar.c = a.optString("msg");
        }
        return bVar;
    }

    public b f(String str) {
        b bVar = new b();
        if (DkPublic.isXiaomiId(str)) {
            JSONObject a = a(a(b(a(), p.i().r() + "/account/user_desc", new String[0])));
            bVar.b = a.getJSONObject("status").getInt(Mipay.KEY_CODE);
            bVar.c = "";
            if (bVar.b == 0) {
                bVar.a = new c(str, a);
            }
        } else {
            bVar.b = 0;
            bVar.a = new c(str);
        }
        return bVar;
    }

    private boolean a() {
        return true;
    }
}
