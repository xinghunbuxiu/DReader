package com.duokan.reader.common.webservices;

import com.duokan.reader.common.webservices.WebSession.SessionState;

import java.util.concurrent.Callable;

class h implements Callable {
    final /* synthetic */ SessionTask a;

    h(SessionTask gVar) {
        this.a = gVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Void a() {
        if (this.a.webSession.mIsClosed) {
            this.a.webSession.mIsClosed = false;
            this.a.webSession.mRetryCount = 0;
            this.a.webSession.mSessionException = null;
            this.a.webSession.mSessionState = SessionState.UNFINISHED;
            this.a.webSession.mCacheStrategy = this.a.d;
            this.a.webSession.onSessionOpen();
        }
        if (this.a.webSession.mSessionException != null) {
            WebSession.access$004(this.a.webSession);
            this.a.webSession.mSessionException = null;
        }
        return null;
    }
}
