package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0637k;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.ui.general.be;
import com.xiaomi.passport.accountmanager.MiAccountManager;

class an extends WebSession {
    /* renamed from: a */
    C0621a<String> f8265a = new C0621a();
    /* renamed from: b */
    C0621a<Void> f8266b = new C0621a();
    /* renamed from: c */
    String f8267c = "";
    /* renamed from: d */
    String f8268d = "";
    /* renamed from: e */
    final /* synthetic */ af f8269e;

    an(af afVar, C0657i c0657i) {
        this.f8269e = afVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0637k c0637k = new C0637k(this, MiAccountManager.get(this.f8269e.getContext()));
        this.f8267c = this.f8269e.m11387f();
        this.f8268d = this.f8269e.f8250e.getText().toString();
        this.f8265a = c0637k.m2885a(String.valueOf(this.f8269e.f8246a[this.f8269e.f8255j]), this.f8267c, this.f8268d, this.f8269e.f8249d.isSelected());
    }

    protected void onSessionSucceeded() {
        this.f8269e.f8252g.dismiss();
        if (this.f8266b.b != 0) {
            be.m10287a(this.f8269e.getContext(), this.f8266b.c, 0).show();
        } else if (this.f8265a.b == 0) {
            be.m10286a(this.f8269e.getContext(), C0258j.personal__create_feedback_view__succeed, 0).show();
            DkFeedbackThreadInfo dkFeedbackThreadInfo = new DkFeedbackThreadInfo();
            dkFeedbackThreadInfo.mThreadId = (String) this.f8265a.f2058a;
            dkFeedbackThreadInfo.mAuthorId = this.f8269e.f8254i.mo832b();
            dkFeedbackThreadInfo.mSubject = this.f8267c;
            dkFeedbackThreadInfo.mDateLine = System.currentTimeMillis() / 1000;
            dkFeedbackThreadInfo.mReplyCount = 0;
            dkFeedbackThreadInfo.mValid = true;
            this.f8269e.f8253h.mo1870a(dkFeedbackThreadInfo);
            this.f8269e.dismiss();
        } else {
            be.m10287a(this.f8269e.getContext(), this.f8265a.c, 0).show();
        }
    }

    protected void onSessionFailed() {
        this.f8269e.f8252g.dismiss();
        be.m10286a(this.f8269e.getContext(), C0258j.personal__create_feedback_view__fail, 0).show();
    }
}
