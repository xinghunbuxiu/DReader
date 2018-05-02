package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.j;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class bg extends j {
    final ab a = this.c.f;
    final /* synthetic */ boolean b;
    final /* synthetic */ bd c;
    private bk d = new bk();

    bg(bd bdVar, boolean z) {
        this.c = bdVar;
        this.b = z;
    }

    protected void onSessionTry() {
        this.d = this.c.a(this.a.a, DkSharedStorageManager.a().a(SharedKey.USER_PRIVILEGE));
    }

    protected void onSessionSucceeded() {
        if (this.a.a(this.c.f)) {
            this.c.e = this.d;
            if (this.c.e.a(System.currentTimeMillis()) == 0) {
                this.c.e = new bk();
            }
            this.c.d();
        }
    }

    protected void onSessionFailed() {
    }

    protected void onSessionClosed() {
        if (this.b) {
            this.c.a(false, false, null);
        }
    }
}
