package com.duokan.reader.ui.general.web;

import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.i;

import org.json.JSONArray;

import java.util.concurrent.Callable;

class cr implements Callable {
    final /* synthetic */ cg a;

    cr(cg cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        JSONArray jSONArray = new JSONArray();
        if (!i.f().a().equals(AccountType.XIAOMI_GUEST)) {
            jSONArray.put("MIPAY");
        }
        jSONArray.put("ALIPAY_MOBILE");
        if (DkApp.get().supportWxPay()) {
            jSONArray.put("WXPAY");
        }
        return jSONArray.toString();
    }
}
