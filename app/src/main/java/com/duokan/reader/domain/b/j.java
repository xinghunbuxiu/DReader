package com.duokan.reader.domain.b;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.ab;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

class j extends WebSession {
    final /* synthetic */ ab a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ b c;
    private JSONArray d;

    j(b bVar, ab abVar, Runnable runnable) {
        this.c = bVar;
        this.a = abVar;
        this.b = runnable;
    }

    protected void onSessionTry() {
        this.d = new JSONArray(new ad((WebSession) this, this.a).c(p.i().g()));
    }

    protected void onSessionSucceeded() {
        try {
            if (this.d != null) {
                for (int i = 0; i < this.d.length(); i++) {
                    JSONObject jSONObject = this.d.getJSONObject(i);
                    if (jSONObject != null) {
                        String string = jSONObject.getString("name");
                        Iterator it = this.c.f.iterator();
                        while (it.hasNext()) {
                            p pVar = (p) it.next();
                            if (string.equalsIgnoreCase(pVar.a)) {
                                pVar.e = jSONObject.getString("url");
                                pVar.f = jSONObject.getString("md5");
                                break;
                            }
                        }
                    }
                }
            }
            this.c.k = true;
            this.b.run();
        } catch (Exception e) {
        }
    }

    protected void onSessionFailed() {
    }
}
