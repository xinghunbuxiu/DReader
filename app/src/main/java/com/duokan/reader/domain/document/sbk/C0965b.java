package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.ay;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.document.sbk.b */
public class C0965b extends C0897d {
    /* renamed from: a */
    static final /* synthetic */ boolean f4796a = (!C0965b.class.desiredAssertionStatus());
    /* renamed from: b */
    private final long f4797b;
    /* renamed from: c */
    private final long f4798c;
    /* renamed from: d */
    private final long f4799d;

    protected C0965b(long j, long j2, long j3) {
        this.f4797b = j;
        this.f4798c = j2;
        this.f4799d = j3;
    }

    /* renamed from: g */
    public long m7141g() {
        return this.f4797b;
    }

    /* renamed from: h */
    public long m7142h() {
        return this.f4798c;
    }

    /* renamed from: i */
    public long m7143i() {
        return this.f4799d;
    }

    /* renamed from: a */
    public static C0965b m7132a(JSONObject jSONObject) {
        try {
            return new C0965b(jSONObject.optLong("chapter_index", 0), jSONObject.optLong("para_index", 0), jSONObject.optLong("atom_index", 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public JSONObject mo1193f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("chapter_index", m7141g());
            jSONObject.put("para_index", m7142h());
            jSONObject.put("atom_index", m7143i());
        } catch (Exception e) {
            if (f4796a) {
                e.printStackTrace();
            } else {
                throw new AssertionError();
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        return false;
    }

    /* renamed from: d */
    public boolean mo1191d() {
        return true;
    }

    /* renamed from: e */
    public boolean mo1192e() {
        return true;
    }

    /* renamed from: a */
    public boolean mo1187a(long j) {
        return true;
    }

    /* renamed from: a */
    public boolean mo1188a(C0896a c0896a) {
        if (c0896a instanceof ay) {
            return mo1188a(((ay) c0896a).mo1198g());
        }
        C0965b c0965b = (C0965b) c0896a;
        if (this.f4797b < c0965b.f4797b) {
            return true;
        }
        if (this.f4797b == c0965b.f4797b && this.f4798c < c0965b.f4798c) {
            return true;
        }
        if (this.f4797b == c0965b.f4797b && this.f4798c == c0965b.f4798c && this.f4799d < c0965b.f4799d) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo1190c(C0896a c0896a) {
        if (c0896a instanceof ay) {
            return m5782d(((ay) c0896a).mo1199h());
        }
        C0965b c0965b = (C0965b) c0896a;
        if (this.f4797b > c0965b.f4797b) {
            return true;
        }
        if (this.f4797b == c0965b.f4797b && this.f4798c > c0965b.f4798c) {
            return true;
        }
        if (this.f4797b == c0965b.f4797b && this.f4798c == c0965b.f4798c && this.f4799d > c0965b.f4799d) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0965b)) {
            return false;
        }
        C0965b c0965b = (C0965b) obj;
        if (this.f4797b == c0965b.f4797b && this.f4798c == c0965b.f4798c && this.f4799d == c0965b.f4799d) {
            return true;
        }
        return false;
    }

    public String toString() {
        return mo1193f().toString();
    }
}
