package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;

import org.json.JSONObject;

public class ce extends bb {
    static final /* synthetic */ boolean a = (!ce.class.desiredAssertionStatus());
    private final c b;
    private final c c;

    public /* synthetic */ av g() {
        return j();
    }

    public /* synthetic */ av h() {
        return k();
    }

    protected ce() {
        this(new c(0, 0, 0), new c(0, 0, 0));
    }

    protected ce(c cVar, c cVar2) {
        this.b = cVar;
        this.c = cVar2;
    }

    public static ce a(JSONObject jSONObject) {
        try {
            return new ce(c.a(jSONObject.getJSONObject("start_anchor")), c.a(jSONObject.getJSONObject("end_anchor")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected boolean a(DkeBook dkeBook) {
        if (b() && d()) {
            return j().a(dkeBook) | k().a(dkeBook);
        }
        return false;
    }

    protected static ce a(ce ceVar, ce ceVar2) {
        if (ceVar.f()) {
            return ceVar2;
        }
        if (ceVar2.f()) {
            return ceVar;
        }
        return new ce(ceVar.j().a(ceVar2.j()) ? ceVar.j() : ceVar2.j(), ceVar.k().c(ceVar2.k()) ? ceVar.k() : ceVar2.k());
    }

    protected static ce b(ce ceVar, ce ceVar2) {
        if (ceVar.f() || ceVar2.f()) {
            return ceVar;
        }
        return new ce(ceVar.j().a(ceVar2.j()) ? ceVar2.j() : ceVar.j(), ceVar.k().a(ceVar2.k()) ? ceVar.k() : ceVar2.k());
    }

    public boolean a() {
        return true;
    }

    public boolean c() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public boolean a(long j) {
        return true;
    }

    public c j() {
        return this.b;
    }

    public c k() {
        return this.c;
    }

    public bb a(bb bbVar) {
        return a(this, (ce) bbVar);
    }

    public bb b(bb bbVar) {
        return b(this, (ce) bbVar);
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start_anchor", this.b.f());
            jSONObject.put("end_anchor", this.c.f());
        } catch (Exception e) {
            if (a) {
                e.printStackTrace();
            } else {
                throw new AssertionError();
            }
        }
        return jSONObject;
    }
}
