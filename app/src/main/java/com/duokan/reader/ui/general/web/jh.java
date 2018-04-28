package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.mipay.sdk.Mipay;
import java.util.Arrays;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

class jh implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ String f8045a;
    /* renamed from: b */
    final /* synthetic */ ci f8046b;

    jh(ci ciVar, String str) {
        this.f8046b = ciVar;
        this.f8045a = str;
    }

    public /* synthetic */ Object call() {
        return m11217a();
    }

    /* renamed from: a */
    public String m11217a() {
        JSONObject jSONObject = new JSONObject();
        if (C0709k.m3476a().m3500a(PersonalAccount.class)) {
            DkCloudPurchasedFiction b = DkUserPurchasedFictionsManager.m5072a().m5101b(this.f8045a);
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
