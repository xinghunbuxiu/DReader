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

import java.util.List;

class bn extends r {
    b a = new b();
    final /* synthetic */ bj b;

    bn(bj bjVar) {
        this.b = bjVar;
    }

    protected void onSessionTry() {
        this.a = new k(this, MiAccountManager.get(this.b.getContext())).a(this.b.b);
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0) {
            int size = this.b.b.size();
            for (DkFeedbackThreadInfo dkFeedbackThreadInfo : (List) this.a.a) {
                if (dkFeedbackThreadInfo.mValid) {
                    if (!this.b.e || this.b.d.b().equals(dkFeedbackThreadInfo.mAuthorId)) {
                        this.b.c.add(dkFeedbackThreadInfo);
                    } else {
                        this.b.b.remove(dkFeedbackThreadInfo.mThreadId);
                    }
                }
            }
            if (size != this.b.b.size()) {
                DkSharedStorageManager.a().a("read_threads_" + this.b.d.b(), new JSONObject(this.b.b).toString(), true);
            }
        } else {
            be.a(this.b.getContext(), this.a.c, 0).show();
        }
        this.b.a.getAdapter().a(false);
    }

    protected void onSessionFailed() {
        be.a(this.b.getContext(), j.general__shared__network_error, 0).show();
        this.b.a.getAdapter().m();
    }
}
