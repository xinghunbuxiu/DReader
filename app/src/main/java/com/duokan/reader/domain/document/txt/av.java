package com.duokan.reader.domain.document.txt;

class av implements ar {
    final /* synthetic */ e a;
    final /* synthetic */ ai b;
    final /* synthetic */ n c;
    final /* synthetic */ o d;
    final /* synthetic */ au e;

    av(au auVar, e eVar, ai aiVar, n nVar, o oVar) {
        this.e = auVar;
        this.a = eVar;
        this.b = aiVar;
        this.c = nVar;
        this.d = oVar;
    }

    public void a(as asVar) {
        if (!this.a.m()) {
            this.a.a(this.b);
        }
        if (this.c != null) {
            this.c.a(this.d);
        }
        ax axVar = new ax(this.a.k(), null);
        ax axVar2 = new ax(this.a.l(), new aw(this));
        synchronized (this.e) {
            this.e.l.addFirst(axVar2);
            this.e.l.addFirst(axVar);
        }
        this.e.f.release();
        this.e.f.release();
    }

    public void b(as asVar) {
        if (this.c != null) {
            this.c.c(this.d);
        }
    }
}
