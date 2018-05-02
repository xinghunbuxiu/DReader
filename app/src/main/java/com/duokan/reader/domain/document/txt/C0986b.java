package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.ay;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.document.txt.b */
public class C0986b extends C0897d {
    /* renamed from: a */
    static final /* synthetic */ boolean f4935a = (!C0986b.class.desiredAssertionStatus());
    /* renamed from: b */
    private final long f4936b;

    protected C0986b(long j) {
        this.f4936b = j;
    }

    /* renamed from: g */
    public long m7539g() {
        return this.f4936b;
    }

    /* renamed from: a */
    public static C0986b m7530a(JSONObject jSONObject) {
        try {
            return new C0986b(jSONObject.optLong("byte_offset", -1));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public JSONObject mo1193f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("byte_offset", m7539g());
        } catch (Exception e) {
            if (f4935a) {
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
        return this.f4936b < ((C0986b) c0896a).f4936b;
    }

    /* renamed from: c */
    public boolean mo1190c(C0896a c0896a) {
        if (c0896a instanceof ay) {
            return m5782d(((ay) c0896a).mo1199h());
        }
        return this.f4936b > ((C0986b) c0896a).f4936b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0986b)) {
            return false;
        }
        if (this.f4936b == ((C0986b) obj).f4936b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return mo1193f().toString();
    }
}
