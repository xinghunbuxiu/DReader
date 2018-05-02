package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.common.webservices.duokan.k;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;

class au extends r {
    b a = new b();
    b b = new b();
    String c = "";
    String d = "";
    final /* synthetic */ am e;

    au(am amVar) {
        this.e = amVar;
    }

    protected void onSessionTry() {
        k kVar = new k(this, MiAccountManager.get(this.e.getContext()));
        this.c = this.e.f();
        this.d = this.e.e.getText().toString();
        this.a = kVar.a(String.valueOf(this.e.a[this.e.j]), this.c, this.d, this.e.d.isSelected());
    }

    protected void onSessionSucceeded() {
        this.e.g.dismiss();
        if (this.b.b != 0) {
            be.a(this.e.getContext(), this.b.c, 0).show();
        } else if (this.a.b == 0) {
            be.a(this.e.getContext(), j.personal__create_feedback_view__succeed, 0).show();
            DkFeedbackThreadInfo dkFeedbackThreadInfo = new DkFeedbackThreadInfo();
            dkFeedbackThreadInfo.mThreadId = (String) this.a.a;
            dkFeedbackThreadInfo.mAuthorId = this.e.i.b();
            dkFeedbackThreadInfo.mSubject = this.c;
            dkFeedbackThreadInfo.mDateLine = System.currentTimeMillis() / 1000;
            dkFeedbackThreadInfo.mReplyCount = 0;
            dkFeedbackThreadInfo.mValid = true;
            this.e.h.a(dkFeedbackThreadInfo);
            this.e.dismiss();
        } else {
            be.a(this.e.getContext(), this.a.c, 0).show();
        }
    }

    protected void onSessionFailed() {
        this.e.g.dismiss();
        be.a(this.e.getContext(), j.personal__create_feedback_view__fail, 0).show();
    }
}
