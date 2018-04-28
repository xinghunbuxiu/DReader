package com.duokan.reader.ui.reading;

import org.apache.http.HttpStatus;

class lm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ fz f10572a;
    /* renamed from: b */
    final /* synthetic */ ll f10573b;

    lm(ll llVar, fz fzVar) {
        this.f10573b = llVar;
        this.f10572a = fzVar;
    }

    public void run() {
        Runnable lnVar = new ln(this);
        if (this.f10572a.mo2468b()) {
            this.f10572a.mo2436a(null);
            this.f10573b.m1832a(this.f10572a, this.f10573b.mo2339a(this.f10572a), HttpStatus.SC_MULTIPLE_CHOICES, lnVar, null);
            return;
        }
        this.f10572a.mo2436a(new lo(this, lnVar));
    }
}
