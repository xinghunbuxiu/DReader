package com.duokan.reader.domain.document;

import android.graphics.Rect;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map.Entry;

public class k {
    static final /* synthetic */ boolean k = (!k.class.desiredAssertionStatus());
    public int a;
    public int b;
    public Rect c;
    public Rect d;
    public boolean e;
    public int f;
    public double g;
    public double h;
    public double i;
    public final HashMap j;

    public k() {
        this.a = -1;
        this.b = -1;
        this.c = new Rect(0, 0, 0, 0);
        this.d = new Rect(0, 0, 0, 0);
        this.e = false;
        this.f = 0;
        this.g = 0.0d;
        this.h = 0.0d;
        this.i = 0.0d;
        this.j = new HashMap();
    }

    public k(JSONObject jSONObject) {
        int i = 0;
        this.a = -1;
        this.b = -1;
        this.c = new Rect(0, 0, 0, 0);
        this.d = new Rect(0, 0, 0, 0);
        this.e = false;
        this.f = 0;
        this.g = 0.0d;
        this.h = 0.0d;
        this.i = 0.0d;
        if (k || jSONObject != null) {
            this.a = jSONObject.getInt("page_width");
            this.b = jSONObject.getInt("page_height");
            this.e = jSONObject.optBoolean("bleed_enabled", false);
            this.f = jSONObject.getInt("font_size");
            this.g = jSONObject.getDouble("line_gap");
            this.h = jSONObject.getDouble("para_spacing");
            this.i = jSONObject.getDouble("first_line_indent");
            JSONArray jSONArray = jSONObject.getJSONArray("page_outer_padding");
            this.c = new Rect(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
            jSONArray = jSONObject.getJSONArray("page_inner_padding");
            this.d = new Rect(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
            jSONArray = jSONObject.getJSONArray("font_map");
            this.j = new HashMap();
            while (i < jSONArray.length()) {
                this.j.put(jSONArray.getString(i), jSONArray.getString(i + 1));
                i += 2;
            }
            return;
        }
        throw new AssertionError();
    }

    public k(k kVar) {
        this.a = -1;
        this.b = -1;
        this.c = new Rect(0, 0, 0, 0);
        this.d = new Rect(0, 0, 0, 0);
        this.e = false;
        this.f = 0;
        this.g = 0.0d;
        this.h = 0.0d;
        this.i = 0.0d;
        this.a = kVar.a;
        this.b = kVar.b;
        this.c = kVar.c;
        this.d = kVar.d;
        this.e = kVar.e;
        this.f = kVar.f;
        this.g = kVar.g;
        this.h = kVar.h;
        this.i = kVar.i;
        this.j = new HashMap(kVar.j);
    }

    public Rect a() {
        return new Rect(this.d.left, this.c.top + this.d.top, this.d.right, this.c.bottom + this.d.bottom);
    }

    public Rect b() {
        Rect a = a();
        return new Rect(a.left, a.top, this.a - a.right, this.b - a.bottom);
    }

    public boolean c() {
        return false;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page_width", this.a);
            jSONObject.put("page_height", this.b);
            jSONObject.put("bleed_enabled", this.e);
            jSONObject.put("font_size", this.f);
            jSONObject.put("line_gap", this.g);
            jSONObject.put("para_spacing", this.h);
            jSONObject.put("first_line_indent", this.i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, this.c.left);
            jSONArray.put(1, this.c.top);
            jSONArray.put(2, this.c.right);
            jSONArray.put(3, this.c.bottom);
            jSONObject.put("page_outer_padding", jSONArray);
            jSONArray = new JSONArray();
            jSONArray.put(0, this.d.left);
            jSONArray.put(1, this.d.top);
            jSONArray.put(2, this.d.right);
            jSONArray.put(3, this.d.bottom);
            jSONObject.put("page_inner_padding", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (Entry entry : this.j.entrySet()) {
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
        k kVar = (k) obj;
        if (this.a != kVar.a || this.b != kVar.b) {
            return false;
        }
        if (this.e != kVar.e) {
            return false;
        }
        if (this.c.left != kVar.c.left || this.c.top != kVar.c.top || this.c.right != kVar.c.right || this.c.bottom != kVar.c.bottom) {
            return false;
        }
        if (this.d.left != kVar.d.left || this.d.top != kVar.d.top || this.d.right != kVar.d.right || this.d.bottom != kVar.d.bottom) {
            return false;
        }
        if (this.f != kVar.f) {
            return false;
        }
        if (Double.compare(this.g, kVar.g) != 0) {
            return false;
        }
        if (Double.compare(this.h, kVar.h) != 0) {
            return false;
        }
        if (Double.compare(this.i, kVar.i) != 0) {
            return false;
        }
        if (this.j.size() != kVar.j.size()) {
            return false;
        }
        for (Entry entry : this.j.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            str = (String) kVar.j.get(str);
            if (str != null) {
                if (!str.equals(str2)) {
                }
            }
            return false;
        }
        return true;
    }

    public String toString() {
        return d().toString();
    }
}
