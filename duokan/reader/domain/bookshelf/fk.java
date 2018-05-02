package com.duokan.reader.domain.bookshelf;

import org.json.JSONObject;

class fk implements fm {
    final /* synthetic */ fj a;

    fk(fj fjVar) {
        this.a = fjVar;
    }

    public JSONObject a(bu buVar) {
        if (buVar.h != 3) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("book_id", buVar.b);
        jSONObject.put("client_change_time", buVar.i);
        return jSONObject;
    }
}
