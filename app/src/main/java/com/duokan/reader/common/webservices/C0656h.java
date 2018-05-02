package com.duokan.reader.common.webservices;

import com.duokan.reader.common.webservices.WebSession.SessionState;
import java.util.concurrent.Callable;

/* renamed from: com.duokan.reader.common.webservices.h */
class C0656h implements Callable<Void> {
    /* renamed from: a */
    static final /* synthetic */ boolean f2202a = (!WebSession.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0654f f2203b;

    C0656h(C0654f c0654f) {
        this.f2203b = c0654f;
    }

    public /* synthetic */ Object call() {
        return m3093a();
    }

    /* renamed from: a */
    public Void m3093a() {
        if (this.f2203b.f2196a) {
            this.f2203b.f2200e.mSessionState = SessionState.CANCELLED;
            if (this.f2203b.f2200e.mSessionState == SessionState.SUCCEEDED) {
                this.f2203b.f2200e.onSessionSucceeded();
            } else if (this.f2203b.f2200e.mSessionState == SessionState.CANCELLED) {
                this.f2203b.f2200e.onSessionCancelled();
            } else if (this.f2203b.f2200e.mSessionState == SessionState.FAILED) {
                this.f2203b.f2200e.onSessionFailed();
            } else if (!f2202a) {
                throw new AssertionError();
            }
            if (this.f2203b.f2200e.mSessionTask == this.f2203b) {
                this.f2203b.f2200e.mSessionTask = null;
            }
            this.f2203b.f2200e.mIsClosed = true;
            this.f2203b.f2200e.onSessionClosed();
        } else {
            if (this.f2203b.f2200e.mSessionException == null) {
                this.f2203b.f2200e.mSessionState = SessionState.SUCCEEDED;
            } else if (this.f2203b.f2200e.onSessionException(this.f2203b.f2200e.mSessionException, this.f2203b.f2200e.mRetryCount)) {
                this.f2203b.f2200e.scheduleSessionTask(this.f2203b.f2199d, (long) this.f2203b.f2200e.getRetryDelay(this.f2203b.f2200e.mRetryCount));
            } else {
                this.f2203b.f2200e.mSessionState = SessionState.FAILED;
            }
            if (this.f2203b.f2200e.mSessionState == SessionState.SUCCEEDED) {
                this.f2203b.f2200e.onSessionSucceeded();
            } else if (this.f2203b.f2200e.mSessionState == SessionState.CANCELLED) {
                this.f2203b.f2200e.onSessionCancelled();
            } else if (this.f2203b.f2200e.mSessionState == SessionState.FAILED) {
                this.f2203b.f2200e.onSessionFailed();
            } else if (f2202a) {
                throw new AssertionError();
            }
            if (this.f2203b.f2200e.mSessionTask == this.f2203b) {
                this.f2203b.f2200e.mSessionTask = null;
            }
            this.f2203b.f2200e.mIsClosed = true;
            this.f2203b.f2200e.onSessionClosed();
        }
        return null;
    }
}
