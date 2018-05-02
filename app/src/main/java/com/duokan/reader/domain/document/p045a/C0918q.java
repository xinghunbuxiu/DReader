package com.duokan.reader.domain.document.p045a;

import android.graphics.RectF;
import com.duokan.reader.domain.document.C0917k;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.document.a.q */
public class C0918q extends C0917k {
    /* renamed from: l */
    public float f4340l;
    /* renamed from: m */
    public RectF[] f4341m;

    public C0918q() {
        this.f4340l = 1.0f;
        this.f4341m = new RectF[0];
    }

    public C0918q(JSONObject jSONObject) {
        int i = 0;
        super(jSONObject);
        this.f4340l = 1.0f;
        this.f4341m = new RectF[0];
        this.f4340l = (float) jSONObject.getDouble("font_scale");
        JSONArray jSONArray = jSONObject.getJSONArray("content_margins");
        this.f4341m = new RectF[(jSONArray.length() / 4)];
        while (i < this.f4341m.length) {
            this.f4341m[i] = new RectF((float) jSONArray.getDouble((i * 4) + 0), (float) jSONArray.getDouble((i * 4) + 1), (float) jSONArray.getDouble((i * 4) + 2), (float) jSONArray.getDouble((i * 4) + 3));
            i++;
        }
    }

    public C0918q(C0918q c0918q) {
        super((C0917k) c0918q);
        this.f4340l = 1.0f;
        this.f4341m = new RectF[0];
        this.f4340l = c0918q.f4340l;
        this.f4341m = c0918q.f4341m;
    }

    /* renamed from: c */
    public boolean mo1274c() {
        return this.a < 0 && this.b < 0;
    }

    /* renamed from: a */
    public static C0918q m6087a(String str) {
        try {
            return new C0918q(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public JSONObject mo1275d() {
        JSONObject d = super.mo1275d();
        try {
            d.put("font_scale", (double) this.f4340l);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f4341m.length; i++) {
                jSONArray.put((i * 4) + 0, (double) this.f4341m[i].left);
                jSONArray.put((i * 4) + 1, (double) this.f4341m[i].top);
                jSONArray.put((i * 4) + 2, (double) this.f4341m[i].right);
                jSONArray.put((i * 4) + 3, (double) this.f4341m[i].bottom);
            }
            d.put("content_margins", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        C0918q c0918q = (C0918q) obj;
        if (Float.compare(this.f4340l, c0918q.f4340l) == 0 && Arrays.equals(this.f4341m, c0918q.f4341m)) {
            return true;
        }
        return false;
    }
}
