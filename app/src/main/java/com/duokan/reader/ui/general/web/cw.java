package com.duokan.reader.ui.general.web;

import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import java.util.concurrent.Callable;
import org.json.JSONArray;

class cw implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ ci f7708a;

    cw(ci ciVar) {
        this.f7708a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11071a();
    }

    /* renamed from: a */
    public String m11071a() {
        JSONArray jSONArray = new JSONArray();
        if (!C0709k.m3476a().m3501b().equals(AccountType.XIAOMI_GUEST)) {
            jSONArray.put("MIPAY");
        }
        jSONArray.put("ALIPAY_MOBILE");
        if (DkApp.get().supportWxPay()) {
            jSONArray.put("WXPAY");
        }
        return jSONArray.toString();
    }
}
