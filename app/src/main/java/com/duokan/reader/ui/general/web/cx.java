package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0709k;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;

class cx implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ ci f7709a;

    cx(ci ciVar) {
        this.f7709a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11072a();
    }

    /* renamed from: a */
    public String m11072a() {
        JSONArray jSONArray = new JSONArray();
        List e = C0709k.m3476a().m3510e();
        for (int i = 0; i < e.size(); i++) {
            jSONArray.put((String) e.get(i));
        }
        return jSONArray.toString();
    }
}
