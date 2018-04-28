package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UIdleHandler;

class ry implements Runnable {
    /* renamed from: a */
    final /* synthetic */ qr f10922a;

    ry(qr qrVar) {
        this.f10922a = qrVar;
    }

    public void run() {
        if (!this.f10922a.f9293q && !this.f10922a.f9284h.mo1448b()) {
            try {
                this.f10922a.f9291o = true;
                this.f10922a.mo1979a();
                this.f10922a.f9292p = true;
                UIdleHandler.addIdleHandler(new rz(this));
            } catch (Throwable e) {
                C0328a.m757c().m748a(LogLevel.ERROR, "reading", "an exception occurs during init", e);
                throw e;
            }
        }
    }
}
