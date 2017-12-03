package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.ba;

class ji extends ap {
    final /* synthetic */ ba a;
    final /* synthetic */ String b;
    final /* synthetic */ jk c;
    final /* synthetic */ iz d;
    private final jj e = new jj();

    ji(iz izVar, ba baVar, String str, jk jkVar) {
        this.d = izVar;
        this.a = baVar;
        this.b = str;
        this.c = jkVar;
    }

    protected void onSessionTry() {
        synchronized (this.d.m) {
            this.e.a(this.a.c().b("/Books"));
            this.e.a = this.d.j.c().i();
        }
    }

    protected void onSessionSucceeded() {
        if (b.a(this.b, this.d.i)) {
            synchronized (this.d) {
                this.d.k = this.e;
                this.d.l = true;
            }
            if (this.c != null) {
                this.c.a();
            }
        } else if (this.c != null) {
            this.c.b();
        }
    }

    protected void onSessionFailed() {
        if (this.c != null) {
            this.c.b();
        }
    }
}
