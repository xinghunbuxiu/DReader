package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import org.json.JSONArray;
import org.json.JSONObject;

class gr implements as {
    /* renamed from: a */
    final /* synthetic */ String f7897a;
    /* renamed from: b */
    final /* synthetic */ ci f7898b;

    gr(ci ciVar, String str) {
        this.f7898b = ciVar;
        this.f7897a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7897a);
        JSONObject jSONObject2 = jSONObject.getJSONObject("detail");
        String string = jSONObject.getString("bookUuid");
        String optString = jSONObject.optString("trace_id");
        JSONArray jSONArray = jSONObject.getJSONArray("chapters");
        if (jSONArray.length() >= 1) {
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            C0800c b = ai.m3980a().m3906b(string);
            if (b == null) {
                b = ai.m3980a().m3875a(new DkStoreFictionDetail(jSONObject2));
                b.m4235j(optString);
            }
            C0800c c0800c = b;
            if (c0800c instanceof ee) {
                String str = "dkcloud:///fiction/" + string + "#" + C0652z.m3048a((String[]) arrayList.toArray(new String[0]));
                Semaphore semaphore = new Semaphore(1);
                semaphore.acquire();
                this.f7898b.m11016a(new gs(this, c0800c, str, semaphore));
                semaphore.acquire();
            }
        }
    }
}
