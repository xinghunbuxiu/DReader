package com.duokan.reader.ui.account;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.ui.general.be;
import java.util.ArrayList;
import java.util.List;

class bm extends WebSession {
    /* renamed from: a */
    C0621a<String> f5875a = new C0621a();
    /* renamed from: b */
    List<String> f5876b = new ArrayList();
    /* renamed from: c */
    final /* synthetic */ bl f5877c;

    bm(bl blVar, C0657i c0657i) {
        this.f5877c = blVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0640n c0640n = new C0640n(this, null);
        int i = 0;
        while (i < this.f5877c.f5872i.length) {
            this.f5875a = c0640n.m2924g(this.f5877c.f5872i[i]);
            if (this.f5875a.b == 0) {
                this.f5876b.add(this.f5875a.f2058a);
                i++;
            } else {
                return;
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.f5877c.g) {
            if (this.f5876b.size() != this.f5877c.f5872i.length) {
                CharSequence string = this.f5877c.getString(C0258j.share_failed);
                if (this.f5877c.h != null) {
                    this.f5877c.h.mo1845b(string);
                    this.f5877c.h = null;
                    return;
                }
                be.m10287a(this.f5877c.getContext(), string, 0).show();
                return;
            }
            this.f5877c.f5872i = (String[]) this.f5876b.toArray(new String[0]);
            this.f5877c.m8881b();
        }
    }

    protected void onSessionFailed() {
        if (!this.f5877c.g) {
            this.f5877c.m8885e();
            CharSequence string = this.f5877c.getString(C0258j.share_failed);
            if (this.f5877c.h != null) {
                this.f5877c.h.mo1845b(string);
                this.f5877c.h = null;
                return;
            }
            be.m10287a(this.f5877c.getContext(), string, 0).show();
        }
    }

    protected void onSessionClosed() {
        this.f5877c.g = false;
    }
}
