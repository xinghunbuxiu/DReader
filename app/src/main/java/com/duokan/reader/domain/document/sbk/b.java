package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.d;

import org.json.JSONObject;

public class b extends d {
    static final /* synthetic */ boolean a = (!b.class.desiredAssertionStatus());
    private final long b;
    private final long c;
    private final long d;

    protected b(long j, long j2, long j3) {
        this.b = j;
        this.c = j2;
        this.d = j3;
    }

    public long g() {
        return this.b;
    }

    public long h() {
        return this.c;
    }

    public long i() {
        return this.d;
    }

    public static b a(JSONObject jSONObject) {
        try {
            return new b(jSONObject.optLong("chapter_index", 0), jSONObject.optLong("para_index", 0), jSONObject.optLong("atom_index", 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("chapter_index", g());
            jSONObject.put("para_index", h());
            jSONObject.put("atom_index", i());
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

    public boolean a(a aVar) {
        if (aVar instanceof ay) {
            return a(((ay) aVar).g());
        }
        b bVar = (b) aVar;
        if (this.b < bVar.b) {
            return true;
        }
        if (this.b == bVar.b && this.c < bVar.c) {
            return true;
        }
        if (this.b == bVar.b && this.c == bVar.c && this.d < bVar.d) {
            return true;
        }
        return false;
    }

    public boolean c(a aVar) {
        if (aVar instanceof ay) {
            return d(((ay) aVar).h());
        }
        b bVar = (b) aVar;
        if (this.b > bVar.b) {
            return true;
        }
        if (this.b == bVar.b && this.c > bVar.c) {
            return true;
        }
        if (this.b == bVar.b && this.c == bVar.c && this.d > bVar.d) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.b == bVar.b && this.c == bVar.c && this.d == bVar.d) {
            return true;
        }
        return false;
    }

    public String toString() {
        return f().toString();
    }
}
