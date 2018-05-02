package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.j;
import com.duokan.reader.domain.account.ab;

class fi extends j {
    final /* synthetic */ ab a;
    final /* synthetic */ fh b;
    private DkCloudNoteBookInfo[] c = new DkCloudNoteBookInfo[0];
    private long d = 0;

    fi(fh fhVar, ab abVar) {
        this.b = fhVar;
        this.a = abVar;
    }

    protected void onSessionTry() {
        fn fnVar = new fn(this.a);
        fnVar.b();
        this.c = this.b.c.a(fnVar);
        this.d = fnVar.a().mReadingNoteCount;
    }

    protected void onSessionSucceeded() {
        if (this.a.a(this.b.c.d)) {
            this.b.c.e = this.d;
            this.b.c.d();
            this.b.c.a(this.c);
            this.b.a.a(this.c, true);
            this.b.c.a(this.b.b, this.b.a);
            return;
        }
        this.b.a.a("");
    }

    protected void onSessionFailed() {
        if (this.a.a(this.b.c.d)) {
            this.b.a.a("");
        } else {
            this.b.a.a("");
        }
    }
}
