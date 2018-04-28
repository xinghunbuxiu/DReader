package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;

class br extends WebSession {
    /* renamed from: a */
    Bitmap f5883a = null;
    /* renamed from: b */
    final /* synthetic */ String f5884b;
    /* renamed from: c */
    final /* synthetic */ bt f5885c;
    /* renamed from: d */
    final /* synthetic */ bp f5886d;

    br(bp bpVar, C0657i c0657i, String str, bt btVar) {
        this.f5886d = bpVar;
        this.f5884b = str;
        this.f5885c = btVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f5883a = new C0237c(this).m545a(this.f5884b);
    }

    protected void onSessionSucceeded() {
        if (!this.f5886d.f5812g) {
            if (this.f5883a != null) {
                this.f5885c.mo1573a(this.f5883a, true);
            } else {
                onSessionFailed();
            }
        }
    }

    protected void onSessionFailed() {
        if (!this.f5886d.f5812g) {
            this.f5885c.mo1572a();
        }
    }

    protected void onSessionClosed() {
        this.f5886d.f5812g = false;
    }
}
