package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.domain.account.al;
import java.util.HashSet;
import java.util.Set;

class gf extends WebSession {
    /* renamed from: a */
    C0621a<String> f4044a = new C0621a();
    /* renamed from: b */
    final al f4045b = new al(this.f4046c.f3632d.m3508d());
    /* renamed from: c */
    final /* synthetic */ PersonalPrefs f4046c;

    gf(PersonalPrefs personalPrefs, C0657i c0657i) {
        this.f4046c = personalPrefs;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f4044a = new C0640n(this, this.f4045b).m2925h(this.f4046c.m5197a(this.f4046c.m5219c()));
    }

    protected void onSessionSucceeded() {
        if (this.f4044a.b == 0 && this.f4046c.m5209a(this.f4045b) && !TextUtils.isEmpty((CharSequence) this.f4044a.f2058a)) {
            Set hashSet = new HashSet();
            for (String str : ((String) this.f4044a.f2058a).split(",")) {
                if (!str.equals("empty")) {
                    hashSet.add(str);
                }
            }
            this.f4046c.m5207a(hashSet, false);
        }
    }

    protected void onSessionFailed() {
    }
}
