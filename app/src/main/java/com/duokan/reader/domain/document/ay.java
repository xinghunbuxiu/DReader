package com.duokan.reader.domain.document;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class ay extends C0896a {
    /* renamed from: g */
    public abstract av mo1198g();

    /* renamed from: h */
    public abstract av mo1199h();

    /* renamed from: f */
    public final boolean m5817f() {
        return mo1198g().m5782d(mo1199h());
    }

    /* renamed from: a */
    public final boolean m5813a(ay ayVar) {
        return mo1198g().m5778b(ayVar.mo1198g()) && mo1199h().m5782d(ayVar.mo1199h());
    }

    /* renamed from: a */
    public final boolean m5812a(av avVar) {
        return mo1198g().m5778b(avVar) && mo1199h().mo1190c(avVar);
    }

    /* renamed from: b */
    public final boolean m5814b(ay ayVar) {
        C0896a c0896a;
        av g = mo1198g();
        C0896a h = mo1199h();
        av g2 = ayVar.mo1198g();
        C0896a h2 = ayVar.mo1199h();
        if (!g.mo1188a((C0896a) g2)) {
            g2 = g;
        }
        if (h.mo1188a(h2)) {
            c0896a = h;
        } else {
            c0896a = h2;
        }
        return g2.mo1188a(c0896a);
    }

    /* renamed from: a */
    public final boolean mo1188a(C0896a c0896a) {
        if (c0896a instanceof av) {
            return mo1198g().mo1188a((C0896a) (av) c0896a);
        }
        return mo1198g().mo1188a(((ay) c0896a).mo1198g());
    }

    /* renamed from: c */
    public final boolean mo1190c(C0896a c0896a) {
        if (c0896a instanceof av) {
            return mo1198g().mo1190c((av) c0896a);
        }
        return mo1198g().mo1190c(((ay) c0896a).mo1198g());
    }

    /* renamed from: d */
    public boolean mo1191d() {
        if (m5777b() && mo1198g().mo1191d() && mo1199h().mo1191d()) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public JSONObject mo1427i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start", mo1198g().mo1193f());
            jSONObject.put("end", mo1199h().mo1193f());
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
        if (mo1198g().equals(ayVar.mo1198g()) && mo1199h().equals(ayVar.mo1199h())) {
            return true;
        }
        return false;
    }
}
