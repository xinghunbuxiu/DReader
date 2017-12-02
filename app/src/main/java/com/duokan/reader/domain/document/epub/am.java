package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.k;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map.Entry;

public class am extends k {
    public final HashMap l;

    public am() {
        this.l = new HashMap();
    }

    public am(JSONObject jSONObject) {
        super(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("stuffings_map");
        this.l = new HashMap();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i += 2) {
                this.l.put(Long.valueOf(optJSONArray.getLong(i)), Integer.valueOf(optJSONArray.getInt(i + 1)));
            }
        }
    }

    public am(am amVar) {
        super((k) amVar);
        this.l = new HashMap(amVar.l);
    }

    public static am a(String str) {
        try {
            return new am(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        am amVar = (am) obj;
        if (this.l.size() != amVar.l.size()) {
            return false;
        }
        for (Entry entry : this.l.entrySet()) {
            long longValue = ((Long) entry.getKey()).longValue();
            int intValue = ((Integer) entry.getValue()).intValue();
            Integer num = (Integer) amVar.l.get(Long.valueOf(longValue));
            if (num != null) {
                if (num.intValue() != intValue) {
                }
            }
            return false;
        }
        return true;
    }

    public JSONObject d() {
        JSONObject d = super.d();
        try {
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.l.entrySet()) {
                jSONArray.put(entry.getKey());
                jSONArray.put(entry.getValue());
            }
            d.put("stuffings_map", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
}
