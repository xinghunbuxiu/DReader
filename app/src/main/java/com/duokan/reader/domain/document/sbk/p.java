package com.duokan.reader.domain.document.sbk;

import android.graphics.RectF;

import com.duokan.reader.domain.document.k;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class p extends k {
    public float l;
    public RectF[] m;

    public p() {
        this.l = 1.0f;
        this.m = new RectF[0];
    }

    public p(JSONObject jSONObject) {
        int i = 0;
        super(jSONObject);
        this.l = 1.0f;
        this.m = new RectF[0];
        this.l = (float) jSONObject.getDouble("font_scale");
        JSONArray jSONArray = jSONObject.getJSONArray("content_margins");
        this.m = new RectF[(jSONArray.length() / 4)];
        while (i < this.m.length) {
            this.m[i] = new RectF((float) jSONArray.getDouble((i * 4) + 0), (float) jSONArray.getDouble((i * 4) + 1), (float) jSONArray.getDouble((i * 4) + 2), (float) jSONArray.getDouble((i * 4) + 3));
            i++;
        }
    }

    public p(p pVar) {
        super((k) pVar);
        this.l = 1.0f;
        this.m = new RectF[0];
        this.l = pVar.l;
        this.m = pVar.m;
    }

    public boolean c() {
        return this.a < 0 && this.b < 0;
    }

    public static p a(String str) {
        try {
            return new p(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject d() {
        JSONObject d = super.d();
        try {
            d.put("font_scale", (double) this.l);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.m.length; i++) {
                jSONArray.put((i * 4) + 0, (double) this.m[i].left);
                jSONArray.put((i * 4) + 1, (double) this.m[i].top);
                jSONArray.put((i * 4) + 2, (double) this.m[i].right);
                jSONArray.put((i * 4) + 3, (double) this.m[i].bottom);
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
        p pVar = (p) obj;
        if (Float.compare(this.l, pVar.l) == 0 && Arrays.equals(this.m, pVar.m)) {
            return true;
        }
        return false;
    }
}
