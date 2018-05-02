package com.duokan.reader.domain.document.sbk;

import android.graphics.RectF;
import com.duokan.reader.domain.document.C0917k;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.document.sbk.p */
public class C0977p extends C0917k {
    /* renamed from: l */
    public float f4839l;
    /* renamed from: m */
    public RectF[] f4840m;

    public C0977p() {
        this.f4839l = 1.0f;
        this.f4840m = new RectF[0];
    }

    public C0977p(JSONObject jSONObject) {
        int i = 0;
        super(jSONObject);
        this.f4839l = 1.0f;
        this.f4840m = new RectF[0];
        this.f4839l = (float) jSONObject.getDouble("font_scale");
        JSONArray jSONArray = jSONObject.getJSONArray("content_margins");
        this.f4840m = new RectF[(jSONArray.length() / 4)];
        while (i < this.f4840m.length) {
            this.f4840m[i] = new RectF((float) jSONArray.getDouble((i * 4) + 0), (float) jSONArray.getDouble((i * 4) + 1), (float) jSONArray.getDouble((i * 4) + 2), (float) jSONArray.getDouble((i * 4) + 3));
            i++;
        }
    }

    public C0977p(C0977p c0977p) {
        super((C0917k) c0977p);
        this.f4839l = 1.0f;
        this.f4840m = new RectF[0];
        this.f4839l = c0977p.f4839l;
        this.f4840m = c0977p.f4840m;
    }

    /* renamed from: c */
    public boolean mo1274c() {
        return this.a < 0 && this.b < 0;
    }

    /* renamed from: a */
    public static C0977p m7264a(String str) {
        try {
            return new C0977p(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public JSONObject mo1275d() {
        JSONObject d = super.mo1275d();
        try {
            d.put("font_scale", (double) this.f4839l);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f4840m.length; i++) {
                jSONArray.put((i * 4) + 0, (double) this.f4840m[i].left);
                jSONArray.put((i * 4) + 1, (double) this.f4840m[i].top);
                jSONArray.put((i * 4) + 2, (double) this.f4840m[i].right);
                jSONArray.put((i * 4) + 3, (double) this.f4840m[i].bottom);
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
        C0977p c0977p = (C0977p) obj;
        if (Float.compare(this.f4839l, c0977p.f4839l) == 0 && Arrays.equals(this.f4840m, c0977p.f4840m)) {
            return true;
        }
        return false;
    }
}
