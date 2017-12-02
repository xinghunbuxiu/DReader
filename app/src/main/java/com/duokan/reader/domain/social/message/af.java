package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.j;
import com.duokan.reader.domain.account.ab;

class af extends j {
    final /* synthetic */ ab a;
    final /* synthetic */ DkMessagesManager b;
    private DkMessagesInfo c = null;

    af(DkMessagesManager dkMessagesManager, ab abVar) {
        this.b = dkMessagesManager;
        this.a = abVar;
    }

    protected void onSessionTry() {
        synchronized (DkMessagesManager.a) {
            av avVar = new av(this.b.e, this.a, this.b.f);
            avVar.a();
            this.c = avVar.b();
        }
    }

    protected void onSessionSucceeded() {
        if (this.b.k.a(this.a)) {
            this.b.a(this.c.mUnreadMessageIds);
        }
    }

    protected void onSessionFailed() {
    }
}
