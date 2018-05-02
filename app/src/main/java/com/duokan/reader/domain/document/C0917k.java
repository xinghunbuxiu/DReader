package com.duokan.reader.domain.document;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.document.k */
public class C0917k {
    /* renamed from: k */
    static final /* synthetic */ boolean f4329k = (!C0917k.class.desiredAssertionStatus());
    /* renamed from: a */
    public int f4330a;
    /* renamed from: b */
    public int f4331b;
    /* renamed from: c */
    public Rect f4332c;
    /* renamed from: d */
    public Rect f4333d;
    /* renamed from: e */
    public boolean f4334e;
    /* renamed from: f */
    public int f4335f;
    /* renamed from: g */
    public double f4336g;
    /* renamed from: h */
    public double f4337h;
    /* renamed from: i */
    public double f4338i;
    /* renamed from: j */
    public final HashMap<String, String> f4339j;

    public C0917k() {
        this.f4330a = -1;
        this.f4331b = -1;
        this.f4332c = new Rect(0, 0, 0, 0);
        this.f4333d = new Rect(0, 0, 0, 0);
        this.f4334e = false;
        this.f4335f = 0;
        this.f4336g = 0.0d;
        this.f4337h = 0.0d;
        this.f4338i = 0.0d;
        this.f4339j = new HashMap();
    }

    public C0917k(JSONObject jSONObject) {
        int i = 0;
        this.f4330a = -1;
        this.f4331b = -1;
        this.f4332c = new Rect(0, 0, 0, 0);
        this.f4333d = new Rect(0, 0, 0, 0);
        this.f4334e = false;
        this.f4335f = 0;
        this.f4336g = 0.0d;
        this.f4337h = 0.0d;
        this.f4338i = 0.0d;
        if (f4329k || jSONObject != null) {
            this.f4330a = jSONObject.getInt("page_width");
            this.f4331b = jSONObject.getInt("page_height");
            this.f4334e = jSONObject.optBoolean("bleed_enabled", false);
            this.f4335f = jSONObject.getInt("font_size");
            this.f4336g = jSONObject.getDouble("line_gap");
            this.f4337h = jSONObject.getDouble("para_spacing");
            this.f4338i = jSONObject.getDouble("first_line_indent");
            JSONArray jSONArray = jSONObject.getJSONArray("page_outer_padding");
            this.f4332c = new Rect(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
            jSONArray = jSONObject.getJSONArray("page_inner_padding");
            this.f4333d = new Rect(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
            jSONArray = jSONObject.getJSONArray("font_map");
            this.f4339j = new HashMap();
            while (i < jSONArray.length()) {
                this.f4339j.put(jSONArray.getString(i), jSONArray.getString(i + 1));
                i += 2;
            }
            return;
        }
        throw new AssertionError();
    }

    public C0917k(C0917k c0917k) {
        this.f4330a = -1;
        this.f4331b = -1;
        this.f4332c = new Rect(0, 0, 0, 0);
        this.f4333d = new Rect(0, 0, 0, 0);
        this.f4334e = false;
        this.f4335f = 0;
        this.f4336g = 0.0d;
        this.f4337h = 0.0d;
        this.f4338i = 0.0d;
        this.f4330a = c0917k.f4330a;
        this.f4331b = c0917k.f4331b;
        this.f4332c = c0917k.f4332c;
        this.f4333d = c0917k.f4333d;
        this.f4334e = c0917k.f4334e;
        this.f4335f = c0917k.f4335f;
        this.f4336g = c0917k.f4336g;
        this.f4337h = c0917k.f4337h;
        this.f4338i = c0917k.f4338i;
        this.f4339j = new HashMap(c0917k.f4339j);
    }

    /* renamed from: a */
    public Rect m6083a() {
        return new Rect(this.f4333d.left, this.f4332c.top + this.f4333d.top, this.f4333d.right, this.f4332c.bottom + this.f4333d.bottom);
    }

    /* renamed from: b */
    public Rect m6084b() {
        Rect a = m6083a();
        return new Rect(a.left, a.top, this.f4330a - a.right, this.f4331b - a.bottom);
    }

    /* renamed from: c */
    public boolean mo1274c() {
        return false;
    }

    /* renamed from: d */
    public JSONObject mo1275d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page_width", this.f4330a);
            jSONObject.put("page_height", this.f4331b);
            jSONObject.put("bleed_enabled", this.f4334e);
            jSONObject.put("font_size", this.f4335f);
            jSONObject.put("line_gap", this.f4336g);
            jSONObject.put("para_spacing", this.f4337h);
            jSONObject.put("first_line_indent", this.f4338i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, this.f4332c.left);
            jSONArray.put(1, this.f4332c.top);
            jSONArray.put(2, this.f4332c.right);
            jSONArray.put(3, this.f4332c.bottom);
            jSONObject.put("page_outer_padding", jSONArray);
            jSONArray = new JSONArray();
            jSONArray.put(0, this.f4333d.left);
            jSONArray.put(1, this.f4333d.top);
            jSONArray.put(2, this.f4333d.right);
            jSONArray.put(3, this.f4333d.bottom);
            jSONObject.put("page_inner_padding", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Entry entry : this.f4339j.entrySet()) {
                jSONArray2.put(entry.getKey());
                jSONArray2.put(entry.getValue());
            }
            jSONObject.put("font_map", jSONArray2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0917k c0917k = (C0917k) obj;
        if (this.f4330a != c0917k.f4330a || this.f4331b != c0917k.f4331b) {
            return false;
        }
        if (this.f4334e != c0917k.f4334e) {
            return false;
        }
        if (this.f4332c.left != c0917k.f4332c.left || this.f4332c.top != c0917k.f4332c.top || this.f4332c.right != c0917k.f4332c.right || this.f4332c.bottom != c0917k.f4332c.bottom) {
            return false;
        }
        if (this.f4333d.left != c0917k.f4333d.left || this.f4333d.top != c0917k.f4333d.top || this.f4333d.right != c0917k.f4333d.right || this.f4333d.bottom != c0917k.f4333d.bottom) {
            return false;
        }
        if (this.f4335f != c0917k.f4335f) {
            return false;
        }
        if (Double.compare(this.f4336g, c0917k.f4336g) != 0) {
            return false;
        }
        if (Double.compare(this.f4337h, c0917k.f4337h) != 0) {
            return false;
        }
        if (Double.compare(this.f4338i, c0917k.f4338i) != 0) {
            return false;
        }
        if (this.f4339j.size() != c0917k.f4339j.size()) {
            return false;
        }
        for (Entry entry : this.f4339j.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            str = (String) c0917k.f4339j.get(str);
            if (str != null) {
                if (!str.equals(str2)) {
                }
            }
            return false;
        }
        return true;
    }

    public String toString() {
        return mo1275d().toString();
    }
}
