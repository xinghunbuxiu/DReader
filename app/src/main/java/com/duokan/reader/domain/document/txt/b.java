package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.d;

import org.json.JSONObject;

public class b extends d {
    static final /* synthetic */ boolean a = (!b.class.desiredAssertionStatus());
    private final long b;

    protected b(long j) {
        this.b = j;
    }

    public long g() {
        return this.b;
    }

    public static b a(JSONObject jSONObject) {
        try {
            return new b(jSONObject.optLong("byte_offset", -1));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("byte_offset", g());
        } catch (Exception e) {
            if (a) {
                e.printStackTrace();
            } else {
                throw new AssertionError();
            }
        }
        return jSONObject;
    }

    public boolean a() {
        return true;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return true;
    }

    public boolean a(long j) {
        return true;
    }

    public boolean a(Document_a aVar) {
        if (aVar instanceof ay) {
            return a(((ay) aVar).g());
        }
        return this.b < ((b) aVar).b;
    }

    public boolean c(Document_a aVar) {
        if (aVar instanceof ay) {
            return d(((ay) aVar).h());
        }
        return this.b > ((b) aVar).b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this.b == ((b) obj).b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return f().toString();
    }
}
