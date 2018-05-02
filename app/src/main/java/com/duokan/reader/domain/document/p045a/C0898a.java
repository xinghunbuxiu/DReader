package com.duokan.reader.domain.document.p045a;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.ay;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.document.a.a */
public class C0898a extends C0897d {
    /* renamed from: a */
    static final /* synthetic */ boolean f4219a = (!C0898a.class.desiredAssertionStatus());
    /* renamed from: b */
    private final long f4220b;
    /* renamed from: c */
    private final long f4221c;
    /* renamed from: d */
    private final long f4222d;

    protected C0898a(long j, long j2, long j3) {
        this.f4220b = j;
        this.f4221c = j2;
        this.f4222d = j3;
    }

    /* renamed from: g */
    public long m5795g() {
        return this.f4220b;
    }

    /* renamed from: h */
    public long m5796h() {
        return this.f4221c;
    }

    /* renamed from: i */
    public long m5797i() {
        return this.f4222d;
    }

    /* renamed from: a */
    public static C0898a m5785a(JSONObject jSONObject) {
        try {
            return new C0898a(jSONObject.optLong("fixed_index", 0), jSONObject.optLong("node_index", 0), jSONObject.optLong("atom_index", 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public JSONObject mo1193f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fixed_index", m5795g());
            jSONObject.put("node_index", m5796h());
            jSONObject.put("atom_index", m5797i());
        } catch (Exception e) {
            if (f4219a) {
                e.printStackTrace();
            } else {
                throw new AssertionError();
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    protected DkFlowPosition m5786a(DkpBook dkpBook) {
        return new DkFlowPosition(this.f4220b + 1, this.f4221c, this.f4222d);
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
        C0898a c0898a = (C0898a) c0896a;
        if (this.f4220b < c0898a.f4220b) {
            return true;
        }
        if (this.f4220b == c0898a.f4220b && this.f4221c < c0898a.f4221c) {
            return true;
        }
        if (this.f4220b == c0898a.f4220b && this.f4221c == c0898a.f4221c && this.f4222d < c0898a.f4222d) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo1190c(C0896a c0896a) {
        if (c0896a instanceof ay) {
            return m5782d(((ay) c0896a).mo1199h());
        }
        C0898a c0898a = (C0898a) c0896a;
        if (this.f4220b > c0898a.f4220b) {
            return true;
        }
        if (this.f4220b == c0898a.f4220b && this.f4221c > c0898a.f4221c) {
            return true;
        }
        if (this.f4220b == c0898a.f4220b && this.f4221c == c0898a.f4221c && this.f4222d > c0898a.f4222d) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0898a)) {
            return false;
        }
        C0898a c0898a = (C0898a) obj;
        if (this.f4220b == c0898a.f4220b && this.f4221c == c0898a.f4221c && this.f4222d == c0898a.f4222d) {
            return true;
        }
        return false;
    }

    public String toString() {
        return mo1193f().toString();
    }
}
