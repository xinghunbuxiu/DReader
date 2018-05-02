package com.duokan.reader.common.webservices;

import com.duokan.reader.common.webservices.WebSession.SessionState;

import java.util.concurrent.Callable;

import miuipub.date.Calendar;

class i implements Callable {
    static final /* synthetic */ boolean a = (!WebSession.class.desiredAssertionStatus());
    final /* synthetic */ SessionTask b;

    i(SessionTask gVar) {
        this.b = gVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Void a() {
        if (this.b.a) {
            this.b.webSession.mSessionState = SessionState.CANCELLED;
            if (this.b.webSession.mSessionState == SessionState.SUCCEEDED) {
                this.b.webSession.onSessionSucceeded();
            } else if (this.b.webSession.mSessionState == SessionState.CANCELLED) {
                this.b.webSession.onSessionCancelled();
            } else if (this.b.webSession.mSessionState == SessionState.FAILED) {
                this.b.webSession.onSessionFailed();
            } else if (!a) {
                throw new AssertionError();
            }
            if (this.b.webSession.mSessionTask == this.b) {
                this.b.webSession.mSessionTask = null;
            }
            this.b.webSession.mIsClosed = true;
            this.b.webSession.onSessionClosed();
        } else {
            if (this.b.webSession.mSessionException == null) {
                this.b.webSession.mSessionState = SessionState.SUCCEEDED;
            } else if (this.b.webSession.onSessionException(this.b.webSession.mSessionException, this.b.webSession.mRetryCount)) {
                this.b.webSession.scheduleSessionTask(this.b.d, (long) ((this.b.webSession.mRetryCount * 2) * Calendar.MILLISECOND_OF_SECOND));
            } else {
                this.b.webSession.mSessionState = SessionState.FAILED;
            }
            if (this.b.webSession.mSessionState == SessionState.SUCCEEDED) {
                this.b.webSession.onSessionSucceeded();
            } else if (this.b.webSession.mSessionState == SessionState.CANCELLED) {
                this.b.webSession.onSessionCancelled();
            } else if (this.b.webSession.mSessionState == SessionState.FAILED) {
                this.b.webSession.onSessionFailed();
            } else if (a) {
                throw new AssertionError();
            }
            if (this.b.webSession.mSessionTask == this.b) {
                this.b.webSession.mSessionTask = null;
            }
            this.b.webSession.mIsClosed = true;
            this.b.webSession.onSessionClosed();
        }
        return null;
    }
}
