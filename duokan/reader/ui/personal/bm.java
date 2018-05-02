package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.common.webservices.duokan.k;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;

import org.json.JSONObject;

class bm extends r {
    b a = new b();
    final /* synthetic */ DkFeedbackThreadInfo b;
    final /* synthetic */ int c;
    final /* synthetic */ bj d;

    bm(bj bjVar, DkFeedbackThreadInfo dkFeedbackThreadInfo, int i) {
        this.d = bjVar;
        this.b = dkFeedbackThreadInfo;
        this.c = i;
    }

    protected void onSessionTry() {
        this.a = new k(this, MiAccountManager.get(this.d.getContext())).f(this.b.mThreadId);
    }

    protected void onSessionSucceeded() {
        if (this.a.b != 0 || (this.d.e && (this.d.d == null || !((DkFeedbackThreadInfo) this.a.a).mAuthorId.equals(this.d.d.b())))) {
            this.d.b(this.b);
            return;
        }
        this.d.c.set(this.c, this.a.a);
        this.d.b.put(((DkFeedbackThreadInfo) this.a.a).mThreadId, Integer.valueOf(((DkFeedbackThreadInfo) this.a.a).mReplyCount));
        DkSharedStorageManager.a().a("read_threads_" + this.d.d.b(), new JSONObject(this.d.b).toString(), true);
        this.d.a.getAdapter().d();
    }

    protected void onSessionFailed() {
        be.a(this.d.getContext(), j.general__shared__network_error, 0).show();
        this.d.a.getAdapter().d();
    }
}
