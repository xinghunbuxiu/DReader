package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0637k;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;

class al extends WebSession {
    /* renamed from: a */
    C0621a<String> f8262a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ af f8263b;

    al(af afVar, C0657i c0657i) {
        this.f8263b = afVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0637k c0637k = new C0637k(this, MiAccountManager.get(this.f8263b.getContext()));
        this.f8262a = c0637k.m2882a();
        if (TextUtils.isEmpty((CharSequence) this.f8262a.f2058a)) {
            this.f8262a = c0637k.m2892e(this.f8263b.m11382c());
        } else {
            this.f8263b.f8256k = (String) this.f8262a.f2058a;
        }
    }

    protected void onSessionSucceeded() {
        if (this.f8262a.b != 0 || TextUtils.isEmpty((CharSequence) this.f8262a.f2058a)) {
            this.f8263b.f8252g.dismiss();
            be.m10286a(this.f8263b.getContext(), C0258j.personal__create_feedback_view__fail, 0).show();
            return;
        }
        this.f8263b.f8256k = (String) this.f8262a.f2058a;
        this.f8263b.m11386e();
    }

    protected void onSessionFailed() {
        this.f8263b.f8252g.dismiss();
        be.m10286a(this.f8263b.getContext(), C0258j.personal__create_feedback_view__fail, 0).show();
    }
}
