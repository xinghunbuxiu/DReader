package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkFeedbackReply;
import com.duokan.reader.common.webservices.duokan.k;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;

class bx extends r {
    b a = new b();
    final /* synthetic */ bu b;

    bx(bu buVar) {
        this.b = buVar;
    }

    protected void onSessionTry() {
        this.a = new k(this, MiAccountManager.get(this.b.getContext())).a(this.b.a.d, this.b.b.getText().toString(), this.b.d);
    }

    protected void onSessionSucceeded() {
        this.b.c.dismiss();
        if (this.a.b == 0) {
            this.b.dismiss();
            be.a(this.b.getContext(), j.personal__feedback_thread_view__succeed, 0).show();
            this.b.a.a(((DkFeedbackReply) this.b.a.b.get(this.b.a.b.size() - 1)).mPosition);
            this.b.a.f.a(this.b.a.e);
            return;
        }
        be.a(this.b.getContext(), this.a.c, 0).show();
    }

    protected void onSessionFailed() {
        this.b.c.dismiss();
        be.a(this.b.getContext(), j.general__shared__network_error, 0).show();
    }
}
