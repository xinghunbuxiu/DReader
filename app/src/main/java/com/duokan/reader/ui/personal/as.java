package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.k;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;

class as extends r {
    b a = new b();
    final /* synthetic */ am b;

    as(am amVar) {
        this.b = amVar;
    }

    protected void onSessionTry() {
        k kVar = new k(this, MiAccountManager.get(this.b.getContext()));
        this.a = kVar.a();
        if (TextUtils.isEmpty((CharSequence) this.a.a)) {
            this.a = kVar.e(this.b.c());
        } else {
            this.b.k = (String) this.a.a;
        }
    }

    protected void onSessionSucceeded() {
        if (this.a.b != 0 || TextUtils.isEmpty((CharSequence) this.a.a)) {
            this.b.g.dismiss();
            be.a(this.b.getContext(), j.personal__create_feedback_view__fail, 0).show();
            return;
        }
        this.b.k = (String) this.a.a;
        this.b.e();
    }

    protected void onSessionFailed() {
        this.b.g.dismiss();
        be.a(this.b.getContext(), j.personal__create_feedback_view__fail, 0).show();
    }
}
