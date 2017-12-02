package com.duokan.reader.domain.document.a;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.d;

import org.json.JSONObject;

public class a extends d {
    static final /* synthetic */ boolean a = (!a.class.desiredAssertionStatus());
    private final long b;
    private final long c;
    private final long d;

    protected a(long j, long j2, long j3) {
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

    public static a a(JSONObject jSONObject) {
        try {
            return new a(jSONObject.optLong("fixed_index", 0), jSONObject.optLong("node_index", 0), jSONObject.optLong("atom_index", 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fixed_index", g());
            jSONObject.put("node_index", h());
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

    protected DkFlowPosition a(DkpBook dkpBook) {
        return new DkFlowPosition(this.b + 1, this.c, this.d);
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

    public boolean a(com.duokan.reader.domain.document.a aVar) {
        if (aVar instanceof ay) {
            return a(((ay) aVar).g());
        }
        a aVar2 = (a) aVar;
        if (this.b < aVar2.b) {
            return true;
        }
        if (this.b == aVar2.b && this.c < aVar2.c) {
            return true;
        }
        if (this.b == aVar2.b && this.c == aVar2.c && this.d < aVar2.d) {
            return true;
        }
        return false;
    }

    public boolean c(com.duokan.reader.domain.document.a aVar) {
        if (aVar instanceof ay) {
            return d(((ay) aVar).h());
        }
        a aVar2 = (a) aVar;
        if (this.b > aVar2.b) {
            return true;
        }
        if (this.b == aVar2.b && this.c > aVar2.c) {
            return true;
        }
        if (this.b == aVar2.b && this.c == aVar2.c && this.d > aVar2.d) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.b == aVar.b && this.c == aVar.c && this.d == aVar.d) {
            return true;
        }
        return false;
    }

    public String toString() {
        return f().toString();
    }
}
