package com.duokan.reader.common.webservices;

import org.json.JSONObject;

public abstract class m {
    private final boolean a;

    public abstract Object b(JSONObject jSONObject, int i, JSONObject jSONObject2);

    public m(boolean z) {
        this.a = z;
    }

    public final boolean a() {
        return this.a;
    }
}
