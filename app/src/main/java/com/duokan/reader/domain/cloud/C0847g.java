package com.duokan.reader.domain.cloud;

import org.json.JSONArray;

/* renamed from: com.duokan.reader.domain.cloud.g */
public class C0847g {
    /* renamed from: a */
    private long f4027a;
    /* renamed from: b */
    private long f4028b;
    /* renamed from: c */
    private long f4029c;
    /* renamed from: d */
    private String f4030d;
    /* renamed from: e */
    private long f4031e;

    public C0847g(long j, long j2, long j3, String str, long j4) {
        this.f4027a = j;
        this.f4028b = j2;
        this.f4029c = j3;
        this.f4030d = str;
        this.f4031e = j4;
    }

    /* renamed from: a */
    public String m5589a() {
        return this.f4030d;
    }

    /* renamed from: b */
    public long m5591b() {
        return this.f4027a;
    }

    /* renamed from: c */
    public long m5593c() {
        return this.f4028b;
    }

    /* renamed from: d */
    public long m5594d() {
        return this.f4029c;
    }

    /* renamed from: e */
    public long m5595e() {
        return this.f4031e;
    }

    /* renamed from: a */
    public boolean m5590a(C0847g c0847g) {
        if (this.f4027a > c0847g.m5591b()) {
            return true;
        }
        if (this.f4027a < c0847g.m5591b()) {
            return false;
        }
        if (this.f4031e > c0847g.m5595e()) {
            return true;
        }
        if (this.f4031e < c0847g.m5595e()) {
            return false;
        }
        return false;
    }

    /* renamed from: b */
    public boolean m5592b(C0847g c0847g) {
        if (this.f4027a < c0847g.m5591b()) {
            return true;
        }
        if (this.f4027a > c0847g.m5591b()) {
            return false;
        }
        if (this.f4031e < c0847g.m5595e()) {
            return true;
        }
        if (this.f4031e > c0847g.m5595e()) {
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public JSONArray m5596f() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f4030d);
        jSONArray.put(this.f4031e);
        jSONArray.put(this.f4027a);
        jSONArray.put(this.f4028b);
        jSONArray.put(this.f4029c);
        return jSONArray;
    }
}
