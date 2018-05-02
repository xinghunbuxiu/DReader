package com.duokan.reader.domain.bookshelf;

class cn extends ap {
    final /* synthetic */ cz a;
    final /* synthetic */ bv b;
    private bt c;

    cn(bv bvVar, cz czVar) {
        this.b = bvVar;
        this.a = czVar;
    }

    protected void onSessionTry() {
        if (this.a.b) {
            this.c = new bt();
            return;
        }
        br brVar = new br(this.a.a);
        brVar.a();
        this.c = brVar.b();
    }

    protected void onSessionSucceeded() {
        if (this.a.a.a(this.b.c)) {
            this.b.a(this.c, new co(this));
            return;
        }
        this.a.c.a("");
        a();
    }

    protected void onSessionFailed() {
        this.a.c.a("");
        a();
    }

    private void a() {
        this.b.g.poll();
        this.b.d();
    }
}
