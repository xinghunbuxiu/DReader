package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.C0917k;
import org.json.JSONObject;

public class ad extends C0917k {
    public ad(JSONObject jSONObject) {
        super(jSONObject);
    }

    public ad(ad adVar) {
        super((C0917k) adVar);
    }

    /* renamed from: a */
    public static ad m7383a(String str) {
        try {
            return new ad(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
