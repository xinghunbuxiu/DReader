package com.duokan.reader.domain.social.message;

import org.json.JSONObject;

public class g implements m {
    private static final g a = new g();

    public static g a() {
        return a;
    }

    public l a(int i, JSONObject jSONObject) {
        switch (i) {
            case 5:
                return d.a(jSONObject);
            case 6:
                return f.a(jSONObject);
            case 10:
                return e.a(jSONObject);
            case 11:
                return ba.a(jSONObject);
            case 13:
                return new n();
            case 14:
                return new i(jSONObject);
            case 15:
                return new j(jSONObject);
            case 17:
                return b.a(jSONObject);
            case 18:
                return c.a(jSONObject);
            case 19:
                return a.a(jSONObject);
            default:
                return new n();
        }
    }
}
