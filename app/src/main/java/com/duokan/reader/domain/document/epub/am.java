package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.C0917k;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class am extends C0917k {
    /* renamed from: l */
    public final HashMap<Long, Integer> f4487l;

    public am() {
        this.f4487l = new HashMap();
    }

    public am(JSONObject jSONObject) {
        super(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("stuffings_map");
        this.f4487l = new HashMap();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i += 2) {
                this.f4487l.put(Long.valueOf(optJSONArray.getLong(i)), Integer.valueOf(optJSONArray.getInt(i + 1)));
            }
        }
    }

    public am(am amVar) {
        super((C0917k) amVar);
        this.f4487l = new HashMap(amVar.f4487l);
    }

    /* renamed from: a */
    public static am m6519a(String str) {
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
        if (this.f4487l.size() != amVar.f4487l.size()) {
            return false;
        }
        for (Entry entry : this.f4487l.entrySet()) {
            long longValue = ((Long) entry.getKey()).longValue();
            int intValue = ((Integer) entry.getValue()).intValue();
            Integer num = (Integer) amVar.f4487l.get(Long.valueOf(longValue));
            if (num != null) {
                if (num.intValue() != intValue) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public JSONObject mo1275d() {
        JSONObject d = super.mo1275d();
        try {
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f4487l.entrySet()) {
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
