package com.duokan.reader.domain.bookshelf;

import org.json.JSONObject;

class fl implements fm {
    final /* synthetic */ fj a;

    fl(fj fjVar) {
        this.a = fjVar;
    }

    public JSONObject a(bu buVar) {
        if (buVar.h != 1 && buVar.h != 2) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("book_id", buVar.b);
        jSONObject.put("client_change_time", buVar.i);
        jSONObject.put("group", buVar.c);
        return jSONObject;
    }
}
