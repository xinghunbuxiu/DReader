package com.duokan.reader.domain.document;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class ay extends Document_a {
    public abstract av g();

    public abstract av h();

    public final boolean f() {
        return g().d(h());
    }

    public final boolean a(ay ayVar) {
        return g().b(ayVar.g()) && h().d(ayVar.h());
    }

    public final boolean a(av avVar) {
        return g().b(avVar) && h().c(avVar);
    }

    public final boolean b(ay ayVar) {
        Document_a aVar;
        av g = g();
        Document_a h = h();
        av g2 = ayVar.g();
        Document_a h2 = ayVar.h();
        if (!g.a((Document_a) g2)) {
            g2 = g;
        }
        if (h.a(h2)) {
            aVar = h;
        } else {
            aVar = h2;
        }
        return g2.a(aVar);
    }

    public final boolean a(Document_a aVar) {
        if (aVar instanceof av) {
            return g().a((Document_a) (av) aVar);
        }
        return g().a(((ay) aVar).g());
    }

    public final boolean c(Document_a aVar) {
        if (aVar instanceof av) {
            return g().c((av) aVar);
        }
        return g().c(((ay) aVar).g());
    }

    public boolean d() {
        if (b() && g().d() && h().d()) {
            return true;
        }
        return false;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start", g().f());
            jSONObject.put("end", h().f());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ay ayVar = (ay) obj;
        if (g().equals(ayVar.g()) && h().equals(ayVar.h())) {
            return true;
        }
        return false;
    }
}
