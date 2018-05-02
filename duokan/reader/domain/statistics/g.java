package com.duokan.reader.domain.statistics;

class g implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    g(a aVar, int i, String str) {
        this.c = aVar;
        this.a = i;
        this.b = str;
    }

    public void run() {
        if (this.a > this.c.i) {
            this.c.i = this.a;
            this.c.j = this.b;
            h hVar = new h();
            hVar.a = "BaseActivity/cold_start/" + this.b;
            this.c.g.add(hVar);
            this.c.l();
        }
    }
}
