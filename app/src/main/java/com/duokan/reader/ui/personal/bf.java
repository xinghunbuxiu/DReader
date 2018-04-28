package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0637k;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import org.json.JSONObject;

class bf extends WebSession {
    /* renamed from: a */
    C0621a<DkFeedbackThreadInfo> f8314a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ DkFeedbackThreadInfo f8315b;
    /* renamed from: c */
    final /* synthetic */ int f8316c;
    /* renamed from: d */
    final /* synthetic */ bc f8317d;

    bf(bc bcVar, C0657i c0657i, DkFeedbackThreadInfo dkFeedbackThreadInfo, int i) {
        this.f8317d = bcVar;
        this.f8315b = dkFeedbackThreadInfo;
        this.f8316c = i;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f8314a = new C0637k(this, MiAccountManager.get(this.f8317d.getContext())).m2893f(this.f8315b.mThreadId);
    }

    protected void onSessionSucceeded() {
        if (this.f8314a.b != 0 || (this.f8317d.f8309e && (this.f8317d.f8308d == null || !((DkFeedbackThreadInfo) this.f8314a.f2058a).mAuthorId.equals(this.f8317d.f8308d.mo832b())))) {
            this.f8317d.m11447b(this.f8315b);
            return;
        }
        this.f8317d.f8307c.set(this.f8316c, this.f8314a.f2058a);
        this.f8317d.f8306b.put(((DkFeedbackThreadInfo) this.f8314a.f2058a).mThreadId, Integer.valueOf(((DkFeedbackThreadInfo) this.f8314a.f2058a).mReplyCount));
        DkSharedStorageManager.m5016a().m5026a("read_threads_" + this.f8317d.f8308d.mo832b(), new JSONObject(this.f8317d.f8306b).toString(), true);
        this.f8317d.f8305a.getAdapter().mo1691d();
    }

    protected void onSessionFailed() {
        be.m10286a(this.f8317d.getContext(), C0258j.general__shared__network_error, 0).show();
        this.f8317d.f8305a.getAdapter().mo1691d();
    }
}
