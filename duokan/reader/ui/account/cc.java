package com.duokan.reader.ui.account;

import com.duokan.c.j;
import com.duokan.core.app.c;
import com.duokan.core.app.d;
import com.duokan.reader.common.webservices.WebSession.SessionState;
import com.duokan.reader.ui.general.be;

class cc implements d {
    final /* synthetic */ bz a;

    cc(bz bzVar) {
        this.a = bzVar;
    }

    public void onCancel(c cVar) {
        if (this.a.a != null && !this.a.a.getIsClosed() && this.a.a.getSessionState() == SessionState.UNFINISHED) {
            this.a.g = true;
            this.a.a.close();
            CharSequence string = this.a.getString(j.share_cancel);
            if (this.a.h != null) {
                this.a.h.c(string);
                this.a.h = null;
                return;
            }
            be.a(this.a.getContext(), string, 0).show();
        }
    }
}
