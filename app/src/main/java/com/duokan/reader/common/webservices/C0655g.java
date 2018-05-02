package com.duokan.reader.common.webservices;

import com.duokan.reader.common.webservices.WebSession.SessionState;
import java.util.concurrent.Callable;

/* renamed from: com.duokan.reader.common.webservices.g */
class C0655g implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ C0654f f2201a;

    C0655g(C0654f c0654f) {
        this.f2201a = c0654f;
    }

    public /* synthetic */ Object call() {
        return m3092a();
    }

    /* renamed from: a */
    public Void m3092a() {
        if (this.f2201a.f2200e.mIsClosed) {
            this.f2201a.f2200e.mIsClosed = false;
            this.f2201a.f2200e.mRetryCount = 0;
            this.f2201a.f2200e.mSessionException = null;
            this.f2201a.f2200e.mSessionState = SessionState.UNFINISHED;
            this.f2201a.f2200e.mCacheStrategy = this.f2201a.f2199d;
            this.f2201a.f2200e.onSessionOpen();
        }
        if (this.f2201a.f2200e.mSessionException != null) {
            WebSession.access$004(this.f2201a.f2200e);
            this.f2201a.f2200e.mSessionException = null;
        }
        return null;
    }
}
