package com.duokan.reader.domain.bookshelf;

import org.json.JSONObject;

class fe implements fg {
    /* renamed from: a */
    final /* synthetic */ fd f3161a;

    fe(fd fdVar) {
        this.f3161a = fdVar;
    }

    /* renamed from: a */
    public JSONObject mo1025a(bt btVar) {
        if (btVar.f2864h != 3) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("book_id", btVar.f2858b);
        jSONObject.put("client_change_time", btVar.f2865i);
        return jSONObject;
    }
}
