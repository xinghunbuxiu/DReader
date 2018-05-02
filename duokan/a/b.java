package com.duokan.a;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.domain.account.a;

import org.json.JSONObject;

class b extends ad {
    final /* synthetic */ a a;

    public b(a aVar, WebSession webSession, a aVar2) {
        this.a = aVar;
        super(webSession, aVar2);
    }

    public JSONObject a() {
        String str = "https://www.duokan.com/store/v0/payment/book/list";
        return a(a(b(true, "https://www.duokan.com/store/v0/payment/book/list", "TaskHandler", Long.toString(System.currentTimeMillis() / 1000))));
    }
}
