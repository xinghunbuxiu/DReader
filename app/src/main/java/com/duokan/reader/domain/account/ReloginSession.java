package com.duokan.reader.domain.account;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.C0299i;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import org.apache.http.HttpHost;

public abstract class ReloginSession extends WebSession {
    /* renamed from: a */
    private final String f2234a;
    /* renamed from: b */
    private boolean f2235b = false;
    /* renamed from: c */
    private String f2236c;

    class InvalidTokenException extends Exception {
        private InvalidTokenException() {
        }
    }

    class ReloginFailedException extends Exception {
        ReloginFailedException() {
            super(DkApp.get().getString(C0247i.general__shared__relogin_failed));
        }
    }

    /* renamed from: a */
    protected abstract void mo825a();

    /* renamed from: a */
    protected abstract void mo826a(String str);

    /* renamed from: b */
    protected abstract void mo827b();

    /* renamed from: c */
    protected abstract boolean mo828c();

    public ReloginSession(String str, C0657i c0657i) {
        super(c0657i);
        this.f2234a = str;
        setMaxRetryCount(1);
    }

    protected final void onSessionTry() {
        if (this.f2235b) {
            C0299i c0299i = new C0299i();
            C0709k.m3476a().m3498a(this.f2234a, new cd(this, c0299i));
            if (((Boolean) c0299i.m707a()).booleanValue()) {
                mo825a();
                return;
            }
            throw new ReloginFailedException();
        }
        mo825a();
        if (mo828c()) {
            throw new InvalidTokenException();
        }
    }

    protected void onSessionSucceeded() {
        try {
            mo827b();
        } catch (Throwable th) {
            mo826a("");
        }
    }

    protected final void onSessionFailed() {
        WebLog.init().c(LogLevel.WARNING, HttpHost.DEFAULT_SCHEME_NAME, this.f2236c);
        mo826a(DkApp.get().getString(C0247i.general__shared__network_error));
    }

    protected final boolean onSessionException(Exception exception, int i) {
        if (!((exception instanceof InvalidTokenException) || (exception instanceof ReloginFailedException))) {
            mo1024a(exception);
        }
        boolean z = (exception instanceof InvalidTokenException) && super.onSessionException(exception, i);
        if (!z) {
            this.f2236c = exception.getMessage();
        }
        this.f2235b = z;
        return z;
    }

    public final void setMaxRetryCount(int i) {
        super.setMaxRetryCount(i);
    }

    protected int getRetryDelay(int i) {
        return 0;
    }

    /* renamed from: a */
    public void mo989a(C0672a c0672a) {
    }

    /* renamed from: a */
    public void mo1024a(Exception exception) {
    }
}
