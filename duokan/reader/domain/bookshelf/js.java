package com.duokan.reader.domain.bookshelf;

import android.graphics.Rect;
import android.text.TextUtils;

import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.epub.ce;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.txt.p;

import org.json.JSONArray;
import org.json.JSONObject;

public class js {
    public av a;
    public Rect b;
    public bb c;
    public int d;
    public float e;
    public hh f;
    private boolean g;

    public js() {
        this.a = null;
        this.b = new Rect();
        this.c = null;
        this.d = -1;
        this.e = 0.0f;
        this.g = false;
        this.f = new hh();
        this.a = null;
        this.b = new Rect();
        this.e = 0.0f;
        this.d = -1;
        this.f = new hh();
    }

    public js(BookFormat bookFormat, String str) {
        this.a = null;
        this.b = new Rect();
        this.c = null;
        this.d = -1;
        this.e = 0.0f;
        this.g = false;
        this.f = new hh();
        switch (jt.a[bookFormat.ordinal()]) {
            case 1:
                this.a = s.a(0, 0, 0);
                break;
            case 2:
                this.a = d.a(0, 0, 0);
                break;
            case 3:
                this.a = p.b(0);
                break;
            case 4:
                this.a = f.a(0, 0, 0);
                break;
        }
        this.e = 0.0f;
        this.d = -1;
        this.f = new hh();
        if (TextUtils.isEmpty(str)) {
            this.g = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (jt.a[bookFormat.ordinal()]) {
                case 1:
                    this.a = c.a(jSONObject);
                    break;
                case 2:
                    this.a = a.a(jSONObject);
                    break;
                case 4:
                    this.a = b.a(jSONObject);
                    break;
                default:
                    this.a = com.duokan.reader.domain.document.txt.b.a(jSONObject);
                    break;
            }
            this.b = new Rect();
            JSONArray optJSONArray = jSONObject.optJSONArray("viewport");
            if (optJSONArray != null) {
                this.b.set(optJSONArray.getInt(0), optJSONArray.getInt(1), optJSONArray.getInt(2), optJSONArray.getInt(3));
            }
            this.d = jSONObject.optInt("slide_index", -1);
            this.e = Math.max(0.0f, Math.min((float) jSONObject.optDouble("percent", 0.0d), 100.0f));
            JSONObject optJSONObject = jSONObject.optJSONObject("fixed_info");
            if (optJSONObject != null) {
                this.f = new hh(optJSONObject);
            }
            jSONObject = jSONObject.optJSONObject("audio_position");
            if (jSONObject != null) {
                this.c = ce.a(jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    public boolean a() {
        return this.g;
    }

    public hh b() {
        if (this.f == null) {
            this.f = new hh();
        }
        return this.f;
    }

    public bb c() {
        return this.c;
    }

    public String toString() {
        JSONObject f;
        Throwable th;
        JSONObject jSONObject = new JSONObject();
        try {
            f = this.a.f();
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(0, this.b.left);
                jSONArray.put(1, this.b.top);
                jSONArray.put(2, this.b.right);
                jSONArray.put(3, this.b.bottom);
                f.put("viewport", jSONArray);
                f.put("percent", (double) this.e);
                f.put("slide_index", this.d);
                f.accumulate("fixed_info", this.f.j());
                if (this.c != null) {
                    f.put("audio_position", this.c.i());
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return f.toString();
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            f = jSONObject;
            th = th4;
            th.printStackTrace();
            return f.toString();
        }
        return f.toString();
    }
}
