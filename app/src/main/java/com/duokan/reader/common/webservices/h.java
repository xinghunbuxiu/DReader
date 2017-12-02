package com.duokan.reader.common.webservices;

import com.duokan.reader.common.webservices.WebSession.SessionState;

import java.util.concurrent.Callable;

class h implements Callable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Void a() {
        if (this.a.e.mIsClosed) {
            this.a.e.mIsClosed = false;
            this.a.e.mRetryCount = 0;
            this.a.e.mSessionException = null;
            this.a.e.mSessionState = SessionState.UNFINISHED;
            this.a.e.mCacheStrategy = this.a.d;
            this.a.e.onSessionOpen();
        }
        if (this.a.e.mSessionException != null) {
            WebSession.access$004(this.a.e);
            this.a.e.mSessionException = null;
        }
        return null;
    }
}
