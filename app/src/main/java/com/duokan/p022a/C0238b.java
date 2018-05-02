package com.duokan.p022a;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.domain.account.C0672a;
import org.json.JSONObject;

/* renamed from: com.duokan.a.b */
class C0238b extends ac {
    /* renamed from: a */
    final /* synthetic */ C0236a f380a;

    public C0238b(C0236a c0236a, WebSession webSession, C0672a c0672a) {
        this.f380a = c0236a;
        super(webSession, c0672a);
    }

    /* renamed from: a */
    public JSONObject m566a() {
        String str = "https://www.duokan.com/store/v0/payment/book/list";
        return m547a(mo376a(m562b(true, "https://www.duokan.com/store/v0/payment/book/list", "t", Long.toString(System.currentTimeMillis() / 1000))));
    }
}
