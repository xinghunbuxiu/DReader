package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import java.util.HashMap;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bs {
    /* renamed from: a */
    public String f2854a;
    /* renamed from: b */
    private HashMap<Integer, Long> f2855b;
    /* renamed from: c */
    private HashMap<Integer, Long> f2856c;

    public bs() {
        this.f2854a = "";
        this.f2855b = new HashMap();
        this.f2856c = new HashMap();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof bs)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        bs bsVar = (bs) obj;
        if (!TextUtils.equals(this.f2854a, bsVar.f2854a)) {
            return false;
        }
        if (this.f2856c.size() != bsVar.f2856c.size()) {
            return false;
        }
        for (Integer intValue : this.f2856c.keySet()) {
            int intValue2 = intValue.intValue();
            if (!bsVar.f2856c.containsKey(Integer.valueOf(intValue2))) {
                return false;
            }
            if (this.f2856c.get(Integer.valueOf(intValue2)) != bsVar.f2856c.get(Integer.valueOf(intValue2))) {
                return false;
            }
        }
        if (this.f2855b.size() != bsVar.f2855b.size()) {
            return false;
        }
        for (Integer intValue3 : this.f2855b.keySet()) {
            intValue2 = intValue3.intValue();
            if (!bsVar.f2855b.containsKey(Integer.valueOf(intValue2))) {
                return false;
            }
            if (this.f2855b.get(Integer.valueOf(intValue2)) != bsVar.f2855b.get(Integer.valueOf(intValue2))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m4062a() {
        return this.f2855b.isEmpty() && this.f2856c.isEmpty();
    }

    /* renamed from: a */
    public long m4060a(int i) {
        if (this.f2855b.containsKey(Integer.valueOf(i))) {
            return ((Long) this.f2855b.get(Integer.valueOf(i))).longValue();
        }
        return 0;
    }

    /* renamed from: a */
    public void m4061a(int i, long j) {
        this.f2855b.put(Integer.valueOf(i), Long.valueOf(j));
    }

    /* renamed from: b */
    public long m4063b(int i) {
        if (this.f2856c.containsKey(Integer.valueOf(i))) {
            return ((Long) this.f2856c.get(Integer.valueOf(i))).longValue();
        }
        return 0;
    }

    /* renamed from: b */
    public void m4065b(int i, long j) {
        this.f2856c.put(Integer.valueOf(i), Long.valueOf(j));
    }

    public bs(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            this.f2854a = "";
            this.f2855b = new HashMap();
            this.f2856c = new HashMap();
            return;
        }
        this.f2854a = jSONObject.optString("account_uuid");
        this.f2855b = new HashMap();
        JSONArray optJSONArray = jSONObject.optJSONArray("latest_modified_times");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    this.f2855b.put(Integer.valueOf(jSONObject2.getInt("book_source")), Long.valueOf(jSONObject2.getLong("latest_modified_time")));
                } catch (JSONException e) {
                }
            }
        }
        this.f2856c = new HashMap();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("versions");
        if (optJSONArray2 != null) {
            while (i < optJSONArray2.length()) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i);
                    this.f2856c.put(Integer.valueOf(jSONObject3.getInt("book_source")), Long.valueOf(jSONObject3.getLong(ClientCookie.VERSION_ATTR)));
                } catch (JSONException e2) {
                }
                i++;
            }
        }
    }

    /* renamed from: b */
    public JSONObject m4064b() {
        JSONObject jSONObject = new JSONObject();
        try {
            int intValue;
            JSONObject jSONObject2;
            jSONObject.put("account_uuid", this.f2854a);
            JSONArray jSONArray = new JSONArray();
            for (Integer intValue2 : this.f2855b.keySet()) {
                intValue = intValue2.intValue();
                jSONObject2 = new JSONObject();
                jSONObject2.put("book_source", intValue);
                jSONObject2.put("latest_modified_time", this.f2855b.get(Integer.valueOf(intValue)));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("latest_modified_times", jSONArray);
            jSONArray = new JSONArray();
            for (Integer intValue22 : this.f2856c.keySet()) {
                intValue = intValue22.intValue();
                jSONObject2 = new JSONObject();
                jSONObject2.put("book_source", intValue);
                jSONObject2.put(ClientCookie.VERSION_ATTR, this.f2856c.get(Integer.valueOf(intValue)));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("versions", jSONArray);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
