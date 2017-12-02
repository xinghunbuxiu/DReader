package com.duokan.reader.common.webservices;

import com.duokan.reader.common.webservices.WebSession.SessionState;

import java.util.concurrent.Callable;

import miuipub.date.Calendar;

class i implements Callable {
    static final /* synthetic */ boolean a = (!WebSession.class.desiredAssertionStatus());
    final /* synthetic */ g b;

    i(g gVar) {
        this.b = gVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Void a() {
        if (this.b.a) {
            this.b.e.mSessionState = SessionState.CANCELLED;
            if (this.b.e.mSessionState == SessionState.SUCCEEDED) {
                this.b.e.onSessionSucceeded();
            } else if (this.b.e.mSessionState == SessionState.CANCELLED) {
                this.b.e.onSessionCancelled();
            } else if (this.b.e.mSessionState == SessionState.FAILED) {
                this.b.e.onSessionFailed();
            } else if (!a) {
                throw new AssertionError();
            }
            if (this.b.e.mSessionTask == this.b) {
                this.b.e.mSessionTask = null;
            }
            this.b.e.mIsClosed = true;
            this.b.e.onSessionClosed();
        } else {
            if (this.b.e.mSessionException == null) {
                this.b.e.mSessionState = SessionState.SUCCEEDED;
            } else if (this.b.e.onSessionException(this.b.e.mSessionException, this.b.e.mRetryCount)) {
                this.b.e.scheduleSessionTask(this.b.d, (long) ((this.b.e.mRetryCount * 2) * Calendar.MILLISECOND_OF_SECOND));
            } else {
                this.b.e.mSessionState = SessionState.FAILED;
            }
            if (this.b.e.mSessionState == SessionState.SUCCEEDED) {
                this.b.e.onSessionSucceeded();
            } else if (this.b.e.mSessionState == SessionState.CANCELLED) {
                this.b.e.onSessionCancelled();
            } else if (this.b.e.mSessionState == SessionState.FAILED) {
                this.b.e.onSessionFailed();
            } else if (a) {
                throw new AssertionError();
            }
            if (this.b.e.mSessionTask == this.b) {
                this.b.e.mSessionTask = null;
            }
            this.b.e.mIsClosed = true;
            this.b.e.onSessionClosed();
        }
        return null;
    }
}
