package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import java.util.concurrent.Callable;
import org.json.JSONArray;

class hy implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ String f7958a;
    /* renamed from: b */
    final /* synthetic */ ci f7959b;

    hy(ci ciVar, String str) {
        this.f7959b = ciVar;
        this.f7958a = str;
    }

    public /* synthetic */ Object call() {
        return m11184a();
    }

    /* renamed from: a */
    public String m11184a() {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray(this.f7958a);
        for (int i = 0; i < jSONArray2.length(); i++) {
            String optString = jSONArray2.optString(i);
            if (DkUserPurchasedBooksManager.m5029a().m5052a(optString) != null) {
                jSONArray.put(optString);
            } else if (DkUserPurchasedFictionsManager.m5072a().m5093a(optString) != null) {
                jSONArray.put(optString);
            }
        }
        return jSONArray.toString();
    }
}
