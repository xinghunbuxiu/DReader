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
import java.util.List;
import org.json.JSONObject;

class bg extends WebSession {
    /* renamed from: a */
    C0621a<List<DkFeedbackThreadInfo>> f8318a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ bc f8319b;

    bg(bc bcVar, C0657i c0657i) {
        this.f8319b = bcVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f8318a = new C0637k(this, MiAccountManager.get(this.f8319b.getContext())).m2886a(this.f8319b.f8306b);
    }

    protected void onSessionSucceeded() {
        if (this.f8318a.b == 0) {
            int size = this.f8319b.f8306b.size();
            for (DkFeedbackThreadInfo dkFeedbackThreadInfo : (List) this.f8318a.f2058a) {
                if (dkFeedbackThreadInfo.mValid) {
                    if (!this.f8319b.f8309e || this.f8319b.f8308d.mo832b().equals(dkFeedbackThreadInfo.mAuthorId)) {
                        this.f8319b.f8307c.add(dkFeedbackThreadInfo);
                    } else {
                        this.f8319b.f8306b.remove(dkFeedbackThreadInfo.mThreadId);
                    }
                }
            }
            if (size != this.f8319b.f8306b.size()) {
                DkSharedStorageManager.m5016a().m5026a("read_threads_" + this.f8319b.f8308d.mo832b(), new JSONObject(this.f8319b.f8306b).toString(), true);
            }
        } else {
            be.m10287a(this.f8319b.getContext(), this.f8318a.c, 0).show();
        }
        this.f8319b.f8305a.getAdapter().m8785a(false);
    }

    protected void onSessionFailed() {
        be.m10286a(this.f8319b.getContext(), C0258j.general__shared__network_error, 0).show();
        this.f8319b.f8305a.getAdapter().m8790m();
    }
}
