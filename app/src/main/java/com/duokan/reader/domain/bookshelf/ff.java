package com.duokan.reader.domain.bookshelf;

import org.json.JSONObject;

class ff implements fg {
    /* renamed from: a */
    final /* synthetic */ fd f3162a;

    ff(fd fdVar) {
        this.f3162a = fdVar;
    }

    /* renamed from: a */
    public JSONObject mo1025a(bt btVar) {
        if (btVar.f2864h != 1 && btVar.f2864h != 2) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("book_id", btVar.f2858b);
        jSONObject.put("client_change_time", btVar.f2865i);
        jSONObject.put("group", btVar.f2859c);
        return jSONObject;
    }
}
