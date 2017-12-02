package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.mipay.sdk.Mipay;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.concurrent.Callable;

class iu implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    iu(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        if (i.f().a(PersonalAccount.class)) {
            DkCloudPurchasedFiction b = DkUserPurchasedFictionsManager.a().b(this.a);
            jSONObject.put(Mipay.KEY_CODE, 0);
            if (b != null) {
                jSONObject.put("entire", b.isEntirePaid());
                jSONObject.put("paid", new JSONArray(Arrays.asList(b.getPaidChaptersId())));
            }
        } else {
            jSONObject.put(Mipay.KEY_CODE, 3);
        }
        return jSONObject.toString();
    }
}
