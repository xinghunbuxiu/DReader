package com.duokan.reader.domain.social.message;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0639m;
import com.duokan.reader.domain.account.al;

class ae extends WebSession {
    /* renamed from: a */
    C0621a<Void> f5493a = null;
    /* renamed from: b */
    final /* synthetic */ al f5494b;
    /* renamed from: c */
    final /* synthetic */ DkMessagesManager f5495c;

    ae(DkMessagesManager dkMessagesManager, C0657i c0657i, al alVar) {
        this.f5495c = dkMessagesManager;
        this.f5494b = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        synchronized (DkMessagesManager.f5470a) {
            aq aqVar = new aq(this.f5495c.f5474e, this.f5494b, this.f5495c.f5475f);
            aqVar.m8529a();
            DkMessagesInfo b = aqVar.m8530b();
            if (!TextUtils.isEmpty(b.mUnreadThreshold)) {
                this.f5493a = new C0639m((WebSession) this, this.f5494b).m2902a(b.mUnreadThreshold, this.f5495c.f5473d);
            }
            if (this.f5493a == null || this.f5493a.b == 0) {
                b.mUnreadMessageIds = new String[0];
                b.mReadThreshold = b.mUnreadThreshold;
                b.mUnreadThreshold = "";
                aqVar.updateInfo(b);
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.f5495c.f5479j.m3365a(this.f5494b)) {
            return;
        }
        if (this.f5493a == null || this.f5493a.b == 0) {
            this.f5495c.m8493e();
        }
    }

    protected void onSessionFailed() {
    }
}
