package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.al;
import org.json.JSONObject;

class gh extends WebSession {
    /* renamed from: a */
    C0621a<String> f4051a = new C0621a();
    /* renamed from: b */
    final al f4052b = new al(this.f4053c.f3632d.m3508d());
    /* renamed from: c */
    final /* synthetic */ PersonalPrefs f4053c;

    gh(PersonalPrefs personalPrefs, C0657i c0657i) {
        this.f4053c = personalPrefs;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4051a = new C0640n(this, this.f4052b).m2919c();
    }

    protected void onSessionSucceeded() {
        if (this.f4051a.b == 0 && this.f4053c.m5209a(this.f4052b)) {
            try {
                if (new JSONObject((String) this.f4051a.f2058a).length() == 0) {
                    this.f4051a.f2058a = this.f4053c.m5166H().getString("user_persona", "");
                }
            } catch (Throwable th) {
            }
            this.f4053c.m5206a((String) this.f4051a.f2058a);
        }
    }

    protected void onSessionFailed() {
    }
}
