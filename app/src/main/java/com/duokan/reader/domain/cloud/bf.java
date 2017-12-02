package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.j;
import com.duokan.reader.domain.account.ab;

import java.io.Serializable;

class bf extends j {
    final ab a = this.c.f;
    final /* synthetic */ Serializable b;
    final /* synthetic */ bd c;
    private bk d = new bk();

    bf(bd bdVar, Serializable serializable) {
        this.c = bdVar;
        this.b = serializable;
    }

    protected void onSessionTry() {
        this.d = this.c.a(this.a.a, (String) this.b);
    }

    protected void onSessionSucceeded() {
        if (this.a.a(this.c.f) && !this.c.e.equals(this.d)) {
            this.c.a(false, false, null);
        }
    }

    protected void onSessionFailed() {
    }
}
