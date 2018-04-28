package com.duokan.reader.domain.document.txt;

class av implements ar {
    /* renamed from: a */
    final /* synthetic */ C0989e f4924a;
    /* renamed from: b */
    final /* synthetic */ ai f4925b;
    /* renamed from: c */
    final /* synthetic */ C0992n f4926c;
    /* renamed from: d */
    final /* synthetic */ C0999o f4927d;
    /* renamed from: e */
    final /* synthetic */ au f4928e;

    av(au auVar, C0989e c0989e, ai aiVar, C0992n c0992n, C0999o c0999o) {
        this.f4928e = auVar;
        this.f4924a = c0989e;
        this.f4925b = aiVar;
        this.f4926c = c0992n;
        this.f4927d = c0999o;
    }

    /* renamed from: a */
    public void mo1462a(as asVar) {
        if (!this.f4924a.m7563m()) {
            this.f4924a.m7552a(this.f4925b);
        }
        if (this.f4926c != null) {
            this.f4926c.mo1464a(this.f4927d);
        }
        ax axVar = new ax(this.f4924a.m7561k(), null);
        ax axVar2 = new ax(this.f4924a.m7562l(), new aw(this));
        synchronized (this.f4928e) {
            this.f4928e.f4923l.addFirst(axVar2);
            this.f4928e.f4923l.addFirst(axVar);
        }
        this.f4928e.f.release();
        this.f4928e.f.release();
    }

    /* renamed from: b */
    public void mo1463b(as asVar) {
        if (this.f4926c != null) {
            this.f4926c.mo1466c(this.f4927d);
        }
    }
}
