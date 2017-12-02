package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class bt {
    public String a;
    private HashMap b;
    private HashMap c;

    public bt() {
        this.a = "";
        this.b = new HashMap();
        this.c = new HashMap();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof bt)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        bt btVar = (bt) obj;
        if (!TextUtils.equals(this.a, btVar.a)) {
            return false;
        }
        if (this.c.size() != btVar.c.size()) {
            return false;
        }
        for (Integer intValue : this.c.keySet()) {
            int intValue2 = intValue.intValue();
            if (!btVar.c.containsKey(Integer.valueOf(intValue2))) {
                return false;
            }
            if (this.c.get(Integer.valueOf(intValue2)) != btVar.c.get(Integer.valueOf(intValue2))) {
                return false;
            }
        }
        if (this.b.size() != btVar.b.size()) {
            return false;
        }
        for (Integer intValue3 : this.b.keySet()) {
            intValue2 = intValue3.intValue();
            if (!btVar.b.containsKey(Integer.valueOf(intValue2))) {
                return false;
            }
            if (this.b.get(Integer.valueOf(intValue2)) != btVar.b.get(Integer.valueOf(intValue2))) {
                return false;
            }
        }
        return true;
    }

    public boolean a() {
        return this.b.isEmpty() && this.c.isEmpty();
    }

    public long a(int i) {
        if (this.b.containsKey(Integer.valueOf(i))) {
            return ((Long) this.b.get(Integer.valueOf(i))).longValue();
        }
        return 0;
    }

    public void a(int i, long j) {
        this.b.put(Integer.valueOf(i), Long.valueOf(j));
    }

    public long b(int i) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            return ((Long) this.c.get(Integer.valueOf(i))).longValue();
        }
        return 0;
    }

    public void b(int i, long j) {
        this.c.put(Integer.valueOf(i), Long.valueOf(j));
    }

    public bt(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            this.a = "";
            this.b = new HashMap();
            this.c = new HashMap();
            return;
        }
        this.a = jSONObject.optString("account_uuid");
        this.b = new HashMap();
        JSONArray optJSONArray = jSONObject.optJSONArray("latest_modified_times");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    this.b.put(Integer.valueOf(jSONObject2.getInt("book_source")), Long.valueOf(jSONObject2.getLong("latest_modified_time")));
                } catch (JSONException e) {
                }
            }
        }
        this.c = new HashMap();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("versions");
        if (optJSONArray2 != null) {
            while (i < optJSONArray2.length()) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i);
                    this.c.put(Integer.valueOf(jSONObject3.getInt("book_source")), Long.valueOf(jSONObject3.getLong(ClientCookie.VERSION_ATTR)));
                } catch (JSONException e2) {
                }
                i++;
            }
        }
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            int intValue;
            JSONObject jSONObject2;
            jSONObject.put("account_uuid", this.a);
            JSONArray jSONArray = new JSONArray();
            for (Integer intValue2 : this.b.keySet()) {
                intValue = intValue2.intValue();
                jSONObject2 = new JSONObject();
                jSONObject2.put("book_source", intValue);
                jSONObject2.put("latest_modified_time", this.b.get(Integer.valueOf(intValue)));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("latest_modified_times", jSONArray);
            jSONArray = new JSONArray();
            for (Integer intValue22 : this.c.keySet()) {
                intValue = intValue22.intValue();
                jSONObject2 = new JSONObject();
                jSONObject2.put("book_source", intValue);
                jSONObject2.put(ClientCookie.VERSION_ATTR, this.c.get(Integer.valueOf(intValue)));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("versions", jSONArray);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
