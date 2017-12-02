package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.k;

import org.json.JSONObject;

public class ad extends k {
    public ad(JSONObject jSONObject) {
        super(jSONObject);
    }

    public ad(ad adVar) {
        super((k) adVar);
    }

    public static ad a(String str) {
        try {
            return new ad(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
