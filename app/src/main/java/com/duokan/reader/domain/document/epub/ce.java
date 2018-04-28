package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;
import org.json.JSONObject;

public class ce extends bb {
    /* renamed from: a */
    static final /* synthetic */ boolean f4651a = (!ce.class.desiredAssertionStatus());
    /* renamed from: b */
    private final C0936c f4652b;
    /* renamed from: c */
    private final C0936c f4653c;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return m6813j();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return m6814k();
    }

    protected ce() {
        this(new C0936c(0, 0, 0), new C0936c(0, 0, 0));
    }

    protected ce(C0936c c0936c, C0936c c0936c2) {
        this.f4652b = c0936c;
        this.f4653c = c0936c2;
    }

    /* renamed from: a */
    public static ce m6801a(JSONObject jSONObject) {
        try {
            return new ce(C0936c.m6768a(jSONObject.getJSONObject("start_anchor")), C0936c.m6768a(jSONObject.getJSONObject("end_anchor")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    protected boolean m6806a(DkeBook dkeBook) {
        if (m5777b() && mo1191d()) {
            return m6813j().m6772a(dkeBook) | m6814k().m6772a(dkeBook);
        }
        return false;
    }

    /* renamed from: a */
    protected static ce m6800a(ce ceVar, ce ceVar2) {
        if (ceVar.m5817f()) {
            return ceVar2;
        }
        if (ceVar2.m5817f()) {
            return ceVar;
        }
        return new ce(ceVar.m6813j().mo1188a(ceVar2.m6813j()) ? ceVar.m6813j() : ceVar2.m6813j(), ceVar.m6814k().mo1190c(ceVar2.m6814k()) ? ceVar.m6814k() : ceVar2.m6814k());
    }

    /* renamed from: b */
    protected static ce m6802b(ce ceVar, ce ceVar2) {
        if (ceVar.m5817f() || ceVar2.m5817f()) {
            return ceVar;
        }
        return new ce(ceVar.m6813j().mo1188a(ceVar2.m6813j()) ? ceVar2.m6813j() : ceVar.m6813j(), ceVar.m6814k().mo1188a(ceVar2.m6814k()) ? ceVar.m6814k() : ceVar2.m6814k());
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        return false;
    }

    /* renamed from: e */
    public boolean mo1192e() {
        return true;
    }

    /* renamed from: a */
    public boolean mo1187a(long j) {
        return true;
    }

    /* renamed from: j */
    public C0936c m6813j() {
        return this.f4652b;
    }

    /* renamed from: k */
    public C0936c m6814k() {
        return this.f4653c;
    }

    /* renamed from: a */
    public bb mo1196a(bb bbVar) {
        return m6800a(this, (ce) bbVar);
    }

    /* renamed from: b */
    public bb mo1197b(bb bbVar) {
        return m6802b(this, (ce) bbVar);
    }

    /* renamed from: i */
    public JSONObject mo1427i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start_anchor", this.f4652b.mo1193f());
            jSONObject.put("end_anchor", this.f4653c.mo1193f());
        } catch (Exception e) {
            if (f4651a) {
                e.printStackTrace();
            } else {
                throw new AssertionError();
            }
        }
        return jSONObject;
    }
}
