package com.duokan.reader.domain.cloud;

import org.json.JSONArray;

public class g {
    private long a;
    private long b;
    private long c;
    private String d;
    private long e;

    public g(long j, long j2, long j3, String str, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = str;
        this.e = j4;
    }

    public String a() {
        return this.d;
    }

    public long b() {
        return this.a;
    }

    public long c() {
        return this.b;
    }

    public long d() {
        return this.c;
    }

    public long e() {
        return this.e;
    }

    public boolean a(g gVar) {
        if (this.a > gVar.b()) {
            return true;
        }
        if (this.a < gVar.b()) {
            return false;
        }
        if (this.e > gVar.e()) {
            return true;
        }
        if (this.e < gVar.e()) {
            return false;
        }
        return false;
    }

    public boolean b(g gVar) {
        if (this.a < gVar.b()) {
            return true;
        }
        if (this.a > gVar.b()) {
            return false;
        }
        if (this.e < gVar.e()) {
            return true;
        }
        if (this.e > gVar.e()) {
            return false;
        }
        return false;
    }

    public JSONArray f() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.d);
        jSONArray.put(this.e);
        jSONArray.put(this.a);
        jSONArray.put(this.b);
        jSONArray.put(this.c);
        return jSONArray;
    }
}
