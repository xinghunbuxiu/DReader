package com.duokan.reader.ui.account;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.WebSession.SessionState;
import com.duokan.reader.ui.general.be;

class bs implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ bp f5887a;

    bs(bp bpVar) {
        this.f5887a = bpVar;
    }

    public void onCancel(C0301c c0301c) {
        if (this.f5887a.f5806a != null && !this.f5887a.f5806a.getIsClosed() && this.f5887a.f5806a.getSessionState() == SessionState.UNFINISHED) {
            this.f5887a.f5812g = true;
            this.f5887a.f5806a.close();
            CharSequence string = this.f5887a.getString(C0258j.share_cancel);
            if (this.f5887a.f5813h != null) {
                this.f5887a.f5813h.mo1846c(string);
                this.f5887a.f5813h = null;
                return;
            }
            be.m10287a(this.f5887a.getContext(), string, 0).show();
        }
    }
}
