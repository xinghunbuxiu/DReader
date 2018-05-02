package com.duokan.reader.domain.social.message;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.m;
import com.duokan.reader.common.webservices.duokan.n;
import com.duokan.reader.domain.account.ab;

class ah extends n {
    b a = null;
    final /* synthetic */ ab b;
    final /* synthetic */ DkMessagesManager c;

    ah(DkMessagesManager dkMessagesManager, ab abVar) {
        this.c = dkMessagesManager;
        this.b = abVar;
    }

    protected void onSessionTry() {
        synchronized (DkMessagesManager.a) {
            av avVar = new av(this.c.e, this.b, this.c.f);
            avVar.a();
            DkMessagesInfo b = avVar.b();
            if (!TextUtils.isEmpty(b.mUnreadThreshold)) {
                this.a = new m((n) this, this.b).a(b.mUnreadThreshold, this.c.d);
            }
            if (this.a == null || this.a.b == 0) {
                b.mUnreadMessageIds = new String[0];
                b.mReadThreshold = b.mUnreadThreshold;
                b.mUnreadThreshold = "";
                avVar.updateInfo(b);
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.c.k.a(this.b)) {
            return;
        }
        if (this.a == null || this.a.b == 0) {
            this.c.e();
        }
    }

    protected void onSessionFailed() {
    }
}
