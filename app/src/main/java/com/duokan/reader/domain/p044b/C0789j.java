package com.duokan.reader.domain.p044b;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.domain.account.al;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.b.j */
class C0789j extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f2641a;
    /* renamed from: b */
    final /* synthetic */ Runnable f2642b;
    /* renamed from: c */
    final /* synthetic */ C0781b f2643c;
    /* renamed from: d */
    private JSONArray f2644d;

    C0789j(C0781b c0781b, al alVar, Runnable runnable) {
        this.f2643c = c0781b;
        this.f2641a = alVar;
        this.f2642b = runnable;
    }

    protected void onSessionTry() {
        this.f2644d = new JSONArray(new ac((WebSession) this, this.f2641a).m553c(C0641o.m2934i().m2976g()));
    }

    protected void onSessionSucceeded() {
        try {
            if (this.f2644d != null) {
                for (int i = 0; i < this.f2644d.length(); i++) {
                    JSONObject jSONObject = this.f2644d.getJSONObject(i);
                    if (jSONObject != null) {
                        String string = jSONObject.getString("name");
                        Iterator it = this.f2643c.f2624f.iterator();
                        while (it.hasNext()) {
                            C0795p c0795p = (C0795p) it.next();
                            if (string.equalsIgnoreCase(c0795p.a)) {
                                c0795p.f2657e = jSONObject.getString("url");
                                c0795p.f2658f = jSONObject.getString("md5");
                                break;
                            }
                        }
                    }
                }
            }
            this.f2643c.f2629k = true;
            this.f2642b.run();
        } catch (Exception e) {
        }
    }

    protected void onSessionFailed() {
    }
}
