package com.duokan.reader.domain.bookshelf;

import android.graphics.Rect;
import android.text.TextUtils;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.epub.C0936c;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.epub.ce;
import com.duokan.reader.domain.document.p045a.C0898a;
import com.duokan.reader.domain.document.p045a.C0904d;
import com.duokan.reader.domain.document.sbk.C0965b;
import com.duokan.reader.domain.document.sbk.C0969f;
import com.duokan.reader.domain.document.txt.C0986b;
import com.duokan.reader.domain.document.txt.C1000p;
import org.json.JSONArray;
import org.json.JSONObject;

public class ke {
    /* renamed from: a */
    public av f3445a;
    /* renamed from: b */
    public Rect f3446b;
    /* renamed from: c */
    public bb f3447c;
    /* renamed from: d */
    public int f3448d;
    /* renamed from: e */
    public float f3449e;
    /* renamed from: f */
    public hb f3450f;
    /* renamed from: g */
    private boolean f3451g;

    public ke() {
        this.f3445a = null;
        this.f3446b = new Rect();
        this.f3447c = null;
        this.f3448d = -1;
        this.f3449e = 0.0f;
        this.f3451g = false;
        this.f3450f = new hb();
        this.f3445a = null;
        this.f3446b = new Rect();
        this.f3449e = 0.0f;
        this.f3448d = -1;
        this.f3450f = new hb();
    }

    public ke(BookFormat bookFormat, String str) {
        this.f3445a = null;
        this.f3446b = new Rect();
        this.f3447c = null;
        this.f3448d = -1;
        this.f3449e = 0.0f;
        this.f3451g = false;
        this.f3450f = new hb();
        switch (kf.f3452a[bookFormat.ordinal()]) {
            case 1:
                this.f3445a = C0952s.m6987a(0, 0, 0);
                break;
            case 2:
                this.f3445a = C0904d.m5963a(0, 0, 0);
                break;
            case 3:
                this.f3445a = C1000p.m7689b(0);
                break;
            case 4:
                this.f3445a = C0969f.m7162a(0, 0, 0);
                break;
        }
        this.f3449e = 0.0f;
        this.f3448d = -1;
        this.f3450f = new hb();
        if (TextUtils.isEmpty(str)) {
            this.f3451g = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (kf.f3452a[bookFormat.ordinal()]) {
                case 1:
                    this.f3445a = C0936c.m6768a(jSONObject);
                    break;
                case 2:
                    this.f3445a = C0898a.m5785a(jSONObject);
                    break;
                case 4:
                    this.f3445a = C0965b.m7132a(jSONObject);
                    break;
                default:
                    this.f3445a = C0986b.m7530a(jSONObject);
                    break;
            }
            this.f3446b = new Rect();
            JSONArray optJSONArray = jSONObject.optJSONArray("viewport");
            if (optJSONArray != null) {
                this.f3446b.set(optJSONArray.getInt(0), optJSONArray.getInt(1), optJSONArray.getInt(2), optJSONArray.getInt(3));
            }
            this.f3448d = jSONObject.optInt("slide_index", -1);
            this.f3449e = Math.max(0.0f, Math.min((float) jSONObject.optDouble("percent", 0.0d), 100.0f));
            JSONObject optJSONObject = jSONObject.optJSONObject("fixed_info");
            if (optJSONObject != null) {
                this.f3450f = new hb(optJSONObject);
            }
            jSONObject = jSONObject.optJSONObject("audio_position");
            if (jSONObject != null) {
                this.f3447c = ce.m6801a(jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public boolean m4818a() {
        return this.f3451g;
    }

    /* renamed from: b */
    public hb m4819b() {
        if (this.f3450f == null) {
            this.f3450f = new hb();
        }
        return this.f3450f;
    }

    /* renamed from: c */
    public bb m4820c() {
        return this.f3447c;
    }

    public String toString() {
        JSONObject f;
        Throwable th;
        JSONObject jSONObject = new JSONObject();
        try {
            f = this.f3445a.mo1193f();
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(0, this.f3446b.left);
                jSONArray.put(1, this.f3446b.top);
                jSONArray.put(2, this.f3446b.right);
                jSONArray.put(3, this.f3446b.bottom);
                f.put("viewport", jSONArray);
                f.put("percent", (double) this.f3449e);
                f.put("slide_index", this.f3448d);
                f.accumulate("fixed_info", this.f3450f.m4629j());
                if (this.f3447c != null) {
                    f.put("audio_position", this.f3447c.mo1427i());
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
