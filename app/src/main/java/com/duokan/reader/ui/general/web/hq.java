package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;

import org.json.JSONArray;

import java.util.concurrent.Callable;

class hq implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    hq(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray(this.a);
        for (int i = 0; i < jSONArray2.length(); i++) {
            String optString = jSONArray2.optString(i);
            if (DkUserPurchasedBooksManager.a().b(optString) != null) {
                jSONArray.put(optString);
            } else if (DkUserPurchasedFictionsManager.a().b(optString) != null) {
                jSONArray.put(optString);
            }
        }
        return jSONArray.toString();
    }
}
