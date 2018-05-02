package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class gg implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    gg(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        JSONObject jSONObject2 = jSONObject.getJSONObject("detail");
        String string = jSONObject.getString("bookUuid");
        String optString = jSONObject.optString("trace_id");
        JSONArray jSONArray = jSONObject.getJSONArray("chapters");
        if (jSONArray.length() >= 1) {
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            c b = ai.a().b(string);
            if (b == null) {
                b = ai.a().a(new DkStoreFictionDetail(jSONObject2));
                b.j(optString);
            }
            c cVar = b;
            if (cVar instanceof ej) {
                String str = "dkcloud:///fiction/" + string + "#" + aa.a((String[]) arrayList.toArray(new String[0]));
                Semaphore semaphore = new Semaphore(1);
                semaphore.acquire();
                this.b.a(new gh(this, cVar, str, semaphore));
                semaphore.acquire();
            }
        }
    }
}
